package com.portal.mario.display;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 02.04.17
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class AnimationSprite extends AbstractAnimationSprite
{
    private static final int SPEED_MUL = 100;
    private int currentIteration;
    private ISprite currentSprite;

    public AnimationSprite (Map<String, List<ISprite>> animations, int speed)
    {
        super();
        super.setSprites(animations);
        super.setSpeed(speed);
        currentIteration = 0;
    }
    @Override
    protected void drawSprite()
    {
        ++currentIteration;
        if (currentIteration == getSpeed() * SPEED_MUL)
        {
            currentIteration = 0;
            currentSprite = next();
        }
        if (currentSprite != null)
        {
            currentSprite.setPoint(getPoint());
            currentSprite.setGraphics(graphics);
            currentSprite.render();
        }
        else
        {
            currentSprite = next();
        }
    }

    @Override
    public int getWidth() {
        return currentSprite.getWidth();
    }

    @Override
    public int getHeight() {
        return currentSprite.getHeight();
    }
}
