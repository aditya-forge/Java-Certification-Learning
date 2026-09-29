# Module 3 exercises

String practice problems. Solutions are in `solutions/`, each with test cases in `main`.

**1. Palindrome**
`isPalindrome(String s)` should return true if `s` reads the same forwards and backwards, ignoring case and spaces. `"Never odd or even"` is true, and `"Java"` is false.
Covers: `charAt`, two positions moving towards each other, `toLowerCase`.

**2. Vowel count**
`countVowels(String s)` counts a, e, i, o, u, in either case.
Covers: looping over characters, `indexOf` on a short string as a lookup.

**3. Hashtags**
Given a post like `"Loving the #monsoon in #Pune today #rain"`, return an `ArrayList` with every hashtag word (`monsoon`, `Pune`, `rain`). A tag ends at a space or at the end of the text.
Covers: `while` loop with `indexOf(str, from)`, `substring`, storing results.

**4. Email parts**
`domain(String email)` returns everything after the `@`, and `username(String email)` returns everything before it. Return `""` when there is no `@`.
Covers: `indexOf`, the `-1` check, `substring`.

**5. Run-length compression**
`compress("aaabbcdddd")` returns `"a3b2c1d4"`.
Covers: comparing each character with the previous one, building a result string.

**6. Password rules**
`isStrong(String p)` is true only if the password is at least 8 characters, has an uppercase letter, a lowercase letter and a digit, and contains no spaces.
Covers: `&&`, boolean flags set inside a loop, `Character` helper methods.
