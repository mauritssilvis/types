/*
 * Copyright © 2021, 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.string;

public interface String {
    char getChar(int index);

    boolean isEmpty();

    int getLength();

    char[] toCharArray();
}
