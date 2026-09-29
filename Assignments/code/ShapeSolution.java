import java.util.ArrayList;
import java.util.List;

/**
 * Solutions for the Shape assignment questions.
 * Compile: javac ShapeSolution.java
 * Run:     java ShapeSolution
 */
public class ShapeSolution {

    // ---------- Point ----------
    static class Point {
        private final double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getX() { return x; }
        double getY() { return y; }

        double distanceTo(Point other) {
            double dx = x - other.x;
            double dy = y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    // ---------- Shape ----------
    static class Shape {
        private final List<Point> points = new ArrayList<>();

        void addPoint(Point p) { points.add(p); }

        List<Point> getPoints() { return points; }

        /** Perimeter: points joined in order, last point joined back to first. */
        double getPerimeter() {
            double total = 0;
            int n = points.size();
            for (int i = 0; i < n; i++) {
                total += points.get(i).distanceTo(points.get((i + 1) % n));
            }
            return total;
        }

        double getAverageSide() {
            return getPerimeter() / points.size();
        }

        double getLongestSide() {
            double longest = 0;
            int n = points.size();
            for (int i = 0; i < n; i++) {
                longest = Math.max(longest, points.get(i).distanceTo(points.get((i + 1) % n)));
            }
            return longest;
        }
    }

    // ---------- Question 6: correct getNumPoints ----------
    public static int getNumPoints(Shape s) {
        int count = 0;
        for (Point p : s.getPoints()) {
            count = count + 1;
        }
        return count;
    }

    // ---------- mysteryShape ----------
    // Returns the fraction of points with positive X and negative Y.
    public static double mysteryShape(Shape s) {
        double tmp = 0;
        for (Point p : s.getPoints()) {
            if (p.getX() > 0) {
                if (p.getY() < 0) {
                    tmp = tmp + 1;
                }
            }
        }
        return tmp / getNumPoints(s);
    }

    // ---------- Helpers ----------
    /** Truncates (not rounds) to two decimal places. */
    static double truncate2(double v) {
        return Math.floor(v * 100) / 100.0;
    }

    /** Loads a shape from lines like "-3, 9". */
    static Shape fromLines(String... lines) {
        Shape s = new Shape();
        for (String line : lines) {
            String[] parts = line.trim().split("\\s*,\\s*");
            s.addPoint(new Point(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
        }
        return s;
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        Shape s1 = fromLines("-3,3", "-4,-3", "4,-2", "6,5");
        Shape s2 = fromLines("-3,4", "-3,-5", "3,-5", "3,4");
        Shape s3 = fromLines("-4,-3", "4,-2", "12,2", "6,5", "-3,3", "-8,1");
        Shape s4 = fromLines("-3,9", "-8,7", "-12,4", "-6,-2", "-4,-6",
                             "2,-8", "6,-5", "10,-3", "8,5", "4,8");
        Shape s5 = fromLines("-15,8", "-8,-6", "7,-2", "4,10");
        Shape s6 = fromLines("-13,8", "-8,-6", "5,-2", "2,10");

        Shape[] shapes = {s1, s2, s3, s4, s5, s6};

        int best = 0;
        for (int i = 0; i < shapes.length; i++) {
            double per = shapes[i].getPerimeter();
            System.out.println("dataset" + (i + 1) + ".txt perimeter = " + truncate2(per));
            if (per > shapes[best].getPerimeter()) best = i;
        }
        System.out.println("Largest perimeter: dataset" + (best + 1) + ".txt = "
                + truncate2(shapes[best].getPerimeter()));

        System.out.println("Dataset1 average side = " + truncate2(s1.getAverageSide()));
        System.out.println("Dataset4 longest side = " + truncate2(s4.getLongestSide()));

        System.out.println("Dataset4 numPoints = " + getNumPoints(s4));
        System.out.println("Dataset4 mysteryShape = " + mysteryShape(s4));
    }
}
