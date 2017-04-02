package com.portal.mario.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Yurchik
 * Date: 02.04.17
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class KeyInputHandler extends KeyAdapter
{
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }
    }
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }
    }
    public boolean isLeftPressed()
    {
        return leftPressed;
    }
    public boolean isRightPressed()
    {
        return rightPressed;
    }
}
