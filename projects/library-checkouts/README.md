# Library Checkouts

A small mini project I built after Module 5 to practise working with a set of yearly data files, using my own made-up library data instead of the course dataset.

## Data

`data/` has one file per year, `checkouts-2023.csv` to `checkouts-2025.csv`. There's no header, and each line is:

```
title,genre,count
```

Not every title appears every year, which is what makes the trend part interesting.

## What it does

- **Yearly summary**: number of titles and total checkouts for each year
- **Top title in a genre** for a given year
- **Trend for a title**: checkouts in each year and the peak year, with 0 for years it's missing
- **Busiest genre** over all years

## How it's built

- Column positions are constants (`TITLE`, `GENRE`, `COUNT`), since the files have no header
- `fileFor(year)` builds the file name from the year, so any year range works by changing two constants
- Each question is its own method that returns a value where it can, and `main` only prints
- Best-so-far loops start from `null` (for records) or `-1` (for the peak year)

## Running

Needs Apache Commons CSV. From this folder:

```
java -cp commons-csv-1.10.0.jar LibraryCheckouts.java
```

Sample output:

```
Yearly summary
2023: 7 titles, 638 checkouts
2024: 7 titles, 666 checkouts
2025: 8 titles, 790 checkouts

Top Fiction title each year
2023: The Silent River (142)
2024: Glass City (129)
2025: Glass City (151)

Trends
The Silent River: 2023=142 2024=118 2025=95  -> peak in 2023
Glass City: 2023=87 2024=129 2025=151  -> peak in 2025
Empire Roads: 2023=0 2024=48 2025=72  -> peak in 2025
Unknown Book: 2023=0 2024=0 2025=0  (never borrowed)

Checkouts per genre, all years
  Fiction: 722
  Science: 551
  History: 334
  Kids: 487
Busiest genre: Fiction
```

## Ideas to extend it

- rank of a title within its genre for a year
- average checkouts per title for each genre
- read the list of genres from the data instead of hard-coding it
