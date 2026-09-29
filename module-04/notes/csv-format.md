# CSV: comma separated values

CSV is a plain text format for tables. Each line is a row, and commas separate the columns. The first line is usually a header with the column names.

```
Name,Category,Price,Stock,Rating
Notebook,Stationery,45,120,4.3
Gel Pen,Stationery,15,300,4.1
```

Spreadsheets can open and save it, and almost every language can read it, which is why so much public data (weather, trade, census) is published this way.

## Why not just split on commas?

It looks like `line.split(",")` would be enough, but a value can itself contain a comma. Then it's wrapped in double quotes:

```
"Desk Lamp, LED",Electronics,899,25,4.6
```

Splitting that line on commas gives 6 pieces instead of 5, and the lamp's name is broken in half. Quotes inside a quoted value are written twice (`""`), and quoted values can even contain line breaks. Handling all of that by hand is fiddly, so the course uses a library that already does it properly. See `examples/CsvFormatDemo.java` for the split problem in action.

## Things that vary between CSV files

- whether there's a header row
- the separator: some "CSV" files use `;` or tabs
- how missing values look: an empty field, `N/A`, `-`, or a number like `-9999`
- extra spaces around values

It's always worth opening a file in a text editor first and looking at a few lines before writing code for it.
