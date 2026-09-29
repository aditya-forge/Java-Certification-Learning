# Logical and / or

Covered briefly in Module 2's operators note. This module uses them a lot with string searches.

## With indexOf results

Checking whether both of two things were found:

```java
int a = text.indexOf("x");
int b = text.indexOf("y");
if (a != -1 && b != -1) { ... }   // both found
if (a != -1 || b != -1) { ... }   // at least one found
```

## Picking the earliest of several matches

A common problem: search for several different targets and use whichever appears first. The tricky part is that "not found" is `-1`, which is smaller than every real position, so a plain `Math.min` picks the wrong one.

```java
int first = -1;
if (a != -1 && (first == -1 || a < first)) {
    first = a;
}
if (b != -1 && (first == -1 || b < first)) {
    first = b;
}
```

Read the condition as "`a` was found, and either we have nothing yet or `a` is earlier than what we have". The brackets matter here, because `&&` is evaluated before `||`.

Another option is to turn "not found" into a value that loses every comparison, like `text.length()` or `Integer.MAX_VALUE`, and then use `Math.min`.

## Short-circuit protects you

```java
if (pos != -1 && text.charAt(pos + 1) == ':') { ... }
```

If `pos` is `-1`, the right side never runs, so `charAt` isn't called with a bad index. Swapping the two sides would crash. Put the safety check first.

## Negating conditions (De Morgan)

- `!(a && b)` is the same as `!a || !b`
- `!(a || b)` is the same as `!a && !b`

So "not (found x and found y)" means "x missing or y missing". Useful when flipping a condition for an early `return`.
