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
    void storeTheSameCharacters() {
        char[] chars = {'s', 'e', 'a'};

        java.lang.String javaStr = new java.lang.String(chars);
        String str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.length(), str.length()),
                () -> Assertions.assertEquals(javaStr.charAt(0), str.charAt(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.charAt(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.charAt(2))
        );
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
    void acceptAJavaString() {
        java.lang.String str = "lake";
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
    void getEqualStrings() {
        char[] chars = {'o', 'c', 'e', 'a', 'n'};
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(javaStr);

        Assertions.assertAll(
                () -> Assertions.assertEquals(str1.length(), str2.length()),
                () -> Assertions.assertEquals(str1.charAt(0), str2.charAt(0)),
                () -> Assertions.assertEquals(str1.charAt(1), str2.charAt(1)),
                () -> Assertions.assertEquals(str1.charAt(2), str2.charAt(2)),
                () -> Assertions.assertEquals(str1.charAt(3), str2.charAt(3)),
                () -> Assertions.assertEquals(str1.charAt(4), str2.charAt(4))
        );
    }

    @Test
    void doNotGetACharacterWithANegativeIndex() {
        String str = new ArrayString("tree");

        int index = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> str.charAt(index));
    }

    @Test
    void doNotGetACharacterBeyondTheStringLength() {
        String str = new ArrayString("mountain");

        int index = str.length();

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
    void getTheSameCharacters() {
        char[] chars = {'r', 'i', 'v', 'e', 'r'};

        java.lang.String javaStr = new java.lang.String(chars);
        String str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.charAt(0), str.charAt(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.charAt(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.charAt(2)),
                () -> Assertions.assertEquals(javaStr.charAt(3), str.charAt(3)),
                () -> Assertions.assertEquals(javaStr.charAt(4), str.charAt(4))
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

    @Test
    void getTheSameLength() {
        java.lang.String javaStr = "forest";
        String str = new ArrayString(javaStr);

        Assertions.assertEquals(javaStr.length(), str.length());
    }
}