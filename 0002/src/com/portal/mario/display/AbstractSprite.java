package com.portal.mario.display;

import com.portal.mario.utilbeans.Point;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractSprite implements ISprite
{
    protected Graphics graphics;
    private Point point = new Point(0, 0);
    private List<ISprite> sprites = new ArrayList<ISprite>();
    public void setGraphics(Graphics graphics)
    {
        this.graphics = graphics;
    }

    public void setPoint(Point point)
    {
        this.point = point;
    }
    public Point getPoint()
    {
        return point;
    }

    public void setX(int x)
    {
        point.setX(x);
    }

    public void setY(int y)
    {
        point.setY(y);
    }
    public void addInnerSprite(ISprite sprite)
    {
        sprites.add(sprite);
    }
    public void render()
    {
        for (ISprite sprite : sprites)
        {
            sprite.render();
        }
        drawSprite();
    }
    protected abstract void drawSprite();

}
