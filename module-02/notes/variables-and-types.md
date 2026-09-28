# Variables and types

Java is statically typed: every variable has a type that is fixed when it's declared, and the compiler checks that you only store matching values in it.

```java
int count = 0;
double price = 19.99;
boolean done = false;
String name = "Aditya";
```

## Primitive types I actually use

| Type      | Holds                      | Example        |
|-----------|----------------------------|----------------|
| `int`     | whole numbers (32-bit)     | `42`           |
| `long`    | bigger whole numbers       | `3000000000L`  |
| `double`  | decimals                   | `3.14`         |
| `boolean` | `true` / `false`           | `true`         |
| `char`    | a single character         | `'A'`          |

There are also `byte`, `short` and `float`, but I haven't needed them.

`String` is not a primitive. It's a class, which is why it starts with a capital letter. Primitives hold the value directly, while a `String` variable holds a reference to an object.

## Declaring and assigning

- Declare once, then assign as many times as needed: `count = count + 1;`
- A local variable must be assigned before it's used, or the code won't compile.
- `final` makes a variable constant after its first assignment: `final int DAYS_IN_WEEK = 7;`

## Integer division

This caught me out:

```java
int a = 7;
int b = 2;
System.out.println(a / b);          // 3, not 3.5
System.out.println(a / (double) b); // 3.5
```

If both sides are `int`, the result is an `int` and the decimal part is dropped (not rounded). Casting one side to `double` fixes it.

## Classes are types too

Every class defines a new type. `Point p;` declares a variable whose type is `Point`, the same way `int n;` declares one of type `int`. The compiler then only allows `Point` objects in `p`, and only lets you call methods that `Point` has.

Types show up in three places, and they all have to agree:

- variable declarations: `double d = ...`
- method parameters: `distanceTo(Point other)`
- return types: `public double distanceTo(...)`

A lot of compile errors are just a mismatch between these, like "incompatible types: double cannot be converted to int".

## Casting

- Widening (`int` to `double`) happens automatically.
- Narrowing (`double` to `int`) needs an explicit cast and truncates: `(int) 9.99` is `9`.
