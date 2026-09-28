public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceTo(Point other) {
        int dx = other.x - x;
        int dy = other.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean isOrigin() {
        return x == 0 && y == 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(3, 4);
        Point c = new Point(-2, 7);

        System.out.println("Distance " + a + " to " + b + ": " + a.distanceTo(b));
        System.out.println("Distance " + b + " to " + c + ": " + b.distanceTo(c));
        System.out.println(a + " is origin: " + a.isOrigin());

        // which of these points is furthest from the origin?
        Point[] points = {b, c, new Point(1, 1)};
        Point furthest = points[0];
        for (Point p : points) {
            if (a.distanceTo(p) > a.distanceTo(furthest)) {
                furthest = p;
            }
        }
        System.out.println("Furthest from origin: " + furthest);
    }
}
