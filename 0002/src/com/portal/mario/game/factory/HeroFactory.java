package com.portal.mario.game.factory;

import com.portal.mario.display.ISprite;
import com.portal.mario.game.hero.Hero;
import com.portal.mario.game.hero.IHero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hero factory, loads all sprites to hero animation
 */
public class HeroFactory
{
    public static IHero getHero(Hero.HeroType type)
    {
        Map<String, List<ISprite>> animations = new HashMap<String, List<ISprite>>();
        Map<String, List<String>> images = type.getAnimations();
        for (Map.Entry<String, List<String>> entry : images.entrySet())
        {

            List<ISprite> sprites = new ArrayList<ISprite>();
            animations.put(entry.getKey(), sprites);
            for (String path : entry.getValue())
            {
                sprites.add(SpriteFactory.getSprite(path));
            }
        }
        IHero hero = new Hero(animations);
        return hero;
    }

}
