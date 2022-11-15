/*
 * Copyright © 2021, 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.string;

public interface ImmutableString {
    int getLength();

    boolean isEmpty();

    char getChar(int index);

    char[] toCharArray();
}
