# Types

> A collection of data types and structures, implemented in different programming languages

## Introduction

With this project, I provide implementations of commonly used data types and structures in different programming languages.

Below, I first describe the [aims](#1-aims) I have with the current project.
I then provide an [overview](#2-overview) of the data type and structure implementations that are currently available.
Finally, I provide some [background information](#3-background) on the data types and structures I focus on in this project.

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

Currently, implementations of commonly used data types and structures are available in:

- [Java](java)

I specifically provide the following data type and structure implementations:

| Design pattern | Java                                                       |
|----------------|------------------------------------------------------------|
| String         | [✅](java/src/main/java/nl/mauritssilvis/types/java/string) |

## 3. Background

More information on the data types and structures that I focus on in this project is given in what follows.

### 3.1 String

Next to numeric data types like integers and floating point numbers, strings arguably are one of the most used data types in programming.
Essentially, strings are arrays of characters.
Yet, despite this seeming simplicity, strings can be used to store everything from single words to names, email addresses, codes like passwords and even full texts. 

In many programming languages, including Java, strings are represented by immutable objects.
Immutable objects are objects that can't be changed once they are created.
Concatenation of two immutable strings will, therefore, not result in modification of either of the strings, but in the creation of a new (a third) string.
As such, immutability could be seen as a disadvantage.
However, consider using strings as keys for a hash map.
If strings were mutable, you could change those keys by changing the used strings.
The immutability of strings prevents such changes and, thereby, prevents unexpected situations and potential bugs.

## License

Copyright © 2021, 2022 Maurits H. Silvis

This source code package is subject to the terms and conditions defined in the GNU General Public License v3.0, which can be found in the file [LICENSE.md](LICENSE.md), or later.
