package com.portal.mario.display;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public interface IStage
{
    void addDisplayObject(IDisplayObject displayObject);
    void addDisplayObjects(List<IDisplayObject> displayObjects);
    void setDepth(IDisplayObject displayObject, int depth);
    void setGraphics(Graphics graphics);
    boolean contains(IDisplayObject displayObject);
    Iterator<IDisplayObject> iterator();
    void render();
}
