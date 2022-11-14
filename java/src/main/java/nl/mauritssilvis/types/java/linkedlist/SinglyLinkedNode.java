/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

class SinglyLinkedNode<T> {
    private T data;
    private SinglyLinkedNode<T> next;

    SinglyLinkedNode(T data) {
        this.data = data;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    SinglyLinkedNode<T> getNext() {
        return next;
    }

    void setNext(SinglyLinkedNode<T> next) {
        this.next = next;
    }
}
