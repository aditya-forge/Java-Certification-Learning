# Converting strings to numbers

Everything read from a CSV file is a `String`. `"45"` looks like a number, but `"45" > "100"` doesn't compile, and sorting strings puts `"9"` after `"10"`. Numbers have to be converted before any maths or comparisons.

```java
int stock = Integer.parseInt(record.get("Stock"));
double price = Double.parseDouble(record.get("Price"));
```

- `Integer.parseInt` for whole numbers
- `Double.parseDouble` for decimals. It also accepts whole numbers like `"45"`.
- `Long.parseLong` for large whole numbers

## When the text isn't a number

`Integer.parseInt("N/A")` throws a `NumberFormatException` and the program stops. So does an empty string, and `"4.5"` passed to `parseInt`. Real data files nearly always have some of these.

Two ways to deal with it:

**Check first**, when the bad values are known:

```java
String r = record.get("Rating");
if (!r.equals("N/A")) {
    double rating = Double.parseDouble(r);
    ...
}
```

**Catch the exception**, when anything could turn up:

```java
try {
    double rating = Double.parseDouble(r);
    ...
} catch (NumberFormatException e) {
    // skip this row
}
```

I prefer checking when I know the file's conventions, since it makes the rule visible in the code. `try/catch` is the safety net for unknown files.

## Placeholder numbers

Some datasets use an impossible number for "missing", like `-9999` for a temperature or `-1` for a count. These parse fine, so no exception warns you. They quietly ruin a minimum or an average. Look at the data, find out which placeholder is used, and skip it explicitly.

## Converting back

- `String.valueOf(42)` or `"" + 42` turns a number into a `String`
- printing with `+` converts automatically
