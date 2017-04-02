package com.portal.mario.display;

import com.portal.mario.utilbeans.Point;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public interface ISprite extends IDisplayObject
{
    int getWidth();
    int getHeight();

    void setPoint(Point point);
    Point getPoint();
    void setX(int x);
    void setY(int y);
    void addInnerSprite(ISprite sprite);
}
