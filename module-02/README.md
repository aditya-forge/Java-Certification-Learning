# Module 2 - Fundamental Java Syntax and Semantics

The first proper Java module. It goes from variables and operators up to writing classes and looping over collections, and introduces a step-by-step method for turning a problem into code.

## Notes in lecture order

1. [Why Java](notes/why-java.md)
2. [Using BlueJ](notes/bluej.md)
3. [Shapes as collections of points](notes/shapes-and-points.md)
4. [Reading code (semantics)](notes/reading-code.md)
5. [Variables and types](notes/variables-and-types.md)
6. [Operators](notes/operators.md)
7. [Methods](notes/methods.md) (functions)
8. [Conditionals](notes/conditionals.md)
9. [Classes and objects](notes/classes-and-objects.md) (classes, `new`, methods)
10. [Loops](notes/loops.md) (for-each and the others)
11. [Seven-step approach](notes/seven-step-approach.md)
12. [Reading documentation](notes/reading-documentation.md)

## Key concepts

- Why Java: bytecode, the JVM and static typing
- Reading and tracing code by hand before running it
- Static typing, primitive types vs `String`, classes as types, integer division and casting
- Arithmetic, comparison and logical operators, including short-circuiting
- Methods: parameters, return types, `void`, pass by value
- `if / else if / else`, comparing strings with `.equals()`
- Classes, fields, constructors, `this`, creating objects with `new`
- `for`, `while` and for-each loops, and the common loop patterns
- The seven-step approach to problem solving

## What I practiced

- Small demo programs for each topic in `examples/`
- Writing my own classes (`BankAccount`, `Point`) and using them from `main`
- Six practice problems in `exercises/` covering conditionals, loops and a small class

## Things worth remembering

- `7 / 2` is `3`. Cast to `double` when a decimal result is needed.
- Use `.equals()` for strings, never `==`.
- Start max/min at the first element, not at `0`.
- A method with a return type must return on every path.

## Folder structure

```
module-02/
├── README.md
├── notes/          (see list above)
├── examples/
│   ├── VariablesDemo.java
│   ├── OperatorsDemo.java
│   ├── MethodsDemo.java
│   ├── GradeChecker.java
│   ├── BankAccount.java
│   ├── Point.java
│   └── LoopsDemo.java
└── exercises/
    ├── README.md
    └── solutions/
```

Every example has its own `main`, so it runs directly with `java FileName.java` or from BlueJ.

## Checklist

- [x] Why Java and BlueJ
- [x] Shapes and points
- [x] Reading code
- [x] Variables and types
- [x] Operators
- [x] Methods
- [x] Conditionals
- [x] Classes and objects
- [x] Loops
- [x] Seven-step approach
- [x] Reading documentation
- [x] Practice exercises
