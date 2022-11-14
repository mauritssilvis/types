/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

import nl.mauritssilvis.types.java.node.ForwardNode;

public class SinglyLinkedNodeList<T> implements LinkedList<T> {
    private int size;
    private ForwardNode<T> head;

    @Override
    public void add(T element) {
        if (size == 0) {
            head = new SinglyLinkedNode<>(element);
            size = 1;
            return;
        }

        ForwardNode<T> lastNode = getNode(size - 1);
        lastNode.setNext(new SinglyLinkedNode<>(element));
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            String msg = "Index %d out of bounds for singly linked list of size %d.".formatted(index, size);
            throw new IndexOutOfBoundsException(msg);
        }

        ForwardNode<T> node = getNode(index);
        return node.getData();
    }

    private ForwardNode<T> getNode(int index) {
        ForwardNode<T> node = head;

        for (int i = 1; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }
}
