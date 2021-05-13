/*
 * Copyright © 2021 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.string;

import java.util.Arrays;

public class ArrayString implements String {
    private final char[] chars;

    public ArrayString(char[] chars) {
        this.chars = chars.clone();
    }

    public ArrayString(String str) {
        chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(i);
        }
    }

    public ArrayString(java.lang.String str) {
        chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(i);
        }
    }

    @Override
    public char charAt(int index) {
        return chars[index];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof String str) {
            if (chars.length != str.length()) {
                return false;
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != str.charAt(i)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(chars);
    }

    @Override
    public boolean isEmpty() {
        return chars.length == 0;
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public java.lang.String toString() {
        return new java.lang.String(chars);
    }
}
