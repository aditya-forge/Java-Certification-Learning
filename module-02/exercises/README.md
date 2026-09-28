# Module 2 exercises

Practice problems for the basics in this module. I tried each one before writing the solution, and solutions are in `solutions/`.

**1. Leap year**
Write `isLeapYear(int year)`. A year is a leap year if it's divisible by 4, except years divisible by 100, unless they're also divisible by 400. Check: 2024 yes, 1900 no, 2000 yes, 2023 no.
Covers: `%`, `&&`, `||`, returning a boolean.

**2. Digit sum**
Write `digitSum(int n)` that returns the sum of the digits of a non-negative number. `digitSum(4827)` is 21.
Covers: `while` loop, `%` and `/`.

**3. Electricity bill**
Units are charged in slabs: the first 100 units at 5 per unit, the next 100 at 7, and anything above 200 at 10. Write `billAmount(int units)`. 250 units comes to 500 + 700 + 500 = 1700.
Covers: `if / else if`, working out an example by hand first.

**4. Temperature class**
Create a `Temperature` class that stores a value in Celsius. It needs a constructor, `getCelsius()`, `getFahrenheit()`, `isFreezing()` (at or below 0 C), and `toString()`.
Covers: fields, constructor, instance methods.

**5. Array summary**
Given an `int[]`, print the largest value, the smallest value, the average (as a `double`), and how many values are above the average. Should work when all values are negative.
Covers: for-each, accumulate/count/max patterns, integer division.

**6. Number pattern**
Print this using nested loops, for any `n` (here `n = 4`):

```
1
1 2
1 2 3
1 2 3 4
```

Covers: nested `for` loops.
