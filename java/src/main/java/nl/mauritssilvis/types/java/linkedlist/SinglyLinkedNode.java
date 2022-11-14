/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

import nl.mauritssilvis.types.java.node.ForwardNode;

class SinglyLinkedNode<T> implements ForwardNode<T> {
    private T data;
    private ForwardNode<T> next;

    SinglyLinkedNode(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public ForwardNode<T> getNext() {
        return next;
    }

    @Override
    public void setNext(ForwardNode<T> next) {
        this.next = next;
    }
}
