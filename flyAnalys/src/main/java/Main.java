import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static final long CONVERT_TIME = 3600_000;

    public static double getPercentile(List<Double> list, int percentile){
        List<Double> res = list.stream().sorted(Double::compareTo).collect(Collectors.toList());
        double someNumber = percentile * res.size() / 100.0;
        int index = (int) someNumber;
        if (someNumber - (double) index >= 0.5) {
            index = index + 1;
        }
            return res.get(index - 1);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("tickets.json");

        ObjectMapper mapper = new ObjectMapper();
        List<Double> fullTime = new ArrayList<>();
        mapper.readValue(file, Tickets.class).getTickets().forEach(line -> {
            if ((line.getOrigin().equals("VVO") & line.getDestination().equals("TLV")) |
                    line.getOrigin().equals("TLV") & line.getDestination().equals("VVO")) {
                String departureString = line.getDepartureDate() + " " + line.getDepartureTime();
                String arrivalString = line.getArrivalDate() + " " + line.getArrivalTime();
                try {
                    Date depData = new SimpleDateFormat("dd.MM.yy HH:mm").parse(departureString);
                    Date arrData = new SimpleDateFormat("dd.MM.yy HH:mm").parse(arrivalString);
                    double time = (arrData.getTime() - depData.getTime()) / (CONVERT_TIME * 1.0);
                    fullTime.add(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        double sumAllTimes = 0;
        for(double time : fullTime) {
            sumAllTimes += time;
        }
        System.out.print("Среднее время в пути ");
        System.out.printf("%.2f" , sumAllTimes / fullTime.size());
        System.out.println();
        //fullTime.stream().sorted(Double::compareTo).forEach(System.out::println);
        System.out.println("90 - й процентиль : " + getPercentile(fullTime, 90));
    }

}
