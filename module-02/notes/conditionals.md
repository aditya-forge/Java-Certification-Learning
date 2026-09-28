# Conditionals

## if / else if / else

```java
if (marks >= 90) {
    grade = "A";
} else if (marks >= 75) {
    grade = "B";
} else {
    grade = "C";
}
```

Conditions are checked top to bottom, and only the first matching branch runs. So order matters: checking `marks >= 75` first would give a 95 a B.

I always use braces, even for one-line bodies. Without them, only the next single statement belongs to the `if`, which is an easy bug to create when adding a line later.

## Comparing strings

```java
String answer = "yes";
if (answer.equals("yes")) { ... }            // correct
if (answer.equalsIgnoreCase("YES")) { ... }  // ignores case
if (answer == "yes") { ... }                 // wrong: compares references
```

`==` sometimes appears to work with strings because of how Java reuses string literals, which makes the bug harder to spot. Always use `.equals()`.

## Combining conditions

```java
if (age >= 18 && hasTicket) { ... }
if (day.equals("Sat") || day.equals("Sun")) { ... }
```

For range checks both sides need writing out: `x >= 1 && x <= 10`, not `1 <= x <= 10`, which doesn't compile.

## Returning a boolean directly

Instead of:

```java
if (n % 2 == 0) {
    return true;
} else {
    return false;
}
```

just write `return n % 2 == 0;`, since the condition already is a boolean.

## Ternary operator

A short form for choosing between two values:

```java
String label = (temperature > 30) ? "hot" : "fine";
```

Good for simple cases. For anything longer, a normal `if` is easier to read.
