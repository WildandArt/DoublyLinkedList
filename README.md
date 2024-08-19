![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white)
![TDD](https://img.shields.io/badge/TDD-Test%20Driven%20Development-blue?style=for-the-badge)
![JUnit5](https://img.shields.io/badge/JUnit-5.8.1-25A162?style=for-the-badge&logo=JUnit5&logoColor=white)


# Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
   - [Java 17](#java-17)
   - [Maven](#maven)
3. [Implementation](#implementation)
   - [Features](#features)
   - [Methods](#methods)
4. [Testing](#testing)
   - [Test-Driven Development (TDD)](#test-driven-development-tdd)
5. [License](#license)

## Overview

The `DoublyLinkedListImpl` class implements a doubly linked list in Java. This data structure supports both stack and queue operations, providing deque (double-ended queue) functionality. Each node in the list contains references to both its previous and next nodes, allowing for efficient insertion and removal from both ends.

## Prerequisites

To build and run this project, you'll need to have the following software installed on your system:

### Java 17

You need Java 17 to compile and run this project. To install Java 17:

1. **Download the JDK**:
   - Visit the [Oracle JDK Downloads page](https://www.oracle.com/java/technologies/javase-17-downloads.html) or the [AdoptOpenJDK page](https://adoptium.net/) to download the installer for Java 17.

2. **Install the JDK**:
   - Follow the installation instructions provided for your operating system.

3. **Set Up the Java Environment**:
   - Ensure that the `JAVA_HOME` environment variable is set to the path where Java is installed.
   - Add the `bin` directory of the JDK to your system's `PATH` environment variable.

4. **Verify the Installation**:
   - Open a terminal or command prompt and run:
     ```sh
     java -version
     ```
   - You should see output indicating that Java 17 is installed.

### Maven

Apache Maven is used for project management and build automation. To install Maven:

1. **Download Maven**:
   - Visit the [Apache Maven Download page](https://maven.apache.org/download.cgi) and download the binary zip or tar.gz archive.

2. **Install Maven**:
   - Extract the downloaded archive to a directory of your choice.

3. **Set Up the Maven Environment**:
   - Add the `bin` directory of the Maven installation to your system's `PATH` environment variable.

4. **Verify the Installation**:
   - Open a terminal or command prompt and run:
     ```sh
     mvn -version
     ```
   - You should see output indicating the Maven version and the Java version it is using.

With Java 17 and Maven installed, you can build and test the `DoublyLinkedListImpl` project by running Maven commands.


# Implementation

## Overview

The `DoublyLinkedListImpl` class implements a doubly linked list in Java. This data structure supports both stack and queue operations, providing deque (double-ended queue) functionality. Each node in the list contains references to both its previous and next nodes, allowing for efficient insertion and removal from both ends.

## Features

- **Doubly Linked List**: Each node points to both its previous and next nodes, enabling traversal in both directions.
- **Deque Functionality**: Supports adding and removing elements from both the front and back of the list.

## Methods

#### 
```
pushToFront(T element)
```

**Description**: Adds a new node with the specified element to the front of the list.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time because it involves adjusting a few pointers.
- **Space**: O(1) - No additional space is required beyond the new node.

#### 
```
pushToBack(T element)
```

**Description**: Adds a new node with the specified element to the end of the list.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time because it involves adjusting a few pointers.
- **Space**: O(1) - No additional space is required beyond the new node.

#### 
```
insertBefore(Node<T> node, T data)
```

**Description**: Inserts a new node with the specified data before the given node. If the node is the head, it uses `pushToFront`.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time as it involves adjusting pointers around the node.
- **Space**: O(1) - No additional space is required beyond the new node.

#### 
```
popFront()
```

**Description**: Removes and returns the element at the front of the list. Throws an exception if the list is empty.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time by adjusting the head pointer.
- **Space**: O(1) - No additional space is required.

 
```
popBack()
```

**Description**: Removes and returns the element at the end of the list. Throws an exception if the list is empty.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time by adjusting the tail pointer.
- **Space**: O(1) - No additional space is required.

```
remove(T data)
```

**Description**: Removes the first occurrence of the specified data from the list.

**Complexity**: 
- **Time**: O(n) - The operation requires traversal of the list to find the element.
- **Space**: O(1) - No additional space is required beyond the node being removed.

```
remove(int index)
```

**Description**: Removes the element at the specified index.

**Complexity**: 
- **Time**: O(n) - The operation requires traversal of the list to find the element.
- **Space**: O(1) - No additional space is required beyond the node being removed.

```
remove(Node<T> node)
```
**Description**: Removes the specified node from the list.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time by adjusting pointers around the node.
- **Space**: O(1) - No additional space is required.

```
count()
```

**Description**: Returns the number of elements in the list.

**Complexity**: 
- **Time**: O(n) - The operation requires traversal of the list to count the elements.
- **Space**: O(1) - No additional space is required.

```
isEmpty()
```

**Description**: Checks if the list is empty.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time by checking pointers.
- **Space**: O(1) - No additional space is required.

```
getData(Node<T> node)
```

**Description**: Returns the data stored in the specified node.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time.
- **Space**: O(1) - No additional space is required.

```
getHead()
```

**Description**: Returns the head node of the list.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time.
- **Space**: O(1) - No additional space is required.

```
getTail()
```

**Description**: Returns the tail node of the list.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time.
- **Space**: O(1) - No additional space is required.

```
getPrev(Node<T> node)
```

**Description**: Returns the previous node of the specified node.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time.
- **Space**: O(1) - No additional space is required.

```
getNext(Node<T> node)
```

**Description**: Returns the next node of the specified node.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time.
- **Space**: O(1) - No additional space is required.

 ```
 splice(Node<T> dest, Node<T> from, Node<T> to)
 ```

**Description**: Moves a sublist (from `from` to `to`) and inserts it before `dest`. Throws an exception if any of the nodes are null.

**Complexity**: 
- **Time**: O(1) - The operation is performed in constant time by adjusting pointers around the nodes.
- **Space**: O(1) - No additional space is required.


## Testing

### Test-Driven Development (TDD)

Test-Driven Development (TDD) has been a core methodology in the development of this `DoublyLinkedListImpl` class. TDD emphasizes writing tests before implementing functionality, which ensures that the code is driven by test cases from the outset. 

#### How to run tests:
```
mvn test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
