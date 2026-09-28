# Reading code (semantics)

Syntax is whether code is written correctly, meaning the compiler accepts it. Semantics is what the code actually does when it runs. Code can compile fine and still do the wrong thing.

Being able to read code and predict exactly what it does matters because:

- most of the time spent programming is reading code (your own and other people's)
- debugging is comparing what the code does with what you think it does
- you can't write a loop correctly if you can't trace one

## Tracing by hand

Go through the code one line at a time and keep a table of every variable's current value. Update it on every assignment. Don't skip lines because they look obvious.

```java
int a = 3;
int b = a * 2;
a = a + b;
b = b - 1;
```

| line          | a | b |
|---------------|---|---|
| `int a = 3`   | 3 | - |
| `int b = a*2` | 3 | 6 |
| `a = a + b`   | 9 | 6 |
| `b = b - 1`   | 9 | 5 |

Things to keep in mind while tracing:

- `=` is assignment, not "equals". The right side is worked out first, then stored.
- A variable keeps its value until it's assigned again.
- For a method call, jump into the method with the argument values, trace it, then come back with the return value.
- For loops, write a new row each time round, and check the condition every time.

## Practising

Before running any example in this module, I tried to predict the output first, then ran it and checked. The ones I got wrong were almost always integer division, string concatenation order, or an off-by-one in a loop.
