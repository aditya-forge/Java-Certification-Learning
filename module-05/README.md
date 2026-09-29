# Module 5 - MiniProject: Baby Names

The final module is a mini project on a large real dataset, US baby names by year, plus a second part on batch processing images. Nothing new in terms of syntax. It's about putting together CSV reading, loops over many files, best-so-far logic and the seven-step approach on bigger problems.

## Notes in lecture order

1. [Mini project overview](notes/miniproject-overview.md) (the baby names data and the kind of questions asked)
2. [CSV files without a header](notes/headerless-csv.md) (reading by column index, totals)
3. [Images and pixels](notes/images-and-pixels.md) (RGB, looping over pixels, the grayscale idea)
4. [Batch processing many files](notes/batch-processing.md) (choosing files, saving with new names, module summary)

## Key concepts

- Parsing CSV with no header row and reading columns by index
- Building a file name from a value, like a year
- Following one item across many files
- An image as a grid of RGB pixels, and keeping colour values in the 0 to 255 range
- Processing a whole folder and saving outputs with a prefix instead of overwriting

## What I practiced

- `examples/HeaderlessCsv.java`: reading a file without a header, and what goes wrong if the parser expects one
- `examples/BatchImageEffects.java`: brightening and black-and-white images for a whole folder, using plain Java `BufferedImage`
- My own mini project: [Library Checkouts](../projects/library-checkouts), yearly headerless CSV files with summaries, top titles, trends across years and the busiest genre

The course's Baby Names and Batch Grayscale programming exercises are not included.

## Folder structure

```
module-05/
├── README.md
├── notes/          (see list above)
└── examples/
    ├── HeaderlessCsv.java
    └── BatchImageEffects.java
```

`HeaderlessCsv` needs the Commons CSV jar (see Module 4). `BatchImageEffects` uses only the standard library, and it creates its own sample images in a temp folder, so it runs without any image files.

## Checklist

- [x] Mini project data overview
- [x] Headerless CSV and totals
- [x] Images and pixels
- [x] Batch processing and saving files
- [x] Own mini project (library checkouts)
