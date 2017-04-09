package com.portal.mario.game;

import com.portal.mario.game.hero.IHero;
import com.portal.mario.utilbeans.Point;

import java.awt.event.KeyListener;

/**
 * Common world interface
 */
public interface IWorld
{
    void addHero(IHero hero);
    int getWorldWidth();
    int getWorldHeight();
    Point getWorldPosition();
    void moveWorld(Point point);
    int getHeroBarrier();
    void update();
    KeyListener getKeysController();
}
