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
        String str = new ArrayString(chars);

        int index = 1;
        chars[index] = 'o';

        Assertions.assertNotEquals(chars[index], str.charAt(index));
    }

    @Test
    void storeAllCharacters() {
        char[] chars = {'s', 'k', 'y'};
        String str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars.length, str.length()),
                () -> Assertions.assertEquals(chars[0], str.charAt(0)),
                () -> Assertions.assertEquals(chars[1], str.charAt(1)),
                () -> Assertions.assertEquals(chars[2], str.charAt(2))
        );
    }

    @Test
    void acceptAJavaString() {
        java.lang.String str = "sea";
        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void storeTheFullJavaString() {
        java.lang.String javaStr = "moon";
        String str = new ArrayString(javaStr);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.length(), str.length()),
                () -> Assertions.assertEquals(javaStr.charAt(0), str.charAt(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.charAt(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.charAt(2)),
                () -> Assertions.assertEquals(javaStr.charAt(3), str.charAt(3))
        );
    }

    @Test
    void doNotGetACharacterWithANegativeIndex() {
        char[] chars = {'l', 'a', 'k', 'e'};
        String str = new ArrayString(chars);

        int index = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> str.charAt(index));
    }

    @Test
    void doNotGetACharacterBeyondTheStringLength() {
        char[] chars = {'m', 'o', 'u', 'n', 't', 'a', 'i', 'm'};
        String str = new ArrayString(chars);

        int index = chars.length;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> str.charAt(index));
    }

    @Test
    void getEachCharacter() {
        char[] chars = {'l', 'a', 'n', 'd'};
        String str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars[0], str.charAt(0)),
                () -> Assertions.assertEquals(chars[1], str.charAt(1)),
                () -> Assertions.assertEquals(chars[2], str.charAt(2)),
                () -> Assertions.assertEquals(chars[3], str.charAt(3))
        );
    }

    @Test
    void getTheLengthOfAZeroCharacterString() {
        char[] chars = {};
        String str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.length());
    }

    @Test
    void getTheLengthOfAFourCharacterString() {
        char[] chars = {'h', 'i', 'l', 'l'};
        String str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.length());
    }
}