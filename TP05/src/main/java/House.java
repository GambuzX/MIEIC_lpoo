public class House implements HasArea {

    private double dim1, dim2;
    private int floors;

    public double getDim1() {
        return dim1;
    }

    public double getDim2() {
        return dim2;
    }

    public int getFloors() {
        return floors;
    }

    public House(double d1, double d2, int f) {
        dim1 = d1;
        dim2 = d2;
        floors = f;
    }

    @Override
    public double getArea() {
        return dim1 * dim2 * floors;
    }
}
