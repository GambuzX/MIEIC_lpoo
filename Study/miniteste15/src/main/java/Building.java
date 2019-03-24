import java.util.ArrayList;
import java.util.List;

public class Building implements Facility{
    private String name;
    private int minFloor, maxFloor;

    private List<Room> rooms = new ArrayList<Room>();

    public Building(String name, int minFloor, int maxFloor) {
        if (minFloor > maxFloor) throw new IllegalArgumentException();
        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public String toString() {
        return "Building(" + name + ")";
    }

    protected void addRoom(Room r) throws DuplicateRoomException {
        for (Room room : rooms)
            if (room.getNumber() == r.getNumber())
                throw new DuplicateRoomException();
        rooms.add(r);
    }

    public int getCapacity() {
        int total = 0;
        for (Room room : rooms)
            total += room.getCapacity();
        return total;
    }

    public boolean canEnter(User usr) {
        for (Room room : rooms)
            if (room.canEnter(usr))
                return true;
        return false;
    }
}
