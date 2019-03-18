public class AreaStringOutputter {

    private AreaAggregator area_aggr;

    public AreaStringOutputter(AreaAggregator area_a) {
        area_aggr = area_a;
    }

    public String output() {
        return "<area>" + area_aggr.sum() + "</area>";
    }
}
