import com.skillbox.airport.Airport;

// HOME WORK DONE
public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        for (int i = 0; i < airport.getAllAircrafts().size(); i++)
            System.out.println(airport.getAllAircrafts().get(i));
        System.out.println("Aircraft count: " + airport.getAllAircrafts().size());
        

    }
}
