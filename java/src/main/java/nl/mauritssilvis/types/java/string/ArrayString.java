/*
 * Copyright © 2021, 2022 Maurits H. Silvis
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package nl.mauritssilvis.types.java.string;

import java.util.Arrays;

public class ArrayString implements ImmutableString {
    private final char[] chars;

    public ArrayString() {
        chars = new char[0];
    }

    public ArrayString(char[] chars) {
        this.chars = chars.clone();
    }

    public ArrayString(ImmutableString str) {
        chars = str.toCharArray();
    }

    public ArrayString(String str) {
        chars = str.toCharArray();
    }

    @Override
    public int getLength() {
        return chars.length;
    }

    @Override
    public boolean isEmpty() {
        return chars.length == 0;
    }

    @Override
    public char getChar(int index) {
        return chars[index];
    }

    @Override
    public char[] toCharArray() {
        return chars.clone();
    }

    @Override
    // TODO: Test the requirements on hashCode() from https://hyperskill.org/learn/step/3586
    public int hashCode() {
        return Arrays.hashCode(chars);
    }
    @Override
    // TODO: Test the requirements on equals() from https://hyperskill.org/learn/step/3586
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ImmutableString str)) {
            return false;
        }

        if (chars.length != str.getLength()) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != str.getChar(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return new String(chars);
    }
}
