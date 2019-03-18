public class Elipse extends Shape {
    private double x_radius, y_radius;

    public Elipse(double x, double y) {
        x_radius = x;
        y_radius = y;
    }

    public double getX_radius() {
        return x_radius;
    }

    public double getY_radius() {
        return y_radius;
    }
}
