package com.portal.mario.display;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class Stage implements IStage
{
    private static final String WRONG_DEPTH_ERR = "Wrong depth: %s, total number of layers: %s";
    private static final String WRONG_DISPLAY_OBJECT_ERR = "The display object %s was not added to stage";
    List<IDisplayObject> layers = new LinkedList<IDisplayObject>();
    private Graphics graphics;

    public Stage()
    {
        super();
    }
    @Override
    public void addDisplayObject(IDisplayObject displayObject)
    {
        displayObject.setGraphics(graphics);
        layers.add(displayObject);
    }

    @Override
    public void addDisplayObjects(List<IDisplayObject> displayObjects) {
        layers.addAll(displayObjects);
    }

    @Override
    public void setDepth(IDisplayObject displayObject, int depth) {
        if (depth >= layers.size())
        {
            throw new IllegalArgumentException(String.format(WRONG_DEPTH_ERR, depth, layers.size()));
        }
        boolean hasDisplayObject = layers.remove(displayObject);
        if (!hasDisplayObject)
        {
            throw new IllegalArgumentException(String.format(WRONG_DISPLAY_OBJECT_ERR, displayObject.toString()));
        }
        else
        {
            layers.set(depth, displayObject);
        }
    }

    @Override
    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
        for (IDisplayObject displayObject : layers)
        {
            displayObject.setGraphics(graphics);
        }
    }

    @Override
    public boolean contains(IDisplayObject displayObject) {
        return layers.contains(displayObject);
    }

    @Override
    public Iterator<IDisplayObject> iterator() {
        return layers.iterator();
    }

    @Override
    public void render() {
        for (IDisplayObject layer : layers)
        {
            layer.render();
        }
    }
}
