# Developing a string algorithm

The seven-step approach from Module 2 works well for string problems, because you can literally point at the characters while doing an example by hand.

## Example: get the text between two markers

Problem: from `"Order [A123] shipped"`, get `"A123"`, the text between `[` and `]`.

**By hand:**

```
O r d e r   [ A 1 2 3 ]   s h i p p e d
0 1 2 3 4 5 6 7 8 9 10 11 ...
```

1. Find where `[` is: position 6.
2. The text starts just after it, at 7.
3. Find `]`, but only look after the `[`: position 11.
4. Take the characters from 7 up to 11, not including 11: `"A123"`.

**Generalized:**

1. `start = indexOf("[")`
2. if not found, return `""`
3. `end = indexOf("]", start + 1)`, searching from after the opening marker
4. if not found, return `""`
5. return `substring(start + 1, end)`

**Things the hand example showed:**

- Searching for the closing marker from `start + 1` matters. Otherwise a `]` that appears earlier in the string would be picked up.
- `+ 1` skips the marker itself, because `[` is one character long. For a longer opening marker like `"<b>"`, it becomes `start + marker.length()`.
- Both searches can fail, so both need the `-1` check.

The code is in `examples/TextExtractor.java`.

## Translating into code

After the steps are written down, the code is almost line-for-line:

```java
public static String between(String text, String open, String close) {
    int start = text.indexOf(open);
    if (start == -1) {
        return "";
    }
    int from = start + open.length();
    int end = text.indexOf(close, from);
    if (end == -1) {
        return "";
    }
    return text.substring(from, end);
}
```

## Testing

Cases worth trying for almost any string method:

- the normal case
- the thing you're searching for is missing
- it's at the very start or very end
- an empty string
- the thing appears more than once
