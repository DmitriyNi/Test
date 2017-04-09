package com.portal.mario.game;

import com.portal.mario.display.AnimationSprite;
import com.portal.mario.display.IAnimationSprite;
import com.portal.mario.display.ISprite;
import com.portal.mario.display.IStage;
import com.portal.mario.factory.HeroFactory;
import com.portal.mario.factory.SpriteFactory;
import com.portal.mario.game.controller.IKeyController;
import com.portal.mario.game.controller.KeyInputHandler;
import com.portal.mario.game.controller.hero.MoveLeftKeyController;
import com.portal.mario.game.controller.hero.MoveRightKeyController;
import com.portal.mario.game.hero.Hero;
import com.portal.mario.game.hero.IHero;
import com.portal.mario.utilbeans.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Game world class
 * Handles logic of game process
 */
public class World implements IWorld
{
    private IStage stage;
    private static final String BACKGROUND_PATH = "resources/background-base.png";
    private static final int SPRITES_COUNT = 3;
    private static final double HERO_BARRIER_DETERMINATION = 0.75;
    private List<ISprite> backgrounds = new ArrayList<ISprite>(SPRITES_COUNT);
    private final int WIDTH;
    private final int HEIGHT;


    private IHero hero;
    private KeyInputHandler keysController;

    /**
     * Constructor
     * @param stage - stage for display objects
     */
    public World(IStage stage, int width, int height)
    {
        this.stage = stage;
        this.WIDTH = width;
        this.HEIGHT = height;
        initDisplay();
    }

    /**
     * Display objects initialisation of the world
     */
    private void initDisplay()
    {
        backgrounds.addAll(SpriteFactory.getSprites(BACKGROUND_PATH, SPRITES_COUNT));
        int index = 0;
        for (ISprite sprite : backgrounds)
        {
            stage.addDisplayObject(sprite);
            sprite.setX(WIDTH * index);
            sprite.setY(0);
            ++index;
        }

    }
    /**
     * Game controllers initialization
     */
    private void initController()
    {
        Map<Integer, IKeyController> mapControllers = new HashMap<Integer, IKeyController>();
        mapControllers.put(KeyEvent.VK_RIGHT, new MoveRightKeyController(hero, this));
        mapControllers.put(KeyEvent.VK_LEFT, new MoveLeftKeyController(hero, this));
        keysController = new KeyInputHandler(mapControllers);
    }

    /**
     * Retrieving key controllers of the world
     * @return
     */
    public KeyListener getKeysController()
    {
        return keysController;
    }

    /**
     * Update world
     */
    public void update() {
        keysController.update();
    }

    @Override
    public void addHero(IHero hero) {
        this.hero = hero;
/*        hero = HeroFactory.getHero(Hero.HeroType.MALE);*/
        this.hero.setHeroPosition(new Point(100, 218));
        this.hero.stay();
        stage.addDisplayObject((IAnimationSprite) this.hero);
        initController();
    }

    @Override
    public int getWorldWidth() {
        return WIDTH;
    }

    @Override
    public int getWorldHeight() {
        return HEIGHT;
    }

    @Override
    public Point getWorldPosition() {
        return null;
    }

    @Override
    public void moveWorld(Point point) {
        ISprite minBackground = backgrounds.get(0);
        ISprite maxBackground = backgrounds.get(backgrounds.size() - 1);
        for (ISprite sprite : backgrounds)
        {
            if (minBackground.getPoint().getX() > sprite.getPoint().getX())
            {
                minBackground = sprite;
            }
            if (maxBackground.getPoint().getX() < sprite.getPoint().getX())
            {
                maxBackground = sprite;
            }
            sprite.setX(sprite.getPoint().getX() + point.getX());
            sprite.setY(sprite.getPoint().getY() + point.getY());
        }
        if(minBackground.getPoint().getX() < -1*getWorldWidth())
        {
            Point newPoint = new Point(maxBackground.getPoint().getX() + maxBackground.getWidth(), 0);
            minBackground.setPoint(newPoint);
        }
    }

    @Override
    public int getHeroBarrier() {
        return (int) Math.round(WIDTH*HERO_BARRIER_DETERMINATION);
    }
}
