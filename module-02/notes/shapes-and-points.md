# Shapes as collections of points

The course introduces programming with a geometry example: a shape (a polygon) can be described completely by its corner points, listed in order. Each point is just an x and a y.

That gives a nice first example of modelling something with classes:

- a `Point` class holds `x` and `y`, and knows how to work out its distance to another point
- a shape class holds a list of points, and you loop over them with a for-each loop

## Distance between two points

This is the basic calculation everything else builds on. Using Pythagoras:

```
distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
```

In Java:

```java
double dx = other.x - this.x;
double dy = other.y - this.y;
return Math.sqrt(dx * dx + dy * dy);
```

`Math.sqrt` returns a `double`, so the distance is a `double` even when the coordinates are whole numbers.

## Walking around a shape

Because the points are in order, the sides of the shape are formed by each point and the one before it, and the last point connects back to the first. When looping over the points, one trick is to remember the previous point in a variable before the loop starts, so every iteration has a pair to work with.

## Why this example works for learning

It uses almost everything from this module at once: creating objects with `new`, calling methods on them, storing a result in a variable, doing maths with `double`s, and a for-each loop. I tried the idea out with my own small `Point` class in `examples/Point.java`.
