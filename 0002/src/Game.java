import com.portal.mario.display.IStage;
import com.portal.mario.display.Stage;
import com.portal.mario.game.IWorld;
import com.portal.mario.game.factory.HeroFactory;
import com.portal.mario.game.World;
import com.portal.mario.game.hero.Hero;
import com.portal.mario.game.location.ILocation;
import com.portal.mario.game.location.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 */
public class  Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    public static int WIDTH = 400;
    public static int HEIGHT = 300;
    public static String NAME = "TEST GAME";

    private IStage stage;
    private IWorld world;
    private KeyListener keyInput;

    private boolean running = false;
    /**
     * Game Enter point
     * @param args - empty
     */
    public static void main(String[] args)
    {
        //  Create new game object - main game controller
        Game game = new Game();
        //  Determine canvas size (Canvas method)
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //  Initialization of window object
        JFrame frame = new JFrame(Game.NAME);
        //  Exit by "Esc" key
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  Create window layout
        frame.setLayout(new BorderLayout());
        //  Add canvas to window
        frame.add(game, BorderLayout.CENTER);
        //  Set window properties
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        // Test for pull request
        //  Run thread for the game
        game.start();

    }

    /**
     * Start game
     */
    public void start()
    {
        running = true;
        new Thread(this).start();
    }
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
        // Init game
        try
        {
            init();
            while (running)
            {
                delta = System.currentTimeMillis() - lastTime;
                lastTime = System.currentTimeMillis();
                update(delta);
                render();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

   /**
     * The method updates game process
     * @param delta - delta time between running
     */
    public void update(long delta)
    {
        //  Update the game world
        world.update();
    }

    /**
     * Stage rendering
     */
    public void render()
    {
        //  canvas buffer strategy (related to approach of rendering images on canvas)
        BufferStrategy bs = getBufferStrategy();
        if (bs == null)
        {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        //  retrieving graphics object which is drawing current frame
        Graphics g = bs.getDrawGraphics();
        //  TODO Incapsulate the graphics object
        //  set graphics to render each element of the stage
        stage.setGraphics(g);
        //  TODO set graphics object on rendering stage to improve performance
        //  render the stage
        stage.render();
        //  show rendered image on canvas
        g.dispose();
        bs.show();
    }

    /**
     * Initialization of the game
     */
    public void init() throws Exception
    {
        // Create new Stage (each object which can be displayed has to be added on the stage)
        stage = new Stage();
        //  Create new world controller, all separate parts of the game should be controlled by the World class

        Properties properties = new Properties();
        properties.load(new FileReader("0002/resources/Locations/Location-01-TestLocation/location.properties"));
        ILocation location = new Location(properties, "resources/Locations/Location-01-TestLocation");

        World.Builder builder = new World.Builder();
        world = builder.setHeight(HEIGHT).
                setWidth(WIDTH).
                addStage(stage).
                addHero(HeroFactory.getHero(Hero.HeroType.MALE)).
                addLocation(location).
                build();

        //  Retrieving world key controller (the controller handles keyboard events)
        keyInput = world.getKeysController();
        //  Registration of the key controlled on canvas
        addKeyListener(keyInput);
    }
    


}
