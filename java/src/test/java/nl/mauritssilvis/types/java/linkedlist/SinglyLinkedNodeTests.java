/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

import nl.mauritssilvis.types.java.node.ForwardNode;
import nl.mauritssilvis.types.java.node.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedNodeTests {
    @Test
    void createANode() {
        int data = 3;
        Assertions.assertDoesNotThrow(() -> new SinglyLinkedNode<>(data));
    }

    @Test
    void getData() {
        int data = 4;
        Node<Integer> node = new SinglyLinkedNode<>(data);

        Assertions.assertEquals(data, node.getData());
    }

    @Test
    void setData() {
        int data = 3;
        Node<Integer> node = new SinglyLinkedNode<>(data);

        Assertions.assertDoesNotThrow(() -> node.setData(data));
    }

    @Test
    void setAndGetData() {
        int data = 2;
        Node<Integer> node = new SinglyLinkedNode<>(data);

        int newData = 6;
        node.setData(newData);

        Assertions.assertEquals(newData, node.getData());
    }

    @Test
    void doesNotHaveNext() {
        int data = 3;
        ForwardNode<Integer> node = new SinglyLinkedNode<>(data);

        Assertions.assertFalse(node.hasNext());
    }

    @Test
    void doesHaveNext() {
        int nextData = 8;
        ForwardNode<Integer> nextNode = new SinglyLinkedNode<>(nextData);

        int data = -3;
        ForwardNode<Integer> node = new SinglyLinkedNode<>(data);
        node.setNext(nextNode);

        Assertions.assertTrue(node.hasNext());
    }

    @Test
    void setNext() {
        int data = 9;
        ForwardNode<Integer> node = new SinglyLinkedNode<>(data);

        int nextData = 10;
        ForwardNode<Integer> nextNode = new SinglyLinkedNode<>(nextData);

        Assertions.assertDoesNotThrow(() -> node.setNext(nextNode));
    }

    @Test
    void setAndGetNext() {
        int nextData = 6;
        ForwardNode<Integer> nextNode = new SinglyLinkedNode<>(nextData);

        int data = 7;
        ForwardNode<Integer> node = new SinglyLinkedNode<>(data);
        node.setNext(nextNode);

        Assertions.assertDoesNotThrow(node::getNext);
    }

    @Test
    void getNextData() {
        int nextData = 6;
        ForwardNode<Integer> nextNode = new SinglyLinkedNode<>(nextData);

        int data = 7;
        ForwardNode<Integer> node = new SinglyLinkedNode<>(data);
        node.setNext(nextNode);

        Assertions.assertEquals(nextData, node.getNext().getData());
    }
}