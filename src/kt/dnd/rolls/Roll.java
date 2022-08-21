package kt.dnd.rolls;

import kt.dnd.character.Character;

public abstract class Roll {
    public int testLevel;
    public int modifier;
    public Difficulty difficulty;

    abstract public void test(Character character);

    enum Difficulty {
        ADVANTAGE,
        DISADVANTAGE,
        NONE;
    }
}
