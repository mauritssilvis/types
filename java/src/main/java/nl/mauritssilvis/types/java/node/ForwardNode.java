/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.node;

public interface ForwardNode<T> extends Node<T> {
    boolean hasNext();

    ForwardNode<T> getNext();

    void setNext(ForwardNode<T> next);
}
