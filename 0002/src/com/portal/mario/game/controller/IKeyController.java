package com.portal.mario.game.controller;

/**
 *  Key controller interface (executed when corresponding key was pressed)
 */
public interface IKeyController
{
    static final int SPEED_MUL = 10;
    void keyPressed();
    void keyReleased();
    void update();
}
