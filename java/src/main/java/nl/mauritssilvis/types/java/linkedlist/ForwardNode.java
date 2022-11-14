/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

class ForwardNode<T> {
    T data;
    ForwardNode<T> next;

    ForwardNode(T data) {
        this.data = data;
    }

    T getData() {
        return this.data;
    }

    void setData(T data) {
        this.data = data;
    }

    ForwardNode<T> getNext() {
        return this.next;
    }

    void setNext(ForwardNode next) {
        this.next = next;
    }
}
