package test.java.dnd;

import kt.dnd.DnD;
import kt.dnd.character.Character;
import kt.dnd.character.Trait;
import kt.dnd.character.Stat;
import kt.dnd.character.Perk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DnDUnitTest {

    private DnD classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new DnD();
    }

    @Test
    public void shouldCreateNewCharacterWithNormalizedStats_whenCreateCharacter_givenRandomStats(){
        // given
        List<Stat> stats = Stat.random();

        // when
        Character character = Character.createCharacter("Harv", stats);

        // then
        assertTrue(character.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(character.getPerks().get(0).equals(Perk.BLACKSMITH));
    }

    @Test
    public void should_when_givenCharacters(){
        Character harv_w = Character.createCharacter("Harv_weak", Stat.of(6, 3, 7, 6, 3, 4));
        Character harv_s = Character.createCharacter("Harv_strong", Stat.of(8, 5, 10, 6, 5, 6));
        Character SebaMag = Character.createCharacter("SebaMag", Stat.of(5, 5, 5, 10, 7, 7));

        assertTrue(harv_w.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(harv_w.getPerks().get(0).equals(Perk.BLACKSMITH));
        assertTrue(harv_s.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(harv_s.getPerks().get(0).equals(Perk.BLACKSMITH));
        assertTrue(SebaMag.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(SebaMag.getPerks().get(0).equals(Perk.BLACKSMITH));
    }
}