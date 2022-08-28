package test.java.dnd.creature;

import kt.dnd.creature.Nature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NatureTest {

    @Test
    public void shouldReturnRandomNature_whenGetRandom() {
        Nature nature = Nature.getRandom();
        assertNotEquals(Nature.getRandom(), nature);
    }

}