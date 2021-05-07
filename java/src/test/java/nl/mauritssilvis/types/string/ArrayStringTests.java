package nl.mauritssilvis.types.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayStringTests {
    @Test
    void doNotGetACharacterWithANegativeIndex() {
        char[] chars = {};
        String word = new ArrayString(chars);

        int index = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> word.charAt(index));
    }

    @Test
    void getTheZerothCharacterOfAFourCharacterString() {
        char[] chars = {'w', 'o', 'r', 'd'};
        String word = new ArrayString(chars);

        int index = 0;

        Assertions.assertEquals(chars[index], word.charAt(index));
    }

    @Test
    void doNotGetACharacterBeyondTheStringLength() {
        char[] chars = {'w', 'o', 'r', 'd'};
        String word = new ArrayString(chars);

        int index = chars.length;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> word.charAt(index));
    }

    @Test
    void getTheLengthOfAZeroCharacterString() {
        char[] chars = {};
        String word = new ArrayString(chars);

        Assertions.assertEquals(chars.length, word.length());
    }

    @Test
    void getTheLengthOfAFourCharacterString() {
        char[] chars = {'w', 'o', 'r', 'd'};
        String word = new ArrayString(chars);

        Assertions.assertEquals(chars.length, word.length());
    }
}