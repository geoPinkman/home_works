
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<String> courses;

    public Person() {

    }

    public Person(String name, int age, List<String> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
