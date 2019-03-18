import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private List<HasArea> area_elements = new ArrayList<>();

    public void addEle(HasArea area_ele) {
        area_elements.add(area_ele);
    }

    public double sum() {
        double sum = 0;
        for (HasArea area_ele: area_elements) {
            sum += area_ele.getArea();
        }
        return sum;
    }
}
