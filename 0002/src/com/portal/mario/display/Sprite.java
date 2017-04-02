package com.portal.mario.display;

import com.portal.mario.utilbeans.*;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class Sprite extends AbstractSprite
{
    private Image image;
    public Sprite(Image image)
    {
        this.image = image;
    }
    public int getWidth()
    {
        return image.getWidth(null);
    }
    public int getHeight()
    {
        return image.getHeight(null);
    }

    @Override
    protected void drawSprite()
    {
        com.portal.mario.utilbeans.Point point = getPoint();
        graphics.drawImage(image, point.getX(), point.getY(), null);
    }
}
