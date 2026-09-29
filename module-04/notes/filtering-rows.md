# Filtering rows

The first CSV problem in the course is about trade data: which countries export a certain product. The general shape of that problem comes up all the time, so this is the pattern rather than the course's version.

## The pattern

"For every row, if some column matches a condition, do something with other columns of that row."

```java
for (CSVRecord record : parser) {
    String category = record.get("Category");
    if (category.equals("Electronics")) {
        System.out.println(record.get("Name"));
    }
}
```

Steps I use to work one out by hand (seven steps again):

1. Look at two or three actual rows of the file.
2. Decide which column the condition is about, and what counts as a match.
3. Decide what to output from matching rows.
4. Decide whether to print, count, or collect the matches.

## Exact match vs contains

- `equals("Kitchen")` is for a column holding exactly one value.
- `contains("coffee")` is for a column holding a list of things in one field, like `"coffee, tea, sugar"`. The CSV library already removed the outer quotes, so it's just a string search.

`contains` can match more than intended: `contains("tea")` also matches `"steam"`. Checking against a list split on `", "` is stricter.

## Two conditions

```java
if (record.get("Category").equals("Bags") && !record.get("Stock").equals("0")) { ... }
```

Same `&&` / `||` rules as Module 3.

## Looking up one row

A special case of filtering: find the row where a key column equals a value, return its info, and stop.

```java
for (CSVRecord record : parser) {
    if (record.get("Name").equals(name)) {
        return name + ": " + record.get("Price");
    }
}
return "NOT FOUND";
```

`return` inside the loop stops as soon as it's found. The "not found" return goes after the loop, not in an `else` inside it. Putting it in an `else` would give up after checking only the first row.

## Counting instead of printing

Replace the `println` with `count++`, and return the count. This is the same separation-of-concerns idea as before: the filtering loop stays the same, and only what's done with each match changes.
