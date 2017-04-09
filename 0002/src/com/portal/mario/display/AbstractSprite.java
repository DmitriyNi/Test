package com.portal.mario.display;

import com.portal.mario.utilbeans.Point;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract sprite base logic of sprites drawing
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
        if (sprites.size() > 0)
        {
            Point oldPoint = this.point;
            Point deltaPoint = new Point(oldPoint.getX() - point.getX(), oldPoint.getY() - point.getY());
            for (ISprite sprite : sprites)
            {
                Point spritePoint = sprite.getPoint();
                Point newSpritePoint = new Point(spritePoint.getX() + deltaPoint.getX(), spritePoint.getY() + deltaPoint.getY());
                sprite.setPoint(newSpritePoint);
            }
        }
        this.point = point;
    }
    public Point getPoint()
    {
        return point;
    }

    public void setX(int x)
    {
        if (sprites.size() > 0)
        {
            int oldX = point.getX();
            int deltaX = oldX - x;
            for (ISprite sprite : sprites)
            {
                int spriteX = sprite.getPoint().getX();
                int newSpriteX = spriteX + deltaX;
                sprite.setX(newSpriteX);
            }
        }
        point.setX(x);
    }

    public void setY(int y)
    {
        if (sprites.size() > 0)
        {
            int oldY = point.getY();
            int deltaY = oldY - y;
            for (ISprite sprite : sprites)
            {
                int spriteY = sprite.getPoint().getY();
                int newSpriteY = spriteY + deltaY;
                sprite.setY(newSpriteY);
            }
        }
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
