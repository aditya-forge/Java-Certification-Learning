# Debugging first steps

Most of my bugs in this module were in string code, and they were nearly always one of a few types.

## Before changing anything

1. **Reproduce it.** Find the smallest input that gives the wrong answer. Cut the string down until the bug only just still happens.
2. **Say what you expected.** Work the small input by hand (seven steps again) and write down the right answer and the intermediate values.
3. **Find where it goes wrong.** Add `println`s showing the important variables, like positions from `indexOf` and loop counters, then compare them with the hand-worked values. The first place they differ is where the bug is.

Changing things randomly until it works usually hides the bug instead of fixing it.

## Bugs I kept making with strings

- **Off by one in `substring`**: forgetting the end index is excluded, or not adding the marker length.
- **Not checking for `-1`**: `indexOf` fails and the `-1` goes into `substring` or `charAt`.
- **Searching from the wrong place**: searching from 0 again instead of after the last match, which finds the same match forever and gives an infinite loop.
- **Case**: searching for `"ATG"` in lowercase text.
- **Forgetting strings are immutable**: calling `s.toUpperCase();` without assigning it.
- **`==` instead of `.equals()`**.

## Reading exceptions

```
java.lang.StringIndexOutOfBoundsException: begin 5, end 3, length 10
    at java.base/java.lang.String.substring(...)
    at TextExtractor.between(TextExtractor.java:12)
```

- The first line says what went wrong and the values involved.
- Further down, find the first line that mentions my own class. That's the line in my code that triggered it, here line 12 of `TextExtractor.java`.
