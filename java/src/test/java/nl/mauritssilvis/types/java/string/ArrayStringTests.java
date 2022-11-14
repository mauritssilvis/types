/*
 * Copyright © 2021, 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.Objects;

class ArrayStringTests {
    @Test
    void constructAnEmptyString() {
        Assertions.assertDoesNotThrow((ThrowingSupplier<ArrayString>) ArrayString::new);
    }

    @Test
    void createAnEmptyString() {
        String str = new ArrayString();

        Assertions.assertEquals(0, str.length());
    }

    @Test
    void acceptAnEmptyArrayOfCharacters() {
        char[] chars = {};
        Assertions.assertDoesNotThrow(() -> new ArrayString(chars));
    }

    @Test
    void acceptANonEmptyArrayOfCharacters() {
        char[] chars = {'e', 'a', 'r', 't', 'h'};
        Assertions.assertDoesNotThrow(() -> new ArrayString(chars));
    }

    @Test
    void storeZeroCharacters() {
        char[] chars = {};
        String str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.length());
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
    void storeZeroCharactersLikeAnEmptyString() {
        char[] chars = {};

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString();

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void storeZeroCharactersLikeAJavaString() {
        char[] chars = {};

        java.lang.String javaStr = new java.lang.String(chars);
        String str = new ArrayString(chars);

        Assertions.assertEquals(javaStr.length(), str.length());
    }

    @Test
    void storeTheSameCharactersAsAJavaString() {
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
    void acceptAnEmptyString() {
        char[] chars = {};
        String str = new ArrayString(chars);

        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void acceptANonEmptyString() {
        char[] chars = {'c', 'l', 'o', 'u', 'd'};
        String str = new ArrayString(chars);

        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void storeAnEmptyString() {
        char[] chars = {};

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(str1);

        Assertions.assertAll(
                () -> Assertions.assertNotSame(str1, str2),
                () -> Assertions.assertEquals(str1, str2)
        );
    }

    @Test
    void storeANonEmptyString() {
        char[] chars = {'b', 'i', 'r', 'd'};

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(str1);

        Assertions.assertAll(
                () -> Assertions.assertNotSame(str1, str2),
                () -> Assertions.assertEquals(str1, str2)
        );
    }

    @Test
    void storeAnEmptyStringLikeAnEmptyString() {
        char[] chars = {};
        String str = new ArrayString(chars);

        String str1 = new ArrayString(str);
        String str2 = new ArrayString();

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromEmptyCharacterArraysAndStrings() {
        char[] chars = {};
        String str = new ArrayString(chars);

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(str);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromNonEmptyCharacterArraysAndStrings() {
        char[] chars = {'s', 'k', 'y'};
        String str = new ArrayString(chars);

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(str);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void acceptAnEmptyJavaString() {
        java.lang.String javaStr = "";
        Assertions.assertDoesNotThrow(() -> new ArrayString(javaStr));
    }

    @Test
    void acceptANonEmptyJavaString() {
        java.lang.String javaStr = "river";
        Assertions.assertDoesNotThrow(() -> new ArrayString(javaStr));
    }

    @Test
    void storeAnEmptyJavaString() {
        java.lang.String javaStr = "";
        String str = new ArrayString(javaStr);

        Assertions.assertEquals(0, str.length());
    }

    @Test
    void storeANonEmptyJavaString() {
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
    void storeAnEmptyJavaStringLikeAnEmptyString() {
        char[] chars = {};
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(javaStr);
        String str2 = new ArrayString();

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromEmptyCharacterArraysAndJavaStrings() {
        char[] chars = {};
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromNonEmptyCharacterArraysAndJavaStrings() {
        char[] chars = {'o', 'c', 'e', 'a', 'n'};
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(chars);
        String str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromEmptyStringsAndJavaStrings() {
        char[] chars = {};

        String str = new ArrayString(chars);
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(str);
        String str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromNonEmptyStringsAndJavaStrings() {
        char[] chars = {'s', 'e', 'a'};

        String str = new ArrayString(chars);
        java.lang.String javaStr = new java.lang.String(chars);

        String str1 = new ArrayString(str);
        String str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
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
    void getTheSameCharactersAsFromAJavaString() {
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
    void evaluatesAsEmptyForAnEmptyString() {
        String str = new ArrayString();

        Assertions.assertTrue(str.isEmpty());
    }

    @Test
    void evaluatesAsEmptyForAnEmptyCharacterArray() {
        char[] chars = {};
        String str = new ArrayString(chars);

        Assertions.assertTrue(str.isEmpty());
    }

    @Test
    void evaluatesAsNonEmptyForANonEmptyCharacterArray() {
        char[] chars = {'l', 'a', 'k', 'e'};
        String str = new ArrayString(chars);

        Assertions.assertFalse(str.isEmpty());
    }

    @Test
    void evaluatesAsEmptyForAnEmptyJavaString() {
        java.lang.String javaStr = "";
        String str = new ArrayString(javaStr);

        Assertions.assertTrue(str.isEmpty());
    }

    @Test
    void evaluatesAsNonEmptyForANonEmptyJavaString() {
        java.lang.String javaStr = "ocean";
        String str = new ArrayString(javaStr);

        Assertions.assertFalse(str.isEmpty());
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
    void convertFromAndToAnEmptyCharacterArray() {
        char[] chars = {};
        String str = new ArrayString(chars);

        Assertions.assertEquals(0, str.toCharArray().length);
    }

    @Test
    void convertFromAndToAFourCharacterArray() {
        char[] charsIn = {'w', 'a', 'v', 'e'};
        String str = new ArrayString(charsIn);

        char[] charsOut = str.toCharArray();

        Assertions.assertAll(
                () -> Assertions.assertEquals(charsIn.length, charsOut.length),
                () -> Assertions.assertEquals(charsIn[0], charsOut[0]),
                () -> Assertions.assertEquals(charsIn[1], charsOut[1]),
                () -> Assertions.assertEquals(charsIn[2], charsOut[2]),
                () -> Assertions.assertEquals(charsIn[3], charsOut[3])
        );
    }

    @Test
    void retrieveAnIndependentCopyOfTheCharacters() {
        char[] charsIn = {'s', 'e', 'a'};
        String str = new ArrayString(charsIn);

        char[] charsOut = str.toCharArray();

        int index = 2;
        charsOut[index] = 'e';

        Assertions.assertNotEquals(charsOut[index], str.charAt(index));
    }

    @Test
    void doesHaveADifferentHashCodeThanNull() {
        String str = new ArrayString("coast");

        Assertions.assertNotEquals(Objects.hashCode(null), str.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanAnEmptyString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsFirstCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("c");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsLastCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("t");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsBeginning() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("co");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsEnding() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("ast");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanADifferentlySizedString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("sand");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanADifferentStringOfTheSameSize() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("beach");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanAStringWithSimilarCharacters() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("comet");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanAnAnagram() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("costa");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsTheSameString() {
        String str = new ArrayString("coast");

        Assertions.assertEquals(str.hashCode(), str.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsADifferentVariablePointingToTheSameString() {
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
    void doesNotEqualNull() {
        String str = new ArrayString("coast");

        Assertions.assertNotEquals(null, str);
    }

    @Test
    void doesNotEqualAJavaString() {
        String str = new ArrayString("coast");
        java.lang.String javaStr = "coast";

        Assertions.assertFalse(str.equals(javaStr));
    }

    @Test
    void doesNotEqualAnEmptyString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsFirstCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("c");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsLastCharacter() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("t");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsBeginning() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("co");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsEnding() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("ast");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualADifferentlySizedString() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("sand");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualADifferentStringOfTheSameSize() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("beach");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualAStringWithSimilarCharacters() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("comet");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualAnAnagram() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("costa");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesEqualTheSameString() {
        String str = new ArrayString("coast");

        Assertions.assertEquals(str, str);
    }

    @Test
    void doesEqualADifferentVariablePointingToTheSameString() {
        String str1 = new ArrayString("coast");
        String str2 = str1;

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void doesEqualAStringWithTheSameContents() {
        String str1 = new ArrayString("coast");
        String str2 = new ArrayString("coast");

        Assertions.assertEquals(str1, str2);
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