# DNA as a string problem

The course uses DNA as its running example for string processing. The biology is only there to give the string searching a real purpose. The actual gene-finding code is the course's programming exercise, so it's not in this repo, but the idea is worth writing down.

## The background

- DNA can be written as a long string made of four letters: `A`, `C`, `G`, `T`.
- It's read in groups of three letters called codons.
- A simplified gene starts at a start codon and runs until a stop codon. The start codon is `ATG`, and there are three possible stop codons: `TAA`, `TAG` and `TGA`.
- A valid gene's length has to be a multiple of 3, because it's made of whole codons.

## Why it's a good string exercise

It pulls together most of this module:

- `indexOf` to find where something starts
- searching from a position (`indexOf(str, from)`)
- `substring` to cut out the result
- `%` to check the "multiple of 3" rule
- `while` loops to keep searching when a match isn't valid, and later to find every match in a long string
- `&&` / `||` when there are several possible stop codons and the earliest valid one is needed
- storing all the results instead of printing them (the StorageResource part)

## Things to watch for, from the lectures' point of view

- A stop codon that appears at a position that isn't a multiple of 3 away from the start isn't really "in frame", so the search has to keep looking past it.
- DNA may be given in lowercase, so decide on one case before searching.
- When looking for all genes in a long string, continue searching after the end of the gene just found, not just one character later.

My own practice with these techniques is in `exercises/`, using different data.
