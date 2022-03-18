/*
 * Copyright © 2021, 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.string;

public interface String {
    char charAt(int index);

    boolean isEmpty();

    int length();

    char[] toCharArray();
}
