/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

import nl.mauritssilvis.types.java.node.ForwardNode;
import nl.mauritssilvis.types.java.node.Node;

public class SinglyLinkedNodeList<E> implements LinkedList<E> {
    private int size;
    private ForwardNode<E> head;
    private ForwardNode<E> tail;

    @Override
    public void add(E element) {
        ForwardNode<E> newNode = new SinglyLinkedNode<>(element);

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
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.getData();
    }

    @Override
    public void set(int index, E element) {
        Node<E> node = getNode(index);
        node.setData(element);
    }

    private ForwardNode<E> getNode(int index) {
        verifyIndex(index);

        ForwardNode<E> node = head;

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
