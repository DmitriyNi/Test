package com.portal.mario.game.location;

import com.portal.mario.display.ISprite;
import com.portal.mario.display.IStage;
import com.portal.mario.utilbeans.Point;

/**
 * Base location interface
 */
public interface ILocation
{
    void setPosition(Point point);
    Point getPosition();
    void update();
    void renderAtStage(IStage stage);
}
