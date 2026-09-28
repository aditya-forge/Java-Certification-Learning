# Operators

## Arithmetic

`+  -  *  /  %`

`%` gives the remainder. It is more useful than it first looks:

- `n % 2 == 0` checks if `n` is even
- `n % 10` gives the last digit
- `n / 10` removes the last digit (with `int`)

## Assignment shortcuts

```java
total += 5;   // total = total + 5
total -= 2;
total *= 3;
count++;      // count = count + 1
count--;
```

`count++` and `++count` only differ when used inside a bigger expression. I just keep them on their own line so it doesn't matter.

## Comparison

`==  !=  <  >  <=  >=`, all giving a `boolean`.

`==` compares values for primitives but references for objects. For strings, use `.equals()` (more on that in conditionals).

## Logical

- `&&` and: true only if both sides are true
- `||` or: true if at least one side is true
- `!` not

`&&` and `||` short-circuit: if the left side already decides the answer, the right side isn't evaluated. So `x != 0 && 10 / x > 2` is safe even when `x` is 0.

## Precedence

`*`, `/` and `%` happen before `+` and `-`, same as in maths. When in doubt I add brackets, which also makes it easier to read.

## String concatenation gotcha

```java
System.out.println("Sum: " + 1 + 2);   // Sum: 12
System.out.println("Sum: " + (1 + 2)); // Sum: 3
```

Evaluation goes left to right. Once a `String` is involved, `+` means joining, so brackets are needed around the arithmetic.
