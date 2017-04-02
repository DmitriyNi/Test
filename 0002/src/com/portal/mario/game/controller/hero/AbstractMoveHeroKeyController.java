package com.portal.mario.game.controller.hero;

import com.portal.mario.display.IAnimationSprite;
import com.portal.mario.game.controller.IKeyController;
import com.portal.mario.game.hero.IHero;
import com.portal.mario.utilbeans.Point;

/**
 * Abstract controller which moves hero whether to the right or left
 */
public abstract class AbstractMoveHeroKeyController implements IKeyController
{
    // Hero under control
    private IHero hero;
    // Iteration of frame animation
    private int currentIteration;
    // If the parameter true than the controller can be updated
    private boolean isPressed;
    public AbstractMoveHeroKeyController(IHero hero)
    {
        this.hero = hero;
        currentIteration = 0;
        isPressed = false;
    }
    @Override
    public void keyPressed() {
        setAnimation();
        isPressed = true;
        currentIteration = 0;
    }
    @Override
    public void keyReleased()
    {
        isPressed = false;
        hero.stay();
        currentIteration = 0;
    }
    protected void moveHero(Point deltaPoint)
    {
        Point heroPoint = hero.getHeroPosition();
        heroPoint.setX(heroPoint.getX() + deltaPoint.getX());
        heroPoint.setY(heroPoint.getY() + deltaPoint.getY());
    }

    protected IHero getHero()
    {
        return hero;
    }
    @Override
    public void update()
    {
        //  If key was released then we don't have to update this controller
        if (!isPressed) return;
        //  Determines if animation can go to next frame
        if (currentIteration == SPEED_MUL * ((IAnimationSprite) hero).getSpeed())
        {
            moveAction();
            currentIteration = 0;
        }
        else
        {
            ++currentIteration;
        }
    }
    abstract void moveAction();
    abstract void setAnimation();

}
