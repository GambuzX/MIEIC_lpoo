
public class Application {
    public static void main(String[] args) {
        AreaAggregator area_agg = new AreaAggregator();
        Shape shape1 = new Circle(2);
        Shape shape2 = new Square(12);
        Shape shape3 = new Elipse(2, 3);
        Shape shape4 = new Triangle(2, 4);
        Shape shape5 = new Rectangle(6, 4);

        area_agg.addShape(shape1);
        area_agg.addShape(shape2);
        area_agg.addShape(shape3);
        area_agg.addShape(shape4);
        area_agg.addShape(shape5);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(area_agg);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(area_agg);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
