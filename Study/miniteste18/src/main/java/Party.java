import java.util.ArrayList;
import java.util.List;

public class Party extends Event {

    List<Event> events = new ArrayList<Event>();

    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public Party(Event event) {
        super(event);
    }

    public void addEvent(Event e) {
        events.add(e);
        for (Person person : e.getPersons())
            this.addPerson(person);
    }
}
