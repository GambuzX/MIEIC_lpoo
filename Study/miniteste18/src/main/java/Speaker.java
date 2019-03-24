import java.util.Objects;

public class Speaker extends Person {

    private int fee;

    public Speaker(String name) {
        this.name = name;
        this.age = 0;
    }

    public Speaker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + name + " as a fee value of " + fee + ".";
    }
}
