# Reading documentation

Nobody remembers every method of every class. Knowing how to look things up is the actual skill.

Java documentation (Javadoc) has the same layout for every class:

- **Class description** at the top: what the class is for, sometimes with an example.
- **Constructor summary**: the ways to create an object and the arguments each one needs.
- **Method summary**: one line per method with its return type, name and parameters. This is the part I use most.
- **Method details**: what it does exactly, what each parameter means, what it returns, and which exceptions it can throw.

## How I use it

1. Find the class, e.g. [`Math`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Math.html) or [`String`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html).
2. Scan the method summary for something that matches what I need.
3. Check the return type. Is it an `int`, a `double`, a new object, or `void`?
4. Read the details for edge cases, like what happens if the value isn't found.

A method listed as `static` is called on the class (`Math.sqrt(16)`). Otherwise I need an object first.

The course's own library has documentation in the same format, so the process is the same for those classes.

## Javadoc comments in my own code

Comments starting with `/**` above a class or method are Javadoc comments. Tools (and BlueJ's "Documentation" view) turn them into the same kind of page:

```java
/**
 * Returns the distance from this point to another point.
 */
public double distanceTo(Point other) { ... }
```
