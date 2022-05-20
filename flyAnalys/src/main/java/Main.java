import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("tickets.json");

        ObjectMapper mapper = new ObjectMapper();
        List<Double> fullTime = new ArrayList<>();
        Map<Ticket, Double> ninetyPercentEachTime = new HashMap<>();
        mapper.readValue(file, Tickets.class).getTickets().forEach(line -> {
            if (line.getOrigin().equals("VVO") & line.getDestination().equals("TLV")) {
                String departureString = line.getDepartureDate() + " " + line.getDepartureTime();
                String arrivalString = line.getArrivalDate() + " " + line.getArrivalTime();
                try {
                    Date depData = new SimpleDateFormat("dd.MM.yy HH:mm").parse(departureString);
                    Date arrData = new SimpleDateFormat("dd.MM.yy HH:mm").parse(arrivalString);
                    double time = (arrData.getTime() - depData.getTime()) / (1000 * 60 * 60 * 1.0);
                    fullTime.add(time);
                    ninetyPercentEachTime.put(line, time * 0.9);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        double sumAllTimes = 0;
        for(double time : fullTime) {
            sumAllTimes += time;
        }
        ninetyPercentEachTime.forEach((l,p) -> System.out.println(l.getOrigin() + " - " + l.getDestination() + " 90% полета это " + p + " часов"));
        System.out.println(sumAllTimes / fullTime.size() + " часов в среднем за все полеты");
    }

}
