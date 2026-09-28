# Using BlueJ

Setup is in `module-01/notes/environment-setup.md`. This is about actually working in it.

## Projects and classes

- A BlueJ project is just a folder. Each class shows up as a box in the main window.
- Striped boxes need compiling. Press Compile after every change.
- Arrows between boxes show which classes use which.

## Running code without main

The main difference from a normal IDE:

1. Right-click a class and choose `new ClassName(...)`. The object appears in the object bench at the bottom.
2. Right-click the object to see its methods. Pick one, fill in the arguments, and the result is shown in a dialog.
3. Static methods can be called by right-clicking the class itself.

This makes it easy to test one method at a time while writing a class. Outside BlueJ, the same test needs a `main` method, which is why all my examples have one.

## Other useful bits

- **Codepad** (View > Show Code Pad): type a Java expression or statement and see the result immediately. Good for checking things like `7 / 2`.
- **Terminal window**: where `System.out.println` output goes. Clearing it between runs (Options > Clear screen at method call) avoids mixing up old and new output.
- **Using a library**: the course's helper classes are added as a library in BlueJ's preferences, then imported at the top of a class with `import`.
- Compile errors are highlighted on the line, and the message appears at the bottom of the editor.
