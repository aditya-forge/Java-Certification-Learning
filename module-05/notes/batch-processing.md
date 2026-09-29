# Batch processing many files

Doing something to one file is the easy part. Doing it to a whole folder without clicking through each file is where a program actually saves time.

## Structure

Split it the same way as the multi-file maximum in Module 4:

1. a method that processes **one** file and returns the result, like a new image
2. a loop over all the files that calls it and saves each result

Build and test step 1 on a single file first.

## Choosing the files

- Course library: `DirectoryResource` opens a dialog to pick several files, and `selectedFiles()` returns them for a for-each loop.
- Plain Java: `new File(folder).listFiles()`, filtered by extension if needed.

## Saving with new names

Never overwrite the originals. If the code has a bug, the input is gone. The usual convention is a prefix on the original name:

```
photo.png   ->  bright-photo.png
beach.jpg   ->  bright-beach.jpg
```

```java
String newName = "bright-" + file.getName();
```

A prefix keeps the connection to the original file obvious and keeps related files next to each other when sorted. Writing into a separate output folder avoids processing the outputs again if the program is run a second time on the same folder.

## Summary of the module

Both halves are the same shape as everything since Module 2: **a loop over many items (files, rows, pixels), a small piece of logic per item, and either an accumulated answer or a saved result.** The seven-step approach worked the same way for names data and for pixels.
