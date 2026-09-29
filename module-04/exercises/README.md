# Module 4 exercises

These use my own data in `data/`: a product list and three months of sales. Run the solutions from the `module-04` folder with the Commons CSV jar on the classpath:

```
java -cp commons-csv-1.10.0.jar exercises/solutions/CategoryStats.java
```

**1. Category stats** (`products.csv`)
For a given category, print how many products it has and the total value of its stock (price times stock, added up). Electronics: 3 products, stock value 41,945.
Covers: filtering rows, `parseInt` / `parseDouble`, accumulating.

**2. Average rating** (`products.csv`)
Work out the average rating, skipping products whose rating is `N/A`. Also print how many were skipped.
Covers: checking for missing values before parsing.

**3. Cheapest in stock** (`products.csv`)
Return the `CSVRecord` of the cheapest product that has stock greater than 0, and print its name and price. Products with 0 stock must not win even if they're cheaper.
Covers: the `null` start for "best so far", with a filter on top.

**4. Best month** (`data/sales/`)
For each monthly sales file, add up that month's revenue, skipping rows where revenue is `N/A`. Print each month's total and the month with the highest total.
Covers: processing several files, totals rather than single rows.
