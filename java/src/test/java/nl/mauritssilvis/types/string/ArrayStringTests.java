package nl.mauritssilvis.types.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayStringTests {
    @Test
    void getTheLengthOfAZeroCharacterWord() {
        char[] characters = {};
        String word = new ArrayString(characters);

        Assertions.assertEquals(characters.length, word.length());
    }

    @Test
    void getTheLengthOfAFourCharacterWord() {
        char[] characters = {'w', 'o', 'r', 'd'};
        String word = new ArrayString(characters);

        Assertions.assertEquals(characters.length, word.length());
    }
}