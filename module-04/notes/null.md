# null: when you don't have an object

A variable of a class type (`String`, `CSVRecord`, `Point`...) holds a reference to an object. `null` is a special value meaning "no object at all".

```java
CSVRecord best = null;   // no record yet
```

## Where it's useful

- "not found yet" or "nothing so far", as the starting value when looking for a best record
- a method returning `null` to mean "there was no answer", for example the largest record of an empty file

Primitives (`int`, `double`, `boolean`) can't be `null`. That's one reason the find-the-maximum loop keeps a `CSVRecord` rather than a `double`.

## NullPointerException

Calling a method or reading a field through a `null` reference throws a `NullPointerException`:

```java
CSVRecord best = null;
best.get("Revenue");   // NullPointerException
```

It's one of the most common runtime errors. The fix is almost never "catch it". Instead, make sure the variable can't be `null` at that point, or check first:

```java
if (best != null) {
    System.out.println(best.get("Revenue"));
}
```

## Comparing with null

Use `==` and `!=`: `if (best == null)`. Not `best.equals(null)`, because if `best` is `null`, calling `.equals` on it is itself a null pointer error.

## Returning null

If a method can return `null`, the caller must check. It helps to say so in the method's comment, like "returns null if the file has no valid rows", so whoever calls it knows.
