# Loops

## for

Best when the number of repetitions is known.

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);   // 0 to 4
}
```

The three parts are start, keep-going condition and update. The most common bug is off-by-one: `i <= 5` runs six times, not five. For arrays, the valid indexes are `0` to `length - 1`.

## while

Best when you loop until something happens and don't know how many times in advance.

```java
int n = 4827;
int digits = 0;
while (n > 0) {
    n = n / 10;
    digits++;
}
```

Something inside the loop has to move towards making the condition false. Otherwise it's an infinite loop.

## for-each

Goes through every element of an array or collection without handling indexes.

```java
int[] scores = {70, 85, 90};
for (int score : scores) {
    System.out.println(score);
}
```

Read it as "for each `score` in `scores`". It works with anything iterable, which is how the course loops over things like the points of a shape or the lines of a file.

Limits: you don't get the index, and assigning to the loop variable doesn't change the array. If either is needed, use a normal `for`.

## Common patterns

Most loops I write are one of these:

- **Accumulate**: start `total = 0`, add each element, use it after the loop.
- **Count**: start `count = 0`, increase it when a condition is true.
- **Find the largest/smallest**: start with the first element (not `0`, since all values could be negative), then compare each element and update.
- **Search**: loop until a match is found, then `return` or `break`.

## break and continue

- `break` leaves the loop completely.
- `continue` skips to the next iteration.

Useful, but a loop with many of them gets hard to follow.
