# Types

> A collection of data types and structures

## Introduction

With this educational project, I provide implementations of commonly used data types and structures.

Below, I first describe the [aims](#1-aims) I have with the current project.
I then provide an [overview](#2-overview) of the data type and structure implementations that are currently available.
Finally, I provide some [background information](#3-background) on the data types and structures I focus on in this project.

The release history of this project is contained in the [changelog](CHANGELOG.md).

## 1. Aims

My aims with this project are to:

- Build up knowledge of data types and structures.
- Learn how these data types and structures can be implemented.

More generally, I strive to:

- Gain experience with different programming languages.
- Get to know the specifics of these languages.

Finally, I aim to:

- Showcase this experience and knowledge.

## 2. Overview

Currently, implementations of commonly used data types and structures are available in the following languages:

- [Java](java)

I specifically provide the following (partial) data type and structure implementations:

| Data type or structure | Java                                                                             |
|------------------------|----------------------------------------------------------------------------------|
| String                 | [✅](java/src/main/java/nl/mauritssilvis/types/java/string)                       |
| • Immutable string     | [✅](java/src/main/java/nl/mauritssilvis/types/java/string/#11-immutable-strings) |

## 3. Background

Below, I give general information on the data types and structures I focus on in this project.

### 3.1 Strings

Next to numeric types like integers and floating point numbers, strings arguably are one of the most commonly used data types in programming.
Essentially, strings are arrays of characters.
However, despite this seeming simplicity, strings can store anything from single words to names, email addresses, passwords and even full texts.

In many programming languages, including Java, strings are represented by immutable objects.
Immutable objects are objects that cannot be changed once they are created.
Therefore, concatenating two immutable strings will not modify these strings but create a new (a third) string.
Since we then end up with more objects, immutability could be considered a disadvantage.
However, consider using strings as keys for a hash map.
If strings were mutable, you could change those keys by changing the used strings.
The immutability of strings prevents such changes, thus preventing unexpected situations and potential bugs.
Mutable and immutable strings, thus, both have their advantages and disadvantages.

## License

Copyright © 2021–2023 Maurits Silvis

This source code package is subject to the terms and conditions defined in the [GNU General Public License v3.0](LICENSE.md) or later.
