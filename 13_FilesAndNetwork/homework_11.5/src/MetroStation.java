import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MetroStation {
    private int stationNumber;
    private String stationName;

    public MetroStation(int stationNumber, String stationName) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }
    public MetroStation() {}

    public int getStationNumber() {
        return stationNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public static List<String> getMetroStationList() {
        List<String> stList = new ArrayList<>();
        try {
            String htmlString = getHtml("data/MoscowMetro.html");
            Document document = Jsoup.parse(htmlString);
            for(var stations : document.select("#metrodata > div > div > div")) {
                stList.add(stations.text());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stList;
    }


    public static String getHtml(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                builder.append(line).append("\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

}
