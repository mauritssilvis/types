/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutableObjectArrayTests {
    @Test
    void acceptAnEmptyArrayOfObjects() {
        Object[] objects = new Object[0];
        Assertions.assertDoesNotThrow(() -> new ImmutableObjectArray(objects));
    }

    @Test
    void acceptANonEmptyArrayOfObjects() {
        Object[] objects = new Object[5];
        Assertions.assertDoesNotThrow(() -> new ImmutableObjectArray(objects));
    }

    @Test
    void acceptAnArrayOfIntegersDisguisedAsObjects() {
        int[] integers = {1, 2, 3, 4};
        Object[] objects = new Object[integers.length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = integers[i];
        }

        Assertions.assertDoesNotThrow(() -> new ImmutableObjectArray(objects));
    }

    @Test
    void acceptAnArrayOfStringsDisguisedAsObjects() {
        String[] strings = {"first", "second", "third"};

        Object[] objects = new Object[strings.length];
        System.arraycopy(strings, 0, objects, 0, strings.length);

        Assertions.assertDoesNotThrow(() -> new ImmutableObjectArray(objects));
    }

    @Test
    void storeZeroObjects() {
        Object[] objects = new Object[0];
        ImmutableFixedSizeArray<Object> array = new ImmutableObjectArray(objects);

        Assertions.assertEquals(objects.length, array.getLength());
    }

    @Test
    void storeAllObjects() {
        Object[] objects = new Object[2];
        ImmutableFixedSizeArray<Object> array = new ImmutableObjectArray(objects);

        Assertions.assertAll(
                () -> Assertions.assertEquals(objects.length, array.getLength()),
                () -> Assertions.assertEquals(objects[0], array.get(0)),
                () -> Assertions.assertEquals(objects[1], array.get(1))
        );
    }

    @Test
    void storeAllIntegers() {
        int[] integers = {3, 2, 1};
        Object[] objects = new Object[integers.length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = integers[i];
        }

        ImmutableFixedSizeArray<Object> array = new ImmutableObjectArray(objects);

        Assertions.assertAll(
                () -> Assertions.assertEquals(objects.length, array.getLength()),
                () -> Assertions.assertEquals(objects[0], array.get(0)),
                () -> Assertions.assertEquals(objects[1], array.get(1)),
                () -> Assertions.assertEquals(objects[2], array.get(2)),
                () -> Assertions.assertEquals(integers.length, array.getLength()),
                () -> Assertions.assertEquals(integers[0], array.get(0)),
                () -> Assertions.assertEquals(integers[1], array.get(1)),
                () -> Assertions.assertEquals(integers[2], array.get(2))
        );
    }

    @Test
    void storeAllStrings() {
        String[] strings = {"water", "air", "fire", "earth"};

        Object[] objects = new Object[strings.length];
        System.arraycopy(strings, 0, objects, 0, strings.length);

        ImmutableFixedSizeArray<Object> array = new ImmutableObjectArray(objects);

        Assertions.assertAll(
                () -> Assertions.assertEquals(objects.length, array.getLength()),
                () -> Assertions.assertEquals(objects[0], array.get(0)),
                () -> Assertions.assertEquals(objects[1], array.get(1)),
                () -> Assertions.assertEquals(objects[2], array.get(2)),
                () -> Assertions.assertEquals(objects[3], array.get(3)),
                () -> Assertions.assertEquals(strings.length, array.getLength()),
                () -> Assertions.assertEquals(strings[0], array.get(0)),
                () -> Assertions.assertEquals(strings[1], array.get(1)),
                () -> Assertions.assertEquals(strings[2], array.get(2)),
                () -> Assertions.assertEquals(strings[3], array.get(3))
        );
    }

    @Test
    void storeAnIndependentCopyOfTheIntegers() {
        int[] integers = {3, 2, 1};
        Object[] objects = new Object[integers.length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = integers[i];
        }

        ImmutableFixedSizeArray<Object> array = new ImmutableObjectArray(objects);

        int index = 1;
        objects[index] = 100;

        Assertions.assertAll(
                () -> Assertions.assertNotEquals(objects[index], array.get(index)),
                () -> Assertions.assertEquals(integers[index], array.get(index))
        );
    }

    @Test
    void storeAnIndependentCopyOfTheStrings() {
        String[] strings = {"sun", "sea", "sand"};

        Object[] objects = new Object[strings.length];
        System.arraycopy(strings, 0, objects, 0, strings.length);

        ImmutableFixedSizeArray<Object> array = new ImmutableObjectArray(objects);

        int index = 2;
        objects[index] = "forest";

        Assertions.assertAll(
                () -> Assertions.assertNotEquals(objects[index], array.get(index)),
                () -> Assertions.assertEquals(strings[index], array.get(index))
        );
    }
}
