public class AreaXMLOutputter {

    private SumProvider area_aggr;

    public AreaXMLOutputter(SumProvider area_a) {
        area_aggr = area_a;
    }

    public String output() {
        return "<area>" + area_aggr.sum() + "</area>";
    }
}
