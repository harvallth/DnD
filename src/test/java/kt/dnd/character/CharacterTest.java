package kt.dnd.character;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class CharacterTest {

    private Character classUnderTest;

    @Test
    public void shouldGenerateRandomCharacter_whenCreateRandomCharacter() {
        //given

        //when
        Character actual = classUnderTest.createRandomCharacter();

        System.out.println("Spells: " + actual.getSpells());
        System.out.println("Skills: " + actual.getSkills());

        //then
        assertThat(actual.getName(), is("Random"));
    }

}