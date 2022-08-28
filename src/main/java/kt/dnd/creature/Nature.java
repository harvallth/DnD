package kt.dnd.creature;

import java.util.Random;

public enum Nature {
    KOMUNIKATYWNY,
        ZAMKNIETY_W_SOBIE,

    ZNUDZONY,
        CIEKAWSKI,

    ALTRUISTYCZNY,
        INTERESOWNY,
    ROZWAZNY,
        IMPULSYWNY,
    EMPATYCZNY,
        EGOISTYCZNY,
    UPRZEJMY,
        AROGANCKI,
    PROZNY,
        SKROMNY,
    SZCZERY,
        NIESZCZERY,
    PRACOWITY,
        LENIWY,
    BEZINTERESOWNY,
        CHYTRY,
    UFNY,
        PODEJRZLIWY
    ;

    public static Nature getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
