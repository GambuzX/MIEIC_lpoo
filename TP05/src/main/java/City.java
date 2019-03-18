import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider{

    List<House> houses = new ArrayList<House>();

    public City(List<House> houses_list) {
        for (House house : houses_list) houses.add(house);
    }

    public void addHouse(House h) {
        houses.add(h);
    }

    public double sum() {
        double s = 0;
        for (House house : houses) s += house.getArea();
        return s;
    }
}
