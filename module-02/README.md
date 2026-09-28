# Module 2 - Fundamental Java Syntax and Semantics

The first proper Java module. It goes from variables and operators up to writing classes and looping over collections, and introduces a step-by-step method for turning a problem into code.

## Key concepts

- Static typing, primitive types vs `String`, integer division and casting
- Arithmetic, comparison and logical operators, including short-circuiting
- Methods: parameters, return types, `void`, pass by value
- `if / else if / else`, comparing strings with `.equals()`
- Classes, fields, constructors, `this`, creating objects with `new`
- `for`, `while` and for-each loops, and the common loop patterns
- The seven-step approach to problem solving

## What I practiced

- Small demo programs for each topic in `examples/`
- Writing my own class (`BankAccount`) and using it from `main`
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
├── notes/
│   ├── variables-and-types.md
│   ├── operators.md
│   ├── methods.md
│   ├── conditionals.md
│   ├── classes-and-objects.md
│   ├── loops.md
│   └── seven-step-approach.md
├── examples/
│   ├── VariablesDemo.java
│   ├── OperatorsDemo.java
│   ├── MethodsDemo.java
│   ├── GradeChecker.java
│   ├── BankAccount.java
│   └── LoopsDemo.java
└── exercises/
    ├── README.md
    └── solutions/
```

Every example has its own `main`, so it runs directly with `java FileName.java` or from BlueJ.

## Checklist

- [x] Variables and types
- [x] Operators
- [x] Methods
- [x] Conditionals
- [x] Classes and objects
- [x] Loops
- [x] Seven-step approach
- [x] Practice exercises
