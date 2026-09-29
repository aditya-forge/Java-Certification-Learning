# Separation of concerns

Each method should do one job. The most common way I break this rule is a method that both finds something and prints it.

## Return, don't print

```java
// harder to reuse: it can only ever print
public static void printFirstWord(String s) {
    System.out.println(s.substring(0, s.indexOf(" ")));
}

// better: the caller decides what to do with the result
public static String firstWord(String s) {
    int space = s.indexOf(" ");
    if (space == -1) {
        return s;
    }
    return s.substring(0, space);
}
```

The returning version can be printed, stored, compared in a test, or used by another method. The printing version can only be printed.

## Split finding from processing

When a problem is "find all X and then do something with them", split it into:

1. a method that finds one X starting from a position
2. a method that loops, calling the first one, and collects every X
3. whatever uses the collection (counting, filtering, printing)

Each part can be tested on its own, and when the "do something" part changes, the finding code doesn't need touching.

## Test methods

It helps to write a separate method that runs a set of known inputs through a method and prints expected vs actual. When something breaks later, run the tests again. That's what the `test...` methods in my examples are for.
