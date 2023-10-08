# Java string types

> String data types implemented in Java

## Introduction

With this part of the [Java types](../../../../../../../..) project, I provide implementations of the string data type in Java.

Below, I give an overview of the different [implementations](#1-implementations) I considered.

General information about the string data type can be found in the [string section](../../../../../../../../../#31-strings) of the [Types](../../../../../../../../..) readme.

## 1. Implementations

### 1.1 Immutable strings

First, I focus on immutable string types that implement the interface from the file [ImmutableString.java](ImmutableString.java):

```java
package nl.mauritssilvis.types.java.string;

public interface ImmutableString {
    int getLength();

    boolean isEmpty();

    char getChar(int index);

    char[] toCharArray();
}
```
Objects of the above type know their length, allow random access to their characters and can be converted to character arrays.
None of the supplied methods can change an object's contents.

#### 1.1.1 An array of characters

One of the ways the above immutable string interface can be implemented relies on using an array of characters.
Such an implementation is provided in the file [ArrayString.java](ArrayString.java), which, in a condensed form, looks as follows:

```java
package nl.mauritssilvis.types.java.string;

// Import statements

public class ArrayString implements ImmutableString {
    private final char[] chars;

    // A no-argument constructor and constructors accepting
    // char[], ImmutableString or regular Java String objects

    // Methods implementing the ImmutableString interface

    // Methods overriding some methods of the Object class
}
```

Unit tests confirm the functioning of this immutable string implementation.

## License

Copyright © 2022, 2023 Maurits Silvis

This source code package is subject to the terms and conditions defined in the [GNU General Public License v3.0](../../../../../../../../../LICENSE.md) or later.
