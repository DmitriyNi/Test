package com.portal.mario.display;

import java.util.List;
import java.util.Map;

/**
 */
public interface IAnimationSprite extends ISprite
{
    /**
     *  Sets map of different animations
     *  key - name of animation
     *  value - list of sequences animation
     */
    void setSprites(Map<String, List<ISprite>> sprites);

    /**
     * add new sequence of animations for the key
     * @param key - key of animation
     * @param sprites - sequence of animation
     */
    void addAnimation(String key, List<ISprite> sprites);

    /**
     * Animation speed frame change
     * @param speed
     */
    void setSpeed(int speed);

    /**
     * select the animation to play
     * @param key
     */
    void play(String key);

    ISprite next();
    int getSpeed();
}
