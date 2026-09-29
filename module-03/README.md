# Module 3 - Strings in Java

Working with text: finding things in strings, cutting pieces out, repeating a search until there's nothing left to find, and keeping the results. The course uses DNA as its example throughout. I practised the same techniques on other kinds of text.

## Notes in lecture order

1. [Strings basics](notes/strings-basics.md) (what a string is, positions, the main methods)
2. [Developing a string algorithm](notes/string-algorithms.md) (from a hand-worked example to code)
3. [Java Math](notes/java-math.md)
4. [While loops](notes/while-loops.md) (syntax, semantics, find-every-occurrence pattern)
5. [DNA as a string problem](notes/dna-and-strings.md) (start/stop codons, concept only)
6. [Logical and / or](notes/logical-and-or.md) (earliest of several matches, short-circuit)
7. [Separation of concerns](notes/separation-of-concerns.md)
8. [Storing results](notes/storing-results.md) (StorageResource and ArrayList)
9. [Debugging first steps](notes/debugging.md)

## Key concepts

- Strings are immutable, so methods return new strings
- Indexes start at 0, `substring(a, b)` excludes `b`, and `indexOf` returns `-1` when not found
- `indexOf(str, from)` inside a `while` loop to find every match
- Picking the earliest of several matches while handling `-1`
- `Math` methods, `%` for "multiple of", overflow and `double` precision
- Methods that return results instead of printing them
- `ArrayList` for collecting an unknown number of results

## What I practiced

- An example program for each topic in `examples/`
- Six string problems in `exercises/`: palindrome, vowel count, hashtags, email parts, run-length compression and password rules

The course's gene-finding programming exercises are not included here.

## Folder structure

```
module-03/
├── README.md
├── notes/          (see list above)
├── examples/
│   ├── StringBasics.java
│   ├── TextExtractor.java
│   ├── MathDemo.java
│   ├── WhileLoopsDemo.java
│   ├── LogicalOperatorsDemo.java
│   └── WordCollector.java
└── exercises/
    ├── README.md
    └── solutions/
```

## Checklist

- [x] Strings basics and positions
- [x] Developing a string algorithm
- [x] Java Math
- [x] While loops
- [x] DNA background
- [x] Logical and / or
- [x] Separation of concerns
- [x] Storing results
- [x] Debugging
- [x] Practice exercises
