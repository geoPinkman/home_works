import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputData {


    public static List<Person> getListFromFile() {
        List<Person> list = new ArrayList<>();
        try {
            Reader reader = new FileReader("/users/pigeon/Desktop/mongo.csv");
            BufferedReader test = new BufferedReader(reader);

            test.lines().forEach(s -> {
                String [] arr =  s.split(",", 3);
                String [] course = arr[2].replaceAll("\"", "").split(",");
                list.add(new Person(arr[0], Integer.parseInt(arr[1]), Arrays.stream(course).collect(Collectors.toList())));
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}

