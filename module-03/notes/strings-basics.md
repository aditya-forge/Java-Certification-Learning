# Strings basics

A `String` is a sequence of characters. It's an object, not a primitive, but Java gives it some special treatment: you can write literals like `"hello"` and join strings with `+`.

## Strings are immutable

No method ever changes a string in place. Methods like `toUpperCase()` or `substring()` return a new string, and the original stays the same.

```java
String s = "java";
s.toUpperCase();        // result thrown away, s is still "java"
s = s.toUpperCase();    // now s is "JAVA"
```

Forgetting to store the result is one of the most common string bugs.

## Positions (indexes)

Characters are numbered from `0`. For `"banana"`:

```
index:  0 1 2 3 4 5
char:   b a n a n a
```

- `length()` is 6, and the last valid index is `length() - 1`
- `charAt(2)` is `'n'`, a `char`, not a `String`
- `charAt(6)` throws `StringIndexOutOfBoundsException`

## Methods I use most

| Method | Returns | Example with `s = "banana"` |
|---|---|---|
| `length()` | `int` | `6` |
| `charAt(i)` | `char` | `charAt(0)` is `'b'` |
| `indexOf(str)` | first position, or `-1` | `indexOf("an")` is `1` |
| `indexOf(str, from)` | first position at or after `from` | `indexOf("an", 2)` is `3` |
| `lastIndexOf(str)` | last position | `lastIndexOf("a")` is `5` |
| `substring(a, b)` | chars from `a` up to, not including, `b` | `substring(1, 4)` is `"ana"` |
| `substring(a)` | from `a` to the end | `substring(3)` is `"ana"` |
| `startsWith` / `endsWith` | `boolean` | `endsWith("na")` is `true` |
| `contains(str)` | `boolean` | `contains("nan")` is `true` |
| `toLowerCase()` / `toUpperCase()` | new string | |
| `trim()` | new string without surrounding spaces | |
| `equals` / `equalsIgnoreCase` | `boolean` | |

## substring end index

`substring(a, b)` includes `a` but excludes `b`, so its length is `b - a`. That makes some things neat:

- `s.substring(0, 3)` is the first 3 characters
- `s.substring(i, i + 3)` is the 3 characters starting at `i`

## indexOf returns -1

When the text isn't found, `indexOf` returns `-1` rather than throwing an error. Passing that `-1` straight into `substring` then does throw. So the pattern is always: find, check for `-1`, then use.

```java
int pos = s.indexOf("xyz");
if (pos == -1) {
    // not found, handle it
}
```
