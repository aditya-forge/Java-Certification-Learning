# Java Math

## The Math class

`Math` is full of static methods, so they're called on the class: `Math.sqrt(16)`.

| Method | Does | Example |
|---|---|---|
| `Math.abs(x)` | absolute value | `Math.abs(-7)` is `7` |
| `Math.max(a, b)` / `Math.min(a, b)` | larger / smaller of two | `Math.max(3, 9)` is `9` |
| `Math.pow(a, b)` | a to the power b, as a `double` | `Math.pow(2, 10)` is `1024.0` |
| `Math.sqrt(x)` | square root, as a `double` | `Math.sqrt(2)` is about `1.414` |
| `Math.round(x)` | nearest whole number, as a `long` | `Math.round(2.5)` is `3` |
| `Math.floor(x)` / `Math.ceil(x)` | round down / up, as a `double` | `Math.ceil(2.1)` is `3.0` |
| `Math.random()` | random `double` from 0.0 up to, not including, 1.0 | |

Several of these return `double` or `long`, so storing the result in an `int` needs a cast: `int r = (int) Math.round(2.7);`.

To get the largest of three values, nest the calls: `Math.max(a, Math.max(b, c))`.

## Remainder and "multiple of"

`%` answers "is this a multiple of n?": `x % n == 0`.

This comes up with strings too. If a piece of text has to be made of 3-character chunks, its length must be a multiple of 3:

```java
if (text.length() % 3 == 0) { ... }
```

and the gap between two positions can be checked the same way: `(end - start) % 3 == 0`.

## Integer overflow

An `int` goes up to about 2.1 billion (`Integer.MAX_VALUE`). Going past it wraps around to a large negative number without any error:

```java
int big = Integer.MAX_VALUE;
System.out.println(big + 1);   // -2147483648
```

Use `long` when numbers could get that large.

## Doubles aren't exact

```java
System.out.println(0.1 + 0.2);   // 0.30000000000000004
```

Decimal fractions often can't be stored exactly in binary. Don't compare `double`s with `==`. Check whether they're close enough instead: `Math.abs(a - b) < 0.0001`.
