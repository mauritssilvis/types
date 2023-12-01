/*
 * Copyright © 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedNodeListTests {
    @Test
    void addAnElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int element = 1;

        Assertions.assertDoesNotThrow(() -> list.add(element));
    }

    @Test
    void addMultipleElements() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int element1 = 1;
        int element2 = 2;

        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> list.add(element1)),
                () -> Assertions.assertDoesNotThrow(() -> list.add(element2))
        );
    }

    @Test
    void doNotGetAnElementWithANegativeIndex() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int index = -1;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
    }

    @Test
    void doNotGetANonExistingFirstElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int index = 0;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
    }

    @Test
    void doNotGetANonExistingElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(6);
        list.add(3);
        list.add(2);

        int index = 3;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
    }

    @Test
    void getOneElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int index = 0;
        int element = 1;

        list.add(element);

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void getTheFirstElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int index = 0;
        int element = 1;

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void getTheLastElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(2);
        list.add(6);
        list.add(4);
        list.add(8);

        int index = 3;
        int element = 8;

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void getAnElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(5);
        list.add(4);
        list.add(8);
        list.add(2);
        list.add(10);

        int index = 3;
        int element = 2;

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void doNotSetAnElementWithANegativeIndex() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int index = -1;
        int element = 3;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(index, element));
    }

    @Test
    void doNotSetANonExistingFirstElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        int index = 0;
        int element = 4;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(index, element));
    }

    @Test
    void doNotSetANonExistingElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(4);
        list.add(-2);

        int index = 3;
        int element = 9;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(index, element));
    }

    @Test
    void setOneElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(2);

        int index = 0;
        int element = 3;

        list.set(index, element);

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void setTheFirstElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(0);
        list.add(2);
        list.add(3);

        int index = 0;
        int element = 1;

        list.set(index, element);

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void setTheLastElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(2);
        list.add(6);
        list.add(4);
        list.add(8);

        int index = 3;
        int element = 5;

        list.set(index, element);

        Assertions.assertEquals(element, list.get(index));
    }

    @Test
    void setAnElement() {
        LinkedList<Integer> list = new SinglyLinkedNodeList<>();

        list.add(5);
        list.add(4);
        list.add(8);
        list.add(2);

        int index = 2;
        int element = 2;

        list.set(index, element);

        Assertions.assertEquals(element, list.get(index));
    }
}
