package nl.mauritssilvis.types.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class ArrayStringTests {
    @Test
    void acceptAnArrayOfCharacters() {
        char[] chars = {'e', 'a', 'r', 't', 'h'};
        Assertions.assertDoesNotThrow(() -> new ArrayString(chars));
    }

    @Test
    void storeAllCharacters() {
        char[] chars = {'m', 'o', 'o', 'n'};
        String str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars.length, str.length()),
                () -> Assertions.assertEquals(chars[0], str.charAt(0)),
                () -> Assertions.assertEquals(chars[1], str.charAt(1)),
                () -> Assertions.assertEquals(chars[2], str.charAt(2)),
                () -> Assertions.assertEquals(chars[3], str.charAt(3))
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
    void storeTheSameCharacters() {
        char[] chars = {'s', 't', 'a', 'r'};

        java.lang.String javaStr = new java.lang.String(chars);
        String str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.length(), str.length()),
                () -> Assertions.assertEquals(javaStr.charAt(0), str.charAt(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.charAt(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.charAt(2)),
                () -> Assertions.assertEquals(javaStr.charAt(3), str.charAt(3))
        );
    }

    @Test
    void acceptAString() {
        char[] chars = {'c', 'l', 'o', 'u', 'd'};
        String str = new ArrayString(chars);

        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void storeTheFullString() {
        char[] chars = {'b', 'i', 'r', 'd'};

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(str1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(str1.length(), str2.length()),
                () -> Assertions.assertEquals(str1.charAt(0), str2.charAt(0)),
                () -> Assertions.assertEquals(str1.charAt(1), str2.charAt(1)),
                () -> Assertions.assertEquals(str1.charAt(2), str2.charAt(2)),
                () -> Assertions.assertEquals(str1.charAt(3), str2.charAt(3))
        );
    }

    @Test
    void getEqualStringsFromCharactersAndStrings() {
        char[] chars = {'s', 'k', 'y'};
        String str = new ArrayString(chars);

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(str);

        Assertions.assertAll(
                () -> Assertions.assertEquals(str1.length(), str2.length()),
                () -> Assertions.assertEquals(str1.charAt(0), str2.charAt(0)),
                () -> Assertions.assertEquals(str1.charAt(1), str2.charAt(1)),
                () -> Assertions.assertEquals(str1.charAt(2), str2.charAt(2))
        );
    }

    @Test
    void acceptAJavaString() {
        java.lang.String javaStr = "river";
        Assertions.assertDoesNotThrow(() -> new ArrayString(javaStr));
    }

    @Test
    void storeTheFullJavaString() {
        java.lang.String javaStr = "lake";
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
    void getEqualStringsFromCharactersAndJavaStrings() {
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
    void getEqualStringsFromStringsAndJavaStrings() {
        char[] chars = {'s', 'e', 'a'};

        String str = new ArrayString(chars);
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(str);
        String str2 = new ArrayString(javaStr);

        Assertions.assertAll(
                () -> Assertions.assertEquals(str1.length(), str2.length()),
                () -> Assertions.assertEquals(str1.charAt(0), str2.charAt(0)),
                () -> Assertions.assertEquals(str1.charAt(1), str2.charAt(1)),
                () -> Assertions.assertEquals(str1.charAt(2), str2.charAt(2))
        );
    }

    @Test
    void doNotGetACharacterWithANegativeIndex() {
        String str = new ArrayString("valley");

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
        char[] chars = {'h', 'i', 'l', 'l'};
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
        char[] chars = {'p', 'l', 'a', 'i', 'n'};

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
    void isNotEqualToNull() {
        String str = new ArrayString("coast");

        Assertions.assertFalse(str.equals(null));
    }

    @Test
    void isNotEqualToAJavaString() {
        String str = new ArrayString("coast");
        java.lang.String javaStr = "coast";

        Assertions.assertFalse(str.equals(javaStr));
    }

    @Test
    void isNotEqualToAnEmptyString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToItsFirstCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("c");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToItsLastCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("t");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToItsBeginning() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("co");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToItsEnding() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("oast");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToADifferentlySizedString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("sand");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToAStringOfTheSameSize() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("beach");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToAStringWithSimilarCharacters() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("comet");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void isNotEqualToAnAnagram() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("costa");

        Assertions.assertFalse(str1.equals(str2));
    }

    @Test
    void equalsTheSameString() {
        String str1 = new ArrayString("coast");
        String str2 = str1;

        Assertions.assertTrue(str1.equals(str2));
    }

    @Test
    void equalsAStringWithTheSameContents() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("coast");

        Assertions.assertTrue(str1.equals(str2));
    }

    @Test
    void hasADifferentHashCodeThanNull() {
        String str = new ArrayString("coast");

        Assertions.assertNotEquals(str.hashCode(), Objects.hashCode(null));
    }

    @Test
    void hasADifferentHashCodeThanAnEmptyString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanItsFirstCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("c");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanItsLastCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("t");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanItsBeginning() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("co");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanItsEnding() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("oast");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanADifferentlySizedString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("sand");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanAStringOfTheSameSize() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("beach");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanAStringWithSimilarCharacters() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("comet");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasADifferentHashCodeThanAnAnagram() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("costa");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsTheSameString() {
        String str1 = new ArrayString("coast");
        String str2 = str1;

        Assertions.assertEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsAStringWithTheSameContents() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("coast");

        Assertions.assertEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void getTheLengthOfAZeroCharacterString() {
        char[] chars = {};
        String str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.length());
    }

    @Test
    void getTheLengthOfAFourCharacterString() {
        char[] chars = {'t', 'r', 'e', 'e'};
        String str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.length());
    }

    @Test
    void getTheSameLength() {
        java.lang.String javaStr = "forest";
        String str = new ArrayString(javaStr);

        Assertions.assertEquals(javaStr.length(), str.length());
    }

    @Test
    void convertFromACharacterArrayToAJavaString() {
        char[] chars = {'l', 'a', 'n', 'd'};
        String str = new ArrayString(chars);

        Assertions.assertEquals(new java.lang.String(chars), str.toString());
    }

    @Test
    void convertFromAndToAJavaString() {
        java.lang.String javaStr = "stone";
        String str = new ArrayString(javaStr);

        Assertions.assertEquals(javaStr, str.toString());
    }
}