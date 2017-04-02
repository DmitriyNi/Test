package com.portal.mario.display;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 01.04.17
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
public interface IDisplayObject
{
    void render();
    void setGraphics(Graphics graphics);
}
