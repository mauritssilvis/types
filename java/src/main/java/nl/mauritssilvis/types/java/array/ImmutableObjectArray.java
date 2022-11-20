/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.array;

public class ImmutableObjectArray implements ImmutableFixedSizeArray<Object> {
    private final Object[] elements;

    public ImmutableObjectArray(Object[] elements) {
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }
}
