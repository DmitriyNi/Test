package com.portal.mario.game.factory;

import com.portal.mario.display.ISprite;
import com.portal.mario.display.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class SpriteFactory
{
    private static final String MODULE = "0002/";
    private static final Map<String, BufferedImage> imageCache = new HashMap<String, BufferedImage>();
    public static ISprite getSprite(String resource)
    {

        String path = MODULE + resource;
        BufferedImage sourceImage = imageCache.get(path);
        if (sourceImage == null)
        {
            try
            {
                sourceImage = ImageIO.read(new FileInputStream(path));
                imageCache.put(path, sourceImage);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        ISprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));
        return sprite;
    }
    public static java.util.List<ISprite> getSprites(String path, int quantity)
    {
        List<ISprite> retValue = new ArrayList<ISprite>();
        int i;
        for(i = 0; i<quantity; i++)
        {
            retValue.add(getSprite(path));
        }
        return retValue;
    }

}
