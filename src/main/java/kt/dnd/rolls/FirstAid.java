package kt.dnd.rolls;

import kt.dnd.character.Character;
import kt.dnd.character.Perk;

public class FirstAid extends Roll {

    private int modifier;

    @Override
    public void test(Character character) {
        if (character.getPerks().contains(Perk.CHARLATAN))
            modifier += 2;
    }
}
