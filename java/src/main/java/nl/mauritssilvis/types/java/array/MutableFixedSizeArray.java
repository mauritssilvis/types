/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.array;

public interface MutableFixedSizeArray<E> extends ImmutableFixedSizeArray<E> {
    void set(int index, E element);
}
