package com.portal.mario.game.hero;

import com.portal.mario.utilbeans.Point;

/**
 *  Hero interface
 */
public interface IHero
{
    /**
     * Select animation (to the right)
     */
    void moveRight();
    /**
     * Select animation (to the left)
     */
    void moveLeft();
    /**
     * Select animation (jumping)
     */
    void jump();
    /**
     * Select animation (fire)
     */
    void fire();
    /**
     * Select animation (stay)
     */
    void stay();
    /**
     * Get hero position on a stage
     * @return - hero position
     */
    Point getHeroPosition();

    /**
     * Set hero position on a stage
     * @param point - new hero position
     */
    void setHeroPosition(Point point);

    int getHealth();
    void addHealth(int health);
    int getMaxHealth();
    void setDamage(int damage);
}
