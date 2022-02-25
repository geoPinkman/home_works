
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        MongoDatabase mongoDB = MongoDbConnection.getInstance("students");

        MongoCollection<Person> collection = mongoDB.getCollection("persons", Person.class);
        collection.drop();
        collection.insertMany(InputData.getListFromFile());
        System.out.println("In \"" + collection.getNamespace() + "\" were added " + collection.countDocuments() + " strings data's");

        List<Person> test = new ArrayList<>();
        collection.find().forEach((Consumer<Person>) test::add);

        test.stream()
                .filter(person -> person.getAge() > 40)
                .forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        String name = test.stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new)
                .getName();
        System.out.println("Younger student is " +  name);

        System.out.println("Courses Elder student: ");

        test.stream().max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new)
                .getCourses().forEach(System.out::println);
    }

}
