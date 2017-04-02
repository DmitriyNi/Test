import com.portal.mario.display.IStage;
import com.portal.mario.display.Stage;
import com.portal.mario.game.KeyInputHandler;
import com.portal.mario.game.World;
import com.portal.mario.utilbeans.*;
import com.portal.mario.utilbeans.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 8:35
 * To change this template use File | Settings | File Templates.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    public static int WIDTH = 400;
    public static int HEIGHT = 300;
    public static String NAME = "TUTORIAL 1";

    private static final int SPEED_MUL = 10;
    private int currentIteration;

    //private com.portal.mario.display.Sprite hero;
    private IStage stage;
    private World world;
    private KeyInputHandler keyInput;

    private boolean running = false;
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;
        init();
        while (running)
        {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            update(delta);
            render();
        }
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //выход из приложения по нажатию клавиши ESC
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER); //добавляем холст на наш фрейм
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        game.start();

    }
    public void start()
    {
        running = true;
        new Thread(this).start();
    }
    public void update(long delta)
    {
        if (keyInput != null && currentIteration == SPEED_MUL*2)
        {
            if (keyInput.isRightPressed())
            {
                world.moveHero(new Point(1, 0));
            }
            if (keyInput.isLeftPressed())
            {
               world.moveHero(new Point(-1, 0));
            }
            currentIteration = 0;
            world.moveMash();
       }
        ++currentIteration;

    }
    public void render()
    {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null)
        {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        Graphics g = bs.getDrawGraphics();

        stage.setGraphics(g);
        stage.render();
        /*g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();*/


       /* hero.setGraphics(g);
        hero.setPoint(new com.portal.mario.utilbeans.Point(0, 0));
        hero.render();*/
        g.dispose();
        bs.show();
    }
    public void init()
    {
        //hero = getSprite("resources/background-base.png");
        stage = new Stage();
        world = new World(stage);
        keyInput = new KeyInputHandler();
        currentIteration = 0;
        addKeyListener(keyInput);
    }
    


}
