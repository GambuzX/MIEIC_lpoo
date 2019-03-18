
public class Application {
    public static void main(String[] args) {
        AreaAggregator area_agg = new AreaAggregator();
        /*
        HasArea ele1 = new Circle(2);
        HasArea ele2 = new Square(12);
        HasArea ele3 = new Elipse(2, 3);
        HasArea ele4 = new Triangle(2, 4);
        HasArea ele5 = new Rectangle(6, 4);
*/
        HasArea house = new House(2,2, 12);
        /*
        area_agg.addEle(ele1);
        area_agg.addEle(ele2);
        area_agg.addEle(ele3);
        area_agg.addEle(ele4);
        area_agg.addEle(ele5);*/
        area_agg.addEle(house);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(area_agg);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(area_agg);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
