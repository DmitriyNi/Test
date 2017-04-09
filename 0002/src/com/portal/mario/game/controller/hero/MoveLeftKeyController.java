package com.portal.mario.game.controller.hero;

import com.portal.mario.game.IWorld;
import com.portal.mario.game.hero.IHero;
import com.portal.mario.utilbeans.Point;

/**
 * Controller which moves hero to the left
 */
public class MoveLeftKeyController extends AbstractMoveHeroKeyController
{
    public MoveLeftKeyController(IHero hero, IWorld world)
    {
        super(hero, world);
    }

    @Override
    void moveAction() {
        moveHero(new Point(-1, 0));
    }

    @Override
    void setAnimation() {
        getHero().moveLeft();
    }
}
