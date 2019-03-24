public class Attendee extends Person {

    public Attendee(String name) {
        this.name = name;
        this.age = 0;
    }
    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean hasPaid() {
        return false;
    }

    public String toString() {
        return "Attendee " + name + " hasn't paid its registration.";
    }

}
