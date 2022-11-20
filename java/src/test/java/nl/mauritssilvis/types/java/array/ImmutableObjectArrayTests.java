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
}
