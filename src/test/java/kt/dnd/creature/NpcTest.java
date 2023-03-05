package kt.dnd.creature;

import org.junit.jupiter.api.Test;

class NpcTest {

    @Test
    public void shouldCreateRandomNPC(){
        new Npc("Jan Nowak", true);
    }

}