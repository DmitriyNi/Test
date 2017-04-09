package com.portal.mario.game.controller.hero;

import com.portal.mario.game.IWorld;
import com.portal.mario.game.hero.IHero;
import com.portal.mario.utilbeans.Point;

/**
 * Controller which moves hero to the right
 */
public class MoveRightKeyController extends AbstractMoveHeroKeyController
{
    /**
     * Constructor
     * @param hero - hero for the controller
     */
    public MoveRightKeyController(IHero hero, IWorld world)
    {
        super(hero, world);
    }
    @Override
    public void moveAction()
    {
        moveHero(new Point(1, 0));
    }

    @Override
    void setAnimation() {
        getHero().moveRight();
    }

}
