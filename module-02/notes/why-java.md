# Why Java

Some reasons Java is a common first "serious" language and still widely used:

- **Runs almost anywhere.** Java compiles to bytecode, not machine code. The JVM (Java Virtual Machine) runs that bytecode, so the same `.class` files work on Windows, Mac and Linux.
- **Static typing.** The compiler catches type mistakes before the program runs, like putting a `String` into an `int` or calling a method that doesn't exist. Beginners get errors earlier and with clearer messages.
- **Object oriented.** Programs are built from classes and objects, which is how most large codebases are organised.
- **Huge standard library.** Lists, maps, files, networking and dates are all built in, and there are libraries for almost everything else.
- **Used a lot in practice.** Android apps, backend servers, big data tools, and a lot of university courses and interview prep.

Trade-offs I noticed compared to Python: more typing (declaring types, `public static void main`, semicolons), but that extra structure makes it easier to see what a piece of code expects.

## How a Java program runs

```
HelloJava.java  --javac-->  HelloJava.class (bytecode)  --java (JVM)-->  runs
```

BlueJ does the compile step when you press Compile, and runs methods on objects directly, but the same two steps happen underneath.
