package com.portal.mario.game;

import com.portal.mario.display.IAnimationSprite;
import com.portal.mario.display.ISprite;
import com.portal.mario.display.IStage;
import com.portal.mario.game.factory.SpriteFactory;
import com.portal.mario.game.controller.IKeyController;
import com.portal.mario.game.controller.KeyInputHandler;
import com.portal.mario.game.controller.hero.MoveLeftKeyController;
import com.portal.mario.game.controller.hero.MoveRightKeyController;
import com.portal.mario.game.hero.IHero;
import com.portal.mario.game.location.ILocation;
import com.portal.mario.utilbeans.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

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
    private ILocation location;

    /**
     * Constructor
     * @param stage - stage for display objects
     */
    private World(IStage stage, int width, int height, ILocation location)
    {
        this.stage = stage;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.location = location;
        initDisplay();
    }

    /**
     * Display objects initialisation of the world
     */
    private void initDisplay()
    {
        /*backgrounds.addAll(SpriteFactory.getSprites(BACKGROUND_PATH, SPRITES_COUNT));
        int index = 0;
        for (ISprite sprite : backgrounds)
        {
            stage.addDisplayObject(sprite);
            sprite.setX(WIDTH * index);
            sprite.setY(0);
            ++index;
        }*/
        location.renderAtStage(stage);

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
        /*ISprite minBackground = backgrounds.get(0);
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
        }*/
        /*Point locPosition = location.getPosition();
        Point newPosition = new Point(locPosition.getX() + point.getY(), locPosition.getY() + point.getY());*/
        location.setPosition(point);
    }

    @Override
    public int getHeroBarrier() {
        return (int) Math.round(WIDTH*HERO_BARRIER_DETERMINATION);
    }

    public static class Builder
    {
        private IHero hero;
        private IStage stage;
        private int width = 0;
        private int height = 0;
        private ILocation location;
        public Builder addStage(IStage stage)
        {
            this.stage = stage;
            return this;
        }
        public Builder addHero(IHero hero)
        {
            this.hero = hero;
            return this;
        }
        public Builder setWidth(int width)
        {
            this.width = width;
            return this;
        }
        public Builder setHeight(int height)
        {
            this.height = height;
            return this;
        }
        public Builder addLocation(ILocation location)
        {
            this.location = location;
            return this;
        }
        public IWorld build()
        {

            if (width > 0 && height > 0 && stage != null && hero != null && location != null)
            {
                IWorld world = new World(stage, width, height, location);
                world.addHero(hero);
                return world;
            }
            else
            {
                throw new RuntimeException("You have not set enough objects to build the World");
            }
        }
    }
}
