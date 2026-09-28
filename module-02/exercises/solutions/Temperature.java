public class Temperature {

    private double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    public boolean isFreezing() {
        return celsius <= 0;
    }

    @Override
    public String toString() {
        return celsius + " C (" + getFahrenheit() + " F)";
    }

    public static void main(String[] args) {
        Temperature morning = new Temperature(-2);
        Temperature afternoon = new Temperature(31.5);

        System.out.println(morning + " freezing: " + morning.isFreezing());
        System.out.println(afternoon + " freezing: " + afternoon.isFreezing());
    }
}
