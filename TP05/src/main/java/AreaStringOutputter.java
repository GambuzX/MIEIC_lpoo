public class AreaStringOutputter {

    private SumProvider area_aggr;

    public AreaStringOutputter(SumProvider area_a) {
        area_aggr = area_a;
    }

    public String output() {
        return "Sum of areas: " + area_aggr.sum();
    }
}
