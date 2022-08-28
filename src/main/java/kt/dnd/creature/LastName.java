package kt.dnd.creature;

import java.util.Random;

public enum LastName {
    SMITH,
    BRIGHT,
    SLAV,
    LISTNER,
    OBSERVER;

    public static LastName getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
