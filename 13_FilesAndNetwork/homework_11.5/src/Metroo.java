import java.util.ArrayList;
import java.util.List;

public class Metroo {

    public static List<Structure> createMetro(int lineCount) {
        List<Structure> metro = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            metro.add(new Structure(i));
        }
        return metro;
    }

}
