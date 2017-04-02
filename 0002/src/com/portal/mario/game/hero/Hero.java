package com.portal.mario.game.hero;

import com.portal.mario.display.AnimationSprite;
import com.portal.mario.display.ISprite;
import com.portal.mario.utilbeans.Point;

import java.util.*;

/**
 *
 */
public class Hero extends AnimationSprite implements IHero
{
    private static final String MOVE_RIGHT = "move-right";
    private static final String MOVE_LEFT = "move-left";
    private static final String STAY = "stay";
    private String currentAnimation = "";
    private static final int DEFAULT_SPEED = 2;
    public Hero(Map<String, List<ISprite>> animations)
    {
        super(animations, DEFAULT_SPEED);
    }
    @Override
    public void moveRight() {
        currentAnimation(MOVE_RIGHT);
    }

    @Override
    public void moveLeft() {
        currentAnimation(MOVE_LEFT);
    }

    @Override
    public void jump() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void fire() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stay() {
        currentAnimation(STAY);
    }
    private void currentAnimation(String currentAnimation)
    {
        if (!this.currentAnimation.equals(currentAnimation))
        {
            this.currentAnimation = currentAnimation;
            play(currentAnimation);
        }
    }

    @Override
    public int getHealth() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addHealth(int health) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxHealth() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Point getHeroPosition() {
        return getPoint();
    }

    @Override
    public void setHeroPosition(Point point) {
        setPoint(point);
    }

    @Override
    public void setDamage(int damage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Hero type which determines his animation sprites
     */
    public static enum HeroType
    {
        MALE
                {
                    @Override
                    public Map<String, List<String>> getAnimations()
                    {

                        return getPathCombination(getBasePath(MALE_FOLDER));
                    }
                },
        FEMALE
                {
                    @Override
                    public Map<String, List<String>> getAnimations() {
                        return getPathCombination(getBasePath(FEMALE_FOLDER));
                    }
                };
        private static final String BASE_PATH = "resources/Heroes";
        private static final String SEPARATOR = "/";
        private static final String MALE_FOLDER = "Male";
        private static final String FEMALE_FOLDER = "Female";

        public abstract Map<String, List<String>> getAnimations();
        private static String getBasePath(String folder)
        {
            StringBuilder builder = new StringBuilder();
            builder.append(BASE_PATH);
            builder.append(SEPARATOR);
            builder.append(folder);
            builder.append(SEPARATOR);
            return builder.toString();
        }
        private static Map<String, List<String>> getAnimationImages()
        {
            Map<String, List<String>> retValue = new HashMap<String, List<String>>();
            List<String> moveRightList = Arrays.asList("MR_F1.png", "MR_F2.png", "MR_F3.png");
            List<String> moveLeftList = Arrays.asList("ML_F1.png", "ML_F2.png", "ML_F3.png");
            List<String> stayList = Arrays.asList("S_F1.png");
            retValue.put(MOVE_RIGHT, moveRightList);
            retValue.put(MOVE_LEFT, moveLeftList);
            retValue.put(STAY, stayList);
            return retValue;
        }
        private static Map<String, List<String>> getPathCombination(String path)
        {
            Map<String, List<String>> fileNames = getAnimationImages();
            Map<String, List<String>> retValue = new HashMap<String, List<String>>();
            List<String> pathToFiles;
            String key;
            for (Map.Entry<String, List<String>> entry : fileNames.entrySet())
            {
                pathToFiles = new ArrayList<String>();
                key = entry.getKey();
                for(String fileName :entry.getValue())
                {
                    pathToFiles.add(path + fileName);
                }
                retValue.put(key, pathToFiles);
            }
            return retValue;
        }
    }
}
