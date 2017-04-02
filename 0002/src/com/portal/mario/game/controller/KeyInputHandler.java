package com.portal.mario.game.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

/**
 *  Keyboard event handler
 */
public class KeyInputHandler extends KeyAdapter
{
    private Map<Integer, IKeyController> controllers;
    private IKeyController remController;

    /**
     * Constrictor
     * @param controllers - should be updated according its keys
     */
    public KeyInputHandler(Map<Integer, IKeyController> controllers)
    {
        this.controllers = controllers;
    }

    /**
     * Called by JFrame when some key is pressed
     * @param e - keyboard event (read key code)
     */
    public void keyPressed(KeyEvent e)
    {
        IKeyController keyController = controllers.get(Integer.valueOf(e.getKeyCode()));
        if (keyController != null)
        {
            keyController.keyPressed();
            remController = keyController;
        }
    }
    /**
     * Called by JFrame when some key is released
     * @param e - keyboard event (read key code)
     */
    public void keyReleased(KeyEvent e)
    {
        IKeyController keyController = controllers.get(Integer.valueOf(e.getKeyCode()));
        if (keyController != null)
        {
            keyController.keyReleased();
            remController = null;
        }
    }

    /**
     * Update controller which was selected in method keyPressed
     */
    public void update()
    {
        if (remController != null)
        {
            remController.update();
        }
    }
}
