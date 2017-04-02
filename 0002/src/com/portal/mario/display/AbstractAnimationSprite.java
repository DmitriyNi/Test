package com.portal.mario.display;

import com.portal.mario.utilbeans.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 02.04.17
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAnimationSprite extends AbstractSprite implements IAnimationSprite
{
    private Map<String, List<ISprite>> animations = new HashMap<String, List<ISprite>>();
    private List<ISprite> currentAnimation = null;
    private int currentIndex;
    private Point point;
    private int speed = 0;
    /**
     *  Sets map of different animations
     *  key - name of animation
     *  value - list of sequences animation
     */
    public void setSprites(Map<String, List<ISprite>> sprites)
    {
        animations = sprites;
    }

    /**
     * add new sequence of animations for the key
     * @param key - key of animation
     * @param sprites - sequence of animation
     */
    public void addAnimation(String key, List<ISprite> sprites)
    {
        animations.put(key, sprites);
    }

    /**
     * Animation speed frame change
     * @param speed
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    /**
     * select the animation to play
     * @param key
     */
    public void play(String key)
    {
        currentAnimation = animations.get(key);
        currentIndex = 0;
    }

    public ISprite next()
    {
        ISprite retValue = null;
        if (currentAnimation != null && currentAnimation.size() > 0)
        {
            currentIndex = (currentIndex < currentAnimation.size()-1) ? (currentIndex + 1) : 0;
            retValue = currentAnimation.get(currentIndex);
        }
        else
        {

        }
        return retValue;
    }
    @Override
    public int getSpeed()
    {
        return speed;
    }
    @Override
    public void setPoint(Point point)
    {
        this.point = point;
    }
    @Override
    public Point getPoint()
    {
        return point;
    }
    @Override
    public void setX(int x)
    {
        point.setX(x);
    }

    @Override
    public void setY(int y)
    {
        point.setY(y);
    }
}
