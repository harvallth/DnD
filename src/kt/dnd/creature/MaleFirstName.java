package kt.dnd.creature;

import java.util.Random;

public enum MaleFirstName {
    ADAM,
    EMIL,
    THOMAS,
    JERRY,
    JACOB;

    public static MaleFirstName getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
