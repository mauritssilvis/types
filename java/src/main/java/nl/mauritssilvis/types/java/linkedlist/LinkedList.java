/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

public interface LinkedList<E> {
    void add(E element);

    E get(int index);

    void set(int index, E element);
}
