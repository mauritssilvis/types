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
    void acceptZeroArguments() {
        Assertions.assertDoesNotThrow((ThrowingSupplier<ArrayString>) ArrayString::new);
    }

    @Test
    void createAnEmptyString() {
        ImmutableString str = new ArrayString();

        Assertions.assertEquals(0, str.getLength());
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
        ImmutableString str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.getLength());
    }

    @Test
    void storeAllCharacters() {
        char[] chars = {'m', 'o', 'o', 'n'};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars.length, str.getLength()),
                () -> Assertions.assertEquals(chars[0], str.getChar(0)),
                () -> Assertions.assertEquals(chars[1], str.getChar(1)),
                () -> Assertions.assertEquals(chars[2], str.getChar(2)),
                () -> Assertions.assertEquals(chars[3], str.getChar(3))
        );
    }

    @Test
    void storeAnIndependentCopyOfTheCharacters() {
        char[] chars = {'s', 'u', 'n'};
        ImmutableString str = new ArrayString(chars);

        int index = 1;
        chars[index] = 'o';

        Assertions.assertNotEquals(chars[index], str.getChar(index));
    }

    @Test
    void storeZeroCharactersLikeAnEmptyString() {
        char[] chars = {};

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString();

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void storeZeroCharactersLikeAJavaString() {
        char[] chars = {};

        String javaStr = new String(chars);
        ImmutableString str = new ArrayString(chars);

        Assertions.assertEquals(javaStr.length(), str.getLength());
    }

    @Test
    void storeTheSameCharactersAsAJavaString() {
        char[] chars = {'s', 't', 'a', 'r'};

        String javaStr = new String(chars);
        ImmutableString str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.length(), str.getLength()),
                () -> Assertions.assertEquals(javaStr.charAt(0), str.getChar(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.getChar(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.getChar(2)),
                () -> Assertions.assertEquals(javaStr.charAt(3), str.getChar(3))
        );
    }

    @Test
    void acceptAnEmptyString() {
        char[] chars = {};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void acceptANonEmptyString() {
        char[] chars = {'c', 'l', 'o', 'u', 'd'};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertDoesNotThrow(() -> new ArrayString(str));
    }

    @Test
    void storeAnEmptyString() {
        char[] chars = {};

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString(str1);

        Assertions.assertAll(
                () -> Assertions.assertNotSame(str1, str2),
                () -> Assertions.assertEquals(str1, str2)
        );
    }

    @Test
    void storeANonEmptyString() {
        char[] chars = {'b', 'i', 'r', 'd'};

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString(str1);

        Assertions.assertAll(
                () -> Assertions.assertNotSame(str1, str2),
                () -> Assertions.assertEquals(str1, str2)
        );
    }

    @Test
    void storeAnEmptyStringLikeAnEmptyString() {
        char[] chars = {};
        ImmutableString str = new ArrayString(chars);

        ImmutableString str1 = new ArrayString(str);
        ImmutableString str2 = new ArrayString();

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromEmptyCharacterArraysAndStrings() {
        char[] chars = {};
        ImmutableString str = new ArrayString(chars);

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString(str);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromNonEmptyCharacterArraysAndStrings() {
        char[] chars = {'s', 'k', 'y'};
        ImmutableString str = new ArrayString(chars);

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString(str);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void acceptAnEmptyJavaString() {
        String javaStr = "";
        Assertions.assertDoesNotThrow(() -> new ArrayString(javaStr));
    }

    @Test
    void acceptANonEmptyJavaString() {
        String javaStr = "river";
        Assertions.assertDoesNotThrow(() -> new ArrayString(javaStr));
    }

    @Test
    void storeAnEmptyJavaString() {
        String javaStr = "";
        ImmutableString str = new ArrayString(javaStr);

        Assertions.assertEquals(0, str.getLength());
    }

    @Test
    void storeANonEmptyJavaString() {
        String javaStr = "lake";
        ImmutableString str = new ArrayString(javaStr);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.length(), str.getLength()),
                () -> Assertions.assertEquals(javaStr.charAt(0), str.getChar(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.getChar(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.getChar(2)),
                () -> Assertions.assertEquals(javaStr.charAt(3), str.getChar(3))
        );
    }

    @Test
    void storeAnEmptyJavaStringLikeAnEmptyString() {
        char[] chars = {};
        String javaStr = new String(chars);

        ImmutableString str1 = new ArrayString(javaStr);
        ImmutableString str2 = new ArrayString();

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromEmptyCharacterArraysAndJavaStrings() {
        char[] chars = {};
        String javaStr = new String(chars);

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromNonEmptyCharacterArraysAndJavaStrings() {
        char[] chars = {'o', 'c', 'e', 'a', 'n'};
        String javaStr = new String(chars);

        ImmutableString str1 = new ArrayString(chars);
        ImmutableString str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromEmptyStringsAndJavaStrings() {
        char[] chars = {};

        ImmutableString str = new ArrayString(chars);
        String javaStr = new String(chars);

        ImmutableString str1 = new ArrayString(str);
        ImmutableString str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getEqualStringsFromNonEmptyStringsAndJavaStrings() {
        char[] chars = {'s', 'e', 'a'};

        ImmutableString str = new ArrayString(chars);
        String javaStr = new String(chars);

        ImmutableString str1 = new ArrayString(str);
        ImmutableString str2 = new ArrayString(javaStr);

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void getTheLengthOfAZeroCharacterString() {
        char[] chars = {};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.getLength());
    }

    @Test
    void getTheLengthOfAFourCharacterString() {
        char[] chars = {'t', 'r', 'e', 'e'};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertEquals(chars.length, str.getLength());
    }

    @Test
    void getTheSameLength() {
        String javaStr = "forest";
        ImmutableString str = new ArrayString(javaStr);

        Assertions.assertEquals(javaStr.length(), str.getLength());
    }

    @Test
    void evaluatesAsEmptyForAnEmptyString() {
        ImmutableString str = new ArrayString();

        Assertions.assertTrue(str.isEmpty());
    }

    @Test
    void evaluatesAsEmptyForAnEmptyCharacterArray() {
        char[] chars = {};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertTrue(str.isEmpty());
    }

    @Test
    void evaluatesAsNonEmptyForANonEmptyCharacterArray() {
        char[] chars = {'l', 'a', 'k', 'e'};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertFalse(str.isEmpty());
    }

    @Test
    void evaluatesAsEmptyForAnEmptyJavaString() {
        String javaStr = "";
        ImmutableString str = new ArrayString(javaStr);

        Assertions.assertTrue(str.isEmpty());
    }

    @Test
    void evaluatesAsNonEmptyForANonEmptyJavaString() {
        String javaStr = "ocean";
        ImmutableString str = new ArrayString(javaStr);

        Assertions.assertFalse(str.isEmpty());
    }

    @Test
    void doNotGetACharacterWithANegativeIndex() {
        ImmutableString str = new ArrayString("valley");

        int index = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> str.getChar(index));
    }

    @Test
    void doNotGetACharacterBeyondTheStringLength() {
        ImmutableString str = new ArrayString("mountain");

        int index = str.getLength();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> str.getChar(index));
    }

    @Test
    void getEachCharacter() {
        char[] chars = {'h', 'i', 'l', 'l'};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(chars[0], str.getChar(0)),
                () -> Assertions.assertEquals(chars[1], str.getChar(1)),
                () -> Assertions.assertEquals(chars[2], str.getChar(2)),
                () -> Assertions.assertEquals(chars[3], str.getChar(3))
        );
    }

    @Test
    void getTheSameCharactersAsFromAJavaString() {
        char[] chars = {'p', 'l', 'a', 'i', 'n'};

        String javaStr = new String(chars);
        ImmutableString str = new ArrayString(chars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(javaStr.charAt(0), str.getChar(0)),
                () -> Assertions.assertEquals(javaStr.charAt(1), str.getChar(1)),
                () -> Assertions.assertEquals(javaStr.charAt(2), str.getChar(2)),
                () -> Assertions.assertEquals(javaStr.charAt(3), str.getChar(3)),
                () -> Assertions.assertEquals(javaStr.charAt(4), str.getChar(4))
        );
    }

    @Test
    void convertFromAndToAnEmptyCharacterArray() {
        char[] chars = {};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertEquals(0, str.toCharArray().length);
    }

    @Test
    void convertFromAndToAFourCharacterArray() {
        char[] charsIn = {'w', 'a', 'v', 'e'};
        ImmutableString str = new ArrayString(charsIn);

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
        ImmutableString str = new ArrayString(charsIn);

        char[] charsOut = str.toCharArray();

        int index = 2;
        charsOut[index] = 'e';

        Assertions.assertNotEquals(charsOut[index], str.getChar(index));
    }

    @Test
    void doesHaveADifferentHashCodeThanNull() {
        ImmutableString str = new ArrayString("coast");

        Assertions.assertNotEquals(Objects.hashCode(null), str.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanAnEmptyString() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsFirstCharacter() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("c");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsLastCharacter() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("t");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsBeginning() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("co");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanItsEnding() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("ast");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanADifferentlySizedString() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("sand");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanADifferentStringOfTheSameSize() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("beach");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanAStringWithSimilarCharacters() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("comet");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesHaveADifferentHashCodeThanAnAnagram() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("costa");

        Assertions.assertNotEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsTheSameString() {
        ImmutableString str = new ArrayString("coast");

        Assertions.assertEquals(str.hashCode(), str.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsADifferentVariablePointingToTheSameString() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = str1;

        Assertions.assertEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void hasTheSameHashCodeAsAStringWithTheSameContents() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("coast");

        Assertions.assertEquals(str1.hashCode(), str2.hashCode());
    }

    @Test
    void doesNotEqualNull() {
        ImmutableString str = new ArrayString("coast");

        Assertions.assertNotEquals(null, str);
    }

    @Test
    void doesNotEqualAJavaString() {
        ImmutableString str = new ArrayString("coast");
        String javaStr = "coast";

        Assertions.assertFalse(str.equals(javaStr));
    }

    @Test
    void doesNotEqualAnEmptyString() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsFirstCharacter() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("c");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsLastCharacter() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("t");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsBeginning() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("co");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualItsEnding() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("ast");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualADifferentlySizedString() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("sand");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualADifferentStringOfTheSameSize() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("beach");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualAStringWithSimilarCharacters() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("comet");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesNotEqualAnAnagram() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("costa");

        Assertions.assertNotEquals(str1, str2);
    }

    @Test
    void doesEqualTheSameString() {
        ImmutableString str = new ArrayString("coast");

        Assertions.assertEquals(str, str);
    }

    @Test
    void doesEqualADifferentVariablePointingToTheSameString() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = str1;

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void doesEqualAStringWithTheSameContents() {
        ImmutableString str1 = new ArrayString("coast");
        ImmutableString str2 = new ArrayString("coast");

        Assertions.assertEquals(str1, str2);
    }

    @Test
    void convertFromACharacterArrayToAJavaString() {
        char[] chars = {'l', 'a', 'n', 'd'};
        ImmutableString str = new ArrayString(chars);

        Assertions.assertEquals(new String(chars), str.toString());
    }

    @Test
    void convertFromAndToAJavaString() {
        String javaStr = "stone";
        ImmutableString str = new ArrayString(javaStr);

        Assertions.assertEquals(javaStr, str.toString());
    }
}