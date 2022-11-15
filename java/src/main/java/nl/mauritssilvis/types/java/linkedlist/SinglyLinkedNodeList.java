/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

import nl.mauritssilvis.types.java.node.ForwardNode;
import nl.mauritssilvis.types.java.node.Node;

public class SinglyLinkedNodeList<T> implements LinkedList<T> {
    private int size;
    private ForwardNode<T> head;
    private ForwardNode<T> tail;

    @Override
    public void add(T element) {
        ForwardNode<T> newNode = new SinglyLinkedNode<>(element);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNode(index);
        return node.getData();
    }

    @Override
    public void set(int index, T element) {
        Node<T> node = getNode(index);
        node.setData(element);
    }

    private ForwardNode<T> getNode(int index) {
        verifyIndex(index);

        ForwardNode<T> node = head;

        for (int i = 1; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    private void verifyIndex(int index) {
        if (index < 0 || index >= size) {
            String msg = "Index %d out of bounds for singly linked list of size %d.".formatted(index, size);
            throw new IndexOutOfBoundsException(msg);
        }
    }
}
