public class AreaXMLOutputter {

    private AreaAggregator area_aggr;

    public AreaXMLOutputter(AreaAggregator area_a) {
        area_aggr = area_a;
    }

    public String output() {
        return "Sum of areas: " + area_aggr.sum();
    }
}
