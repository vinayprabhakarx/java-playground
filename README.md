# Java Playground

A practice playground for learning, experimenting, and practicing Java programming.

## Purpose

This repository serves as a hands-on space to:

- **Practice** Java fundamentals and advanced concepts
- **Learn** new Java features and best practices
- **Experiment** with different libraries, frameworks, and coding patterns

## Getting Started

Clone or navigate to this directory and start exploring Java examples and exercises.

## IntelliJ IDEA

This project now includes a root `pom.xml`, so IntelliJ IDEA can detect and import it as a Maven Java project directly from the repository root.

If IntelliJ was already opened before `pom.xml` existed, reopen the project from the root folder or use `File > Open` on this repository and choose the Maven import/reload prompt.

## Structure

All code is organized under the `com/vinayprabhakarx/` package:

```
src/main/java/com/vinayprabhakarx/
├── array/              — Array fundamentals, search, sorting, 2D arrays
├── basics/             — Core Java: arithmetic, control flow, type casting, patterns
├── collections/        — Java Collections Framework
│   ├── arraydeque/     — ArrayDeque (double-ended queue)
│   ├── arraylist/      — ArrayList
│   ├── hashmap/        — HashMap
│   ├── hashset/        — HashSet
│   ├── linkedhashmap/  — LinkedHashMap (insertion-ordered map)
│   ├── linkedhashset/  — LinkedHashSet (insertion-ordered set)
│   ├── linkedlist/     — LinkedList
│   ├── priorityqueue/  — PriorityQueue (min-heap)
│   ├── stack/          — Stack (LIFO)
│   ├── treemap/        — TreeMap (sorted map)
│   ├── treeset/        — TreeSet (sorted set)
│   └── vector/         — Vector (thread-safe dynamic array)
├── exceptions/         — Exception handling & custom exceptions
├── functional/         — Lambda expressions and functional interfaces
├── generics/           — Generic classes, methods, bounded types
├── hibernate/          — Hibernate ORM and entity mapping
├── jdbc/               — JDBC and MySQL database operations
├── math/               — Mathematical operations and utilities
├── methods/            — Method design and practice exercises
├── oops/               — Object-Oriented Programming
│   ├── classes/        — Class definitions, instances, and fields
│   ├── encapsulation/  — Access control, getters/setters, data hiding
│   ├── inheritance/    — Inheritance and method overriding
│   ├── interfaces/     — Interfaces, abstract classes, default methods
│   └── polymorphism/   — Method overloading and overriding
├── recursion/          — Recursive algorithms and patterns
├── streams/            — Java Streams API (filter, map, reduce, collect)
├── strings/            — String manipulation and operations
└── threads/            — Multithreading and concurrency
```

Resources such as text files, serialized files, and configuration files are stored under:

```
src/main/resources/
```

## How to Compile and Run

### Compile with Maven:

```bash
mvn compile
```

### Run a class with Maven:

```bash
mvn exec:java -Dexec.mainClass=com.vinayprabhakarx.<package>.<ClassName>
```

Example:

```bash
mvn exec:java -Dexec.mainClass=com.vinayprabhakarx.jdbc.ReadStudent
```

## Resources & Learning Sources

- [W3Resource Java Exercises](https://www.w3resource.com/java-exercises/basic/index.php)
- [GeeksforGeeks - Java Programming](https://www.geeksforgeeks.org/java/) — Tutorials, examples, and problem solutions.
