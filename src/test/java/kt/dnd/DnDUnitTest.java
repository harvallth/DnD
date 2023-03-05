package kt.dnd;

import kt.dnd.character.*;
import kt.dnd.character.Character;
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
        Character character = Character.createCharacter("Harv", Race.HUMAN, stats);
        character.addTrait(Trait.ATHLETICS_I);

        // then
        assertTrue(character.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(character.getPerks().get(0).equals(Perk.BLACKSMITH));
    }

    @Test
    public void should_when_givenCharacters(){
        Character harv_w = Character.createCharacter("Harv_weak", Race.DRACONIAN, Stat.of(6, 3, 7, 6, 3, 4));
        Character harv_s = Character.createCharacter("Harv_strong", Race.DWARF, Stat.of(8, 5, 10, 6, 5, 6));
        Character SebaMag = Character.createCharacter("SebaMag", Race.HUMAN, Stat.of(5, 5, 5, 10, 7, 7));

        assertTrue(harv_w.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(harv_w.getPerks().get(0).equals(Perk.BLACKSMITH));
        assertTrue(harv_s.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(harv_s.getPerks().get(0).equals(Perk.BLACKSMITH));
        assertTrue(SebaMag.getTraits().get(0).equals(Trait.ATHLETICS_I));
        assertTrue(SebaMag.getPerks().get(0).equals(Perk.BLACKSMITH));
    }
}