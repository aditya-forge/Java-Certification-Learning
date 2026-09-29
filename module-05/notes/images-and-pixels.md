# Images and pixels

The second half of the module switches from text data to images. The idea is the same: a big collection of small pieces, processed one at a time with a loop.

## What an image is

- A grid of pixels, `width` by `height`.
- Each pixel has a colour made of three values, red, green and blue, each from 0 to 255.
  - `(0, 0, 0)` is black, `(255, 255, 255)` is white
  - equal red, green and blue gives a shade of grey
- Position `(0, 0)` is the top-left corner. `x` goes right and `y` goes down.

## Looping over pixels

The course's `ImageResource` class has a `pixels()` method that can be used in a for-each loop, one `Pixel` at a time, with `getRed()` / `setRed()` style methods. It's the same for-each pattern as points in a shape or records in a CSV file.

In plain Java, `BufferedImage` does the job with nested loops over `x` and `y`:

```java
for (int y = 0; y < img.getHeight(); y++) {
    for (int x = 0; x < img.getWidth(); x++) {
        Color c = new Color(img.getRGB(x, y));
        // work out the new colour, then img.setRGB(x, y, newColor.getRGB());
    }
}
```

## Read from one image, write to another

When the new value of a pixel only depends on that same pixel, editing in place is fine. For effects that look at neighbouring pixels, like blur or mirror, read from the original and write to a new blank image. Otherwise pixels that were already changed get read again.

## Grayscale, the idea

Grayscale is what the lectures build with the seven steps. A grey pixel has equal red, green and blue, so the question is what single value to use for all three. The simple answer is the average of the three. Working a couple of pixels by hand makes the algorithm obvious, and the translation to code is short.

## Staying in range

Colour values must stay between 0 and 255. Anything that adds to or multiplies a value, like brightening, needs clamping: `Math.min(255, value)`.

My own example (`examples/BatchImageEffects.java`) does brightening and a black-and-white threshold, both following the same loop.
