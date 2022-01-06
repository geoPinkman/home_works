import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final long TWO_HOURS = 7200L;
    public static void main(String[] args) {
        List<Flight> test = findPlanesLeavingInTheNextTwoHours(Airport.getInstance());
        System.out.println((long) test.size());
        test.forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
      return airport.getTerminals().stream()
              .map(Terminal::getFlights)
              .flatMap(Collection::stream)
              .filter(flight -> flight.getType() == Flight.Type.DEPARTURE &&
                        flight.getDate().toInstant().isAfter(Instant.now()) &&
                        flight.getDate().toInstant().isBefore(Instant.now().plusSeconds(TWO_HOURS)))
              .collect(Collectors.toList());
    }
}