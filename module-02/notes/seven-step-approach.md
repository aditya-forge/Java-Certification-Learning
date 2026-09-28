# Seven steps for solving a problem

The course uses a fixed process for going from a problem to working code. The main point is not to start by typing code. My summary:

1. **Work a small example by hand.** Pick a specific, small input and solve it yourself.
2. **Write down exactly what you did.** Every step, even the obvious ones, for that one example.
3. **Generalize.** Look for repetition, which becomes a loop, and for specific values that should be variables.
4. **Test the steps by hand** on a different input. If the steps give the wrong answer, go back to step 3 (or step 1 if the problem was misunderstood).
5. **Translate to code.** This should mostly be mechanical by now.
6. **Run test cases.** Include edge cases: empty input, one element, all negative values, and so on.
7. **Debug.** If a test fails, work out whether the algorithm is wrong (back to steps 1 to 3) or just the translation into code (step 5).

## Example: count how many numbers in a list are greater than 10

1. List `4, 15, 10, 22`: I look at each number and count 15 and 22, so the answer is 2.
2. Look at 4, not above 10. Look at 15, above 10, count 1. Look at 10, not above. Look at 22, above, count 2. Answer 2.
3. Start count at 0; for each number, if it's above 10, add 1 to count; the answer is count.
4. Try `11, 3`: count becomes 1, which is correct.
5. and 6. That becomes the counting loop in `examples/LoopsDemo.java`, tested with a list containing negatives.

This feels slow on easy problems, but it helps a lot once a problem is too big to hold in my head.
