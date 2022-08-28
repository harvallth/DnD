package test.java.dnd.creature;

import kt.dnd.creature.Npc;
import org.junit.jupiter.api.Test;

class NpcTest {

    @Test
    public void shouldCreateRandomNPC(){
        new Npc("Jan Nowak", true);
    }

}