# Methods

A method is a named block of code that can take inputs (parameters) and give back a result (return value). The course calls them functions at first, and they're the same idea.

```java
public static double celsiusToFahrenheit(double celsius) {
    return celsius * 9 / 5 + 32;
}
```

Reading the header left to right:

- `public`: can be called from other classes
- `static`: belongs to the class, so no object is needed to call it
- `double`: the type of value it returns
- `celsiusToFahrenheit`: the name
- `(double celsius)`: the parameter list

## Return types

- A method with a return type must `return` a value of that type on every path through the method, or it won't compile.
- `void` means nothing is returned. Those methods usually print something or change an object's state.
- `return` ends the method immediately, which is handy for early exits.

## Parameters

Java passes arguments by value. The method gets a copy, so reassigning a parameter inside the method doesn't change the caller's variable.

With objects, the copy is a copy of the reference. The method can still change the object's fields, but it can't make the caller's variable point to a different object.

## Static vs instance methods

- `static`: called on the class, like `Math.max(3, 7)`
- instance (no `static`): called on an object, like `account.deposit(100)`, and it can use that object's fields

For now most of my helper methods are `static`. Instance methods come in with classes.

## Why bother splitting code into methods

- Each method does one thing, so it's easier to test on its own. BlueJ is good for this, since you can call a single method directly.
- The same logic can be reused instead of copied.
- A good method name explains the code without needing a comment.
