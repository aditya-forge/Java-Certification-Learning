# Classes and objects

A class is a blueprint. An object is one thing built from it, with its own copy of the data.

```java
public class BankAccount {
    private String owner;     // fields: the object's data
    private double balance;

    public BankAccount(String owner) {   // constructor
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount) { // instance method
        balance += amount;
    }
}
```

```java
BankAccount a = new BankAccount("Riya");
BankAccount b = new BankAccount("Karan");
a.deposit(500);   // only a's balance changes
```

## Parts of a class

- **Fields** hold the state. I make them `private` so other classes have to go through methods, and the class keeps control over its data. For example, `withdraw` can refuse to go below zero.
- **Constructor** has the same name as the class and no return type. It runs when `new` is used and sets up the fields.
- **`this`** refers to the current object. It's needed when a parameter has the same name as a field: `this.owner = owner;`.
- **Methods** without `static` work on a particular object's fields.

## `new` and references

`new BankAccount("Riya")` creates the object and gives back a reference to it. The variable stores that reference, not the object itself.

```java
BankAccount x = a;   // x and a point to the same object
x.deposit(100);      // a's balance also goes up
```

A reference variable that doesn't point to anything is `null`. Calling a method on it throws a `NullPointerException`.

## toString

If a class overrides `toString()`, printing an object shows something readable instead of `BankAccount@1b6d3586`.

## Using classes written by others

The course uses ready-made classes from a library (for example classes for points, shapes and files). The process is the same as for my own classes: read what the constructor needs, create the object with `new`, then call its methods. The documentation is where you find out which methods exist.
