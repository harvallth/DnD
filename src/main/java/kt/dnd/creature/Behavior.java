package kt.dnd.creature;

import java.util.Random;

public enum Behavior {
    GADATLIWY,
    NIESMIALY,
    NERWOWY,
    SPOKOJNY
    ;

    public static Behavior getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
