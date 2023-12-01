/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.array;

public class ImmutableObjectArray implements ImmutableFixedSizeArray<Object> {
    private final Object[] elements;
    private final int length;

    public ImmutableObjectArray(Object[] elements) {
        this.elements = elements.clone();
        length = elements.length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }
}
