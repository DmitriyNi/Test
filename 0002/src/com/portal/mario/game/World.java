package com.portal.mario.game;

import com.portal.mario.display.AnimationSprite;
import com.portal.mario.display.IAnimationSprite;
import com.portal.mario.display.ISprite;
import com.portal.mario.display.IStage;
import com.portal.mario.factory.SpriteFactory;
import com.portal.mario.utilbeans.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test Class
 */
public class World //implements Runnable
{
    private IStage stage;

    private static final String BACKGROUND_PATH = "resources/background-base.png";
    private static final String MASHROOM_PATH = "resources/Mashroom.png";
    private static final String HERO_BASE_PATH = "resources/Heroes/Mail";
    private static final int SPRITES_COUNT = 3;
    private List<ISprite> backgrounds = new ArrayList<ISprite>(SPRITES_COUNT);
    private static final int SPEED = 10;
    private static final int STEP = 3;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private IAnimationSprite hero;
    private ISprite mash;
    public World(IStage stage)
    {
        this.stage = stage;
        init();
        //new Thread(this).start();
    }
    private void init()
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
        initHero();
        stage.addDisplayObject(hero);
        mash = SpriteFactory.getSprite(MASHROOM_PATH);
        mash.setPoint(new Point(150, 200));
        stage.addDisplayObject(mash);
        stage.setDepth(mash, 2);
    }
    public void moveMash()
    {
        mash.setX(mash.getPoint().getX() + 1);

    }
    private void initHero()
    {

        List<ISprite> moveRight = new ArrayList<ISprite>();
        moveRight.add(SpriteFactory.getSprite(HERO_BASE_PATH + "/MR_F1.png"));
        moveRight.add(SpriteFactory.getSprite(HERO_BASE_PATH + "/MR_F2.png"));
        moveRight.add(SpriteFactory.getSprite(HERO_BASE_PATH + "/MR_F3.png"));
        Map<String, List<ISprite>> heroAnimations = new HashMap<String, List<ISprite>>();
        heroAnimations.put("MOVE_RIGHT", moveRight);
        hero = new AnimationSprite(heroAnimations, 2);
        hero.setPoint(new Point(100, 200));
        hero.play("MOVE_RIGHT");
    }
    public void moveHero(Point deltaPoint)
    {
        Point heroPoint = hero.getPoint();
        heroPoint.setX(heroPoint.getX() + deltaPoint.getX());
        heroPoint.setY(heroPoint.getY() + deltaPoint.getY());
    }
    private void change()
    {
        ISprite first = null;
        ISprite last = null;
        for (ISprite sprite : backgrounds)
        {
            Point point = sprite.getPoint();
            point.setX(point.getX() - STEP);
            sprite.setPoint(point);
            if (first == null || first.getPoint().getX() > point.getX())
            {
                first = sprite;
            }
            if (last == null || last.getPoint().getX() < point.getX())
            {
                last = sprite;
            }
        }
        if (first.getPoint().getX() < WIDTH*(-1.5))
        {
            Point newPoint = new Point(last.getPoint().getX() + WIDTH, 0);
            first.setPoint(newPoint);
        }
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
   /* @Override
    public void run() {
        int timeout = 20;
        int currentIndex = 0;
        int step = 100000 - SPEED;
        while (!Thread.currentThread().isInterrupted())
        {
            if (currentIndex == step)
            {
                currentIndex = 0;
                change();
            }
            ++currentIndex;
           *//* try
            {
                Thread.sleep(timeout);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }*//*
        }
    }*/
}
