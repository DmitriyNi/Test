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
public class World
{
    private IStage stage;
    private static final String BACKGROUND_PATH = "resources/background-base.png";
    private static final int SPRITES_COUNT = 3;
    private List<ISprite> backgrounds = new ArrayList<ISprite>(SPRITES_COUNT);
    private static final int WIDTH = 400;

    private IHero hero;
    private KeyInputHandler keysController;

    /**
     * Constructor
     * @param stage - stage for display objects
     */
    public World(IStage stage)
    {
        this.stage = stage;
        initDisplay();
        initController();
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
        hero = HeroFactory.getHero(Hero.HeroType.MALE);
        hero.setHeroPosition(new Point(100, 218));
        hero.stay();
        stage.addDisplayObject((IAnimationSprite) hero);
    }

    /**
     * Game controllers initialization
     */
    private void initController()
    {
        Map<Integer, IKeyController> mapControllers = new HashMap<Integer, IKeyController>();
        mapControllers.put(KeyEvent.VK_RIGHT, new MoveRightKeyController(hero));
        mapControllers.put(KeyEvent.VK_LEFT, new MoveLeftKeyController(hero));
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
}
