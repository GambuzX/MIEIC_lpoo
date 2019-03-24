import java.util.ArrayList;
import java.util.List;

public class Room implements Facility{
    private Building building;
    private String number;
    private int floor;
    private int capacity;

    private List<User> authorized_users = new ArrayList<User>();

    public Room(Building b, String n, int f) throws DuplicateRoomException {

        if (f < b.getMinFloor() || f > b.getMaxFloor()) throw new IllegalArgumentException();
        building = b;
        number = n;
        floor = f;
        building.addRoom(this);
    }

    public Room(Building b, String n, int f, int c) throws DuplicateRoomException {

        if (f < b.getMinFloor() || f > b.getMaxFloor()) throw new IllegalArgumentException();
        building = b;
        number = n;
        floor = f;
        capacity = c;
        building.addRoom(this);
    }

    public String getName() {
        return building.getName() + number;
    }

    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String toString() {
        return "Room(" + building.getName() + "," + number + ")";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void authorize(User usr) {
        authorized_users.add(usr);
    }

    public boolean canEnter(User usr) {
        return authorized_users.contains(usr);
    }
}
