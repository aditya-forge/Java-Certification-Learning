# Environment setup

## JDK

The JDK (Java Development Kit) contains the compiler (`javac`) and the runtime (`java`). The JRE alone only runs programs, so it's not enough for writing code.

After installing, check both tools are on the PATH:

```
java -version
javac -version
```

If `javac` is not recognised on Windows, the JDK `bin` folder has to be added to the PATH environment variable, then the terminal restarted.

## BlueJ

The course uses BlueJ. It is a simple IDE made for learning: it shows classes as boxes, and you can right-click a class to create an object and call its methods directly without writing a `main` method. That is handy for testing one method at a time.

BlueJ comes with its own JDK in the Windows installer, so it works even if the system JDK is a different version.

## Compiling and running from the terminal

Worth knowing outside BlueJ as well.

```
javac HelloJava.java     # creates HelloJava.class
java HelloJava           # runs it (no .class extension)
```

Things that tripped me up:

- The file name must match the public class name exactly, including capitals. `HelloJava` has to be in `HelloJava.java`.
- `java` takes the class name, not the file name.
- Since Java 11 you can run a single file directly with `java HelloJava.java`, which skips the separate compile step. Useful for quick tests.
