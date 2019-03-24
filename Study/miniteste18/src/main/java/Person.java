import java.util.Objects;

public abstract class Person implements Comparable<Person>, User{
    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return name+age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return person.getName() == name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.getName());
    }
}
