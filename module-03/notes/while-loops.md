# While loops

The for-each loop from Module 2 goes through a collection once. Searching a string for every match needs something different: keep going until there are no more matches, without knowing in advance how many there are. That's what `while` is for.

## Syntax and semantics

```java
while (condition) {
    // body
}
```

What actually happens:

1. Check the condition.
2. If it's false, skip past the loop and carry on.
3. If it's true, run the whole body, then go back to step 1.

The condition is only checked at the top, not in the middle of the body.

Every while loop needs three things, or it's buggy:

- **set up** the variables the condition uses, before the loop
- **a condition** that can eventually become false
- **progress** inside the body that moves towards making it false

Without progress, the loop never ends. In BlueJ, an infinite loop shows up as the striped "working" bar that never stops. Right-click it and reset the Java machine.

## Pattern: find every occurrence

This is the main use of `while` in this module. `indexOf(target, from)` finds the next match at or after `from`, so each time round you search from just after the last match.

```java
int pos = text.indexOf(target);
while (pos != -1) {
    System.out.println("found at " + pos);
    pos = text.indexOf(target, pos + target.length());
}
```

- set up: the first search, before the loop
- condition: a match was found
- progress: search again starting after the current match

Using `pos + target.length()` skips over the whole match, so matches don't overlap: `"aa"` is found twice in `"aaaa"`, at 0 and 2. Using `pos + 1` instead also finds overlapping matches: 0, 1 and 2. Which one is right depends on the problem.

## The `while (true)` + `break` version

Some people prefer this form, and the course shows it too:

```java
int from = 0;
while (true) {
    int pos = text.indexOf(target, from);
    if (pos == -1) {
        break;
    }
    System.out.println("found at " + pos);
    from = pos + target.length();
}
```

It avoids writing the `indexOf` call twice. Both versions are fine.

## while vs for

A `for` loop is really a `while` loop with the set up, condition and progress written on one line. I use `for` when counting through positions, and `while` when the next position comes from a search.

## do-while

Runs the body once before checking the condition:

```java
do {
    // runs at least once
} while (condition);
```

I haven't needed it much. It's mostly useful for things like "ask for input until it's valid".
