# Mini project overview: baby names data

The last module is a mini project that puts the earlier modules together on a large real dataset: the number of babies given each first name in the US, for every year since 1880.

## How the data is laid out

- One file per year.
- No header row. Each line is `name,gender,count`, for example `Mary,F,7065`.
- Within a file, all the girls' names come first, then the boys'. Each group is sorted from most to least popular.
- Only names given to at least a handful of babies are included.

The course provides small test files as well as the full set. Working out answers by hand on the tiny files first, then running on the real data, is the same test-small-first habit as before.

## What kind of questions it asks

The questions are about popularity and trends:

- totals: how many births or distinct names in a year, split by gender
- rank: a name's position within its gender for a year (1 = most popular)
- the reverse lookup: which name had a given rank
- following a name across many years, e.g. the year it was most popular

## Skills it pulls together

- reading CSV without a header (`headerless-csv.md`)
- converting the count column to a number
- filtering by a column (gender)
- counting position within a filtered group
- looping over many files and remembering the best so far
- building a filename from a year, e.g. `"yob" + year + ".csv"`

My own practice with these skills is the library checkouts mini project in [`projects/library-checkouts`](../../projects/library-checkouts), which uses different data and questions.
