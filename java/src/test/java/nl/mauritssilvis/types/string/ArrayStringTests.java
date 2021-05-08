package nl.mauritssilvis.types.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayStringTests {
    @Test
    void acceptAnArrayOfCharacters() {
        char[] chars = {'e', 'a', 'r', 't', 'h'};
        Assertions.assertDoesNotThrow(() -> new ArrayString(chars));
    }

    @Test
    void storeAnIndependentCopyOfTheCharacters() {
        char[] chars = {'s', 'u', 'n'};
        String word = new ArrayString(chars);

        int index = 1;
        chars[index] = 'o';

        Assertions.assertNotEquals(chars[index], word.charAt(index));
    }

    @Test
    void storeAllCharacters() {
        char[] chars = {'s', 'k', 'y'};
        String word = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars.length, word.length()),
                () -> Assertions.assertEquals(chars[0], word.charAt(0)),
                () -> Assertions.assertEquals(chars[1], word.charAt(1)),
                () -> Assertions.assertEquals(chars[2], word.charAt(2))
        );
    }

    @Test
    void acceptAJavaString() {
        java.lang.String str = "sea";
        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void storeTheFullJavaString() {
        java.lang.String str = "moon";
        String word = new ArrayString(str);

        Assertions.assertAll(
                () -> Assertions.assertEquals(str.length(), word.length()),
                () -> Assertions.assertEquals(str.charAt(0), word.charAt(0)),
                () -> Assertions.assertEquals(str.charAt(1), word.charAt(1)),
                () -> Assertions.assertEquals(str.charAt(2), word.charAt(2)),
                () -> Assertions.assertEquals(str.charAt(3), word.charAt(3))
        );
    }

    @Test
    void doNotGetACharacterWithANegativeIndex() {
        char[] chars = {'l', 'a', 'k', 'e'};
        String word = new ArrayString(chars);

        int index = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> word.charAt(index));
    }

    @Test
    void doNotGetACharacterBeyondTheStringLength() {
        char[] chars = {'m', 'o', 'u', 'n', 't', 'a', 'i', 'm'};
        String word = new ArrayString(chars);

        int index = chars.length;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> word.charAt(index));
    }

    @Test
    void getEachCharacter() {
        char[] chars = {'l', 'a', 'n', 'd'};
        String word = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars[0], word.charAt(0)),
                () -> Assertions.assertEquals(chars[1], word.charAt(1)),
                () -> Assertions.assertEquals(chars[2], word.charAt(2)),
                () -> Assertions.assertEquals(chars[3], word.charAt(3))
        );
    }

    @Test
    void getTheLengthOfAZeroCharacterString() {
        char[] chars = {};
        String word = new ArrayString(chars);

        Assertions.assertEquals(chars.length, word.length());
    }

    @Test
    void getTheLengthOfAFourCharacterString() {
        char[] chars = {'h', 'i', 'l', 'l'};
        String word = new ArrayString(chars);

        Assertions.assertEquals(chars.length, word.length());
    }
}