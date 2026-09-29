# Storing results

Printing results inside a loop is fine for testing, but usually the results are needed afterwards: count them, filter them, find the longest. So they need storing.

## StorageResource

The course's library has a `StorageResource` class. It's a simple container for strings:

- `add(String)` stores a string
- `size()` returns how many are stored
- `data()` returns something that can be looped over with for-each

```java
StorageResource found = new StorageResource();
// in the loop: found.add(item);
for (String item : found.data()) { ... }
```

## ArrayList, the standard Java version

Outside the course library, the standard class for this is `ArrayList`, and it's what I'll use in real code:

```java
import java.util.ArrayList;

ArrayList<String> found = new ArrayList<>();
found.add("first");
found.add("second");
found.size();          // 2
found.get(0);          // "first"
for (String item : found) { ... }
```

- `<String>` says what type the list holds. It can't hold primitives directly, so `int` becomes `ArrayList<Integer>`.
- Unlike an array, it grows as items are added, which is exactly what's needed when you don't know how many matches there will be.

## The pattern

```java
public static ArrayList<String> findAll(...) {
    ArrayList<String> results = new ArrayList<>();
    // loop: find the next one, results.add(it), move on
    return results;
}
```

Then separate methods use the list: how many, which is longest, which contain some text. This is separation of concerns again.
