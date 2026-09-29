import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;

public class BatchImageEffects {

    public static BufferedImage brighten(BufferedImage source, int amount) {
        BufferedImage out = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                Color c = new Color(source.getRGB(x, y));
                // clamp so values never go past 255
                int r = Math.min(255, c.getRed() + amount);
                int g = Math.min(255, c.getGreen() + amount);
                int b = Math.min(255, c.getBlue() + amount);
                out.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return out;
    }

    // every pixel becomes pure black or pure white depending on its brightness
    public static BufferedImage blackAndWhite(BufferedImage source, int threshold) {
        BufferedImage out = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                Color c = new Color(source.getRGB(x, y));
                int brightness = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                Color result = brightness >= threshold ? Color.WHITE : Color.BLACK;
                out.setRGB(x, y, result.getRGB());
            }
        }
        return out;
    }

    // makes a small striped test image so the example runs without any image files
    public static BufferedImage makeSample(Color a, Color b) {
        BufferedImage img = new BufferedImage(60, 40, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                img.setRGB(x, y, ((x / 10) % 2 == 0 ? a : b).getRGB());
            }
        }
        return img;
    }

    public static void processFolder(File input, File output) throws IOException {
        output.mkdirs();
        for (File f : input.listFiles()) {
            if (!f.getName().endsWith(".png")) {
                continue;
            }
            BufferedImage img = ImageIO.read(f);
            // new names with a prefix, originals are left untouched
            ImageIO.write(brighten(img, 60), "png", new File(output, "bright-" + f.getName()));
            ImageIO.write(blackAndWhite(img, 128), "png", new File(output, "bw-" + f.getName()));
            System.out.println("processed " + f.getName());
        }
    }

    public static void main(String[] args) throws IOException {
        File input = Files.createTempDirectory("images-in").toFile();
        File output = new File(input.getParentFile(), input.getName() + "-out");

        ImageIO.write(makeSample(new Color(200, 40, 40), new Color(30, 30, 90)), "png", new File(input, "stripes.png"));
        ImageIO.write(makeSample(new Color(240, 220, 90), new Color(20, 120, 60)), "png", new File(input, "flag.png"));

        processFolder(input, output);

        System.out.println("Output folder: " + output);
        for (String name : output.list()) {
            System.out.println("  " + name);
        }
    }
}
