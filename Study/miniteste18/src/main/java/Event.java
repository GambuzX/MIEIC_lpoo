import java.util.ArrayList;
import java.util.List;

public class Event {

    private String title;
    private String date;
    private String description;

    private List<Person> persons = new ArrayList<Person>();

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event event) {
        this.title = event.getTitle();
        this.date = event.getDate();
        this.description = event.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public boolean addPerson(Person newPerson) {
        for (Person person : persons)
            if (person.getName() == newPerson.getName())
                return false;
        persons.add(newPerson);
        return true;
    }

    public int getAudienceCount() {
        return persons.size();
    }

    @Override
    public String toString() {
        return title+" is a "+description+" and will be held at "+date+".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return title == event.getTitle() && description == event.getDescription() && date == event.getDate();
    }
}
