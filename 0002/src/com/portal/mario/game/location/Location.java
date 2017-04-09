package com.portal.mario.game.location;

import com.portal.mario.display.ISprite;
import com.portal.mario.display.IStage;
import com.portal.mario.display.Sprite;
import com.portal.mario.game.factory.SpriteFactory;
import com.portal.mario.utilbeans.Point;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 09.04.17
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class Location implements ILocation
{
    private final static String SEPARATOR = "/";
    private final String BASE_PATH;
    private final Properties PROPERTIES;
    private final String IMAGES_FOLDER;
    private final int CHUNK_SIZE;

    private ISprite background;
    private List<List<ISprite>> sprites;
    private Point point;

    private List<ISprite> nonEmptySprites;
    public Location(Properties properties, String basePath)
    {
        BASE_PATH = basePath;
        PROPERTIES = properties;
        IMAGES_FOLDER = PROPERTIES.getProperty("loc.images.folder");
        CHUNK_SIZE = Integer.parseInt(PROPERTIES.getProperty("loc.chunk.size"));
        initBackground();
        try {
            initLocation();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    private void initBackground()
    {
        String backgroundFileName = PROPERTIES.getProperty("loc.background");
        background = SpriteFactory.getSprite(BASE_PATH+SEPARATOR+IMAGES_FOLDER+SEPARATOR+backgroundFileName);
    }
    private void initLocation() throws Exception
    {
        String locMapPath = "0002/" + BASE_PATH + SEPARATOR + PROPERTIES.getProperty("loc.map");
        BufferedReader br = new BufferedReader(new FileReader(locMapPath));
        List<List<Character>> map = new ArrayList<List<Character>>();
        String line;
        while ((line=br.readLine()) != null)
        {
            List<Character> charLine = new ArrayList<Character>();
            map.add(charLine);
            for (int i = 0; i<line.length(); i++)
            {
                charLine.add(line.charAt(i));
            }
        }
        Character emptyChar = PROPERTIES.getProperty("loc.chunk.empty").charAt(0);
        sprites = new ArrayList<List<ISprite>>();
        int l = map.get(0).size();
        for(int i=0; i<l; i++)
        {
            List<ISprite> column = new ArrayList<ISprite>();
            sprites.add(column);
            for (int j=0; j<map.size(); j++)
            {
                Character currentChar = map.get(j).get(i);
                if (!currentChar.equals(emptyChar))
                {
                    String fileName =  PROPERTIES.getProperty("loc.chunk." + String.valueOf(currentChar));
                    ISprite newSprite = SpriteFactory.getSprite(BASE_PATH+SEPARATOR+IMAGES_FOLDER+SEPARATOR+fileName);
                    newSprite.setPoint(new Point(i*CHUNK_SIZE, j*CHUNK_SIZE));
                    column.add(newSprite);
                }
                else
                {
                    column.add(null);
                }
            }
        }
        point = new Point(0, 0);

    }

    @Override
    public void setPosition(Point point)
    {

        Point delta = new Point(this.point.getX() - point.getX(), this.point.getY() - point.getY());
        ISprite firstSprite = nonEmptySprites.get(0);
        ISprite lastSprite = nonEmptySprites.get(nonEmptySprites.size() - 1);
        if (firstSprite.getPoint().getX() + delta.getX() > 0)
        {
            delta = new Point(this.point.getX(), delta.getY());
        }

        for (ISprite sprite : nonEmptySprites)
        {
            sprite.setPoint(new Point(sprite.getPoint().getX() + delta.getX(), sprite.getPoint().getY() + delta.getY()));
        }
    }

    @Override
    public Point getPosition() {
        return point;
    }

    @Override
    public void update() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void renderAtStage(IStage stage) {
        nonEmptySprites = new ArrayList<ISprite>();
        stage.addDisplayObject(background);
        for (List<ISprite> columns : sprites)
        {
            for (ISprite currentSprite : columns)
            {
                if(currentSprite != null)
                {
                    nonEmptySprites.add(currentSprite);
                    stage.addDisplayObject(currentSprite);
                }
            }
        }
    }

}
