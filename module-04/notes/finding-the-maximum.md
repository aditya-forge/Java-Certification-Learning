# Finding the maximum in a CSV file

The second problem in the module is finding the hottest reading in a weather file. The same algorithm finds any "row with the largest value", so my version uses sales data.

## Developing the algorithm

By hand, with four rows of revenue `10200, 15300, 8400, 13800`:

1. Look at the first row. It's the best so far: 10200.
2. Next row, 15300, is bigger, so it becomes the best so far.
3. 8400 is not bigger, so nothing changes.
4. 13800 is not bigger than 15300, so nothing changes.
5. The best so far at the end is the answer: 15300.

Generalized:

- best so far = nothing yet
- for each row: if there's no best yet, or this row's value is bigger, this row becomes the best
- return the best

Return the whole **row** (`CSVRecord`), not just the number. Then the caller can also get the date or the store from it.

## Why "nothing yet" is null

What should "best so far" start as? Starting at `0` breaks when every value is negative, like temperatures in winter. Starting at the first row is awkward with a parser, since there's no `get(0)`. So it starts as `null`, meaning "no record yet":

```java
CSVRecord largest = null;
for (CSVRecord current : parser) {
    if (largest == null) {
        largest = current;
    } else {
        double currentValue = Double.parseDouble(current.get("Revenue"));
        double largestValue = Double.parseDouble(largest.get("Revenue"));
        if (currentValue > largestValue) {
            largest = current;
        }
    }
}
return largest;
```

`null` is explained properly in `null.md`.

## Testing it

Tests that actually catch mistakes:

- a small file where the answer is known by hand
- the largest value in the first row, and in the last row
- two rows tied for largest. The first one should win when using `>`, and the last one when using `>=`. Decide which is wanted.
- bad rows (`N/A`, placeholder values). The loop should skip them, not crash or pick them.
- a file with no data rows. The result is `null`, and the caller has to handle that.
