import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Structure {
    private MetroLine metroLine;
    private List<MetroStation> metroStation;

    public Structure() {
    }

    public Structure(MetroLine metroLine, List<MetroStation> metroStation) {
        this.metroLine = metroLine;
        this.metroStation = metroStation;
    }


    public List<MetroLine> getMetroLine() {
        List<MetroLine> lineList = new ArrayList<>();
        try{
            String htmlString = getHtml("data/MoscowMetro.html");
            Document document = Jsoup.parse(htmlString);
            for(var lines : document.select("#metrodata > div > div.js-toggle-depend > span")) {
                String[] test = lines.toString().split(" ");
                lineList.add(new MetroLine(test[5].replaceAll("data-line=", "")
                        .replaceAll("[^A-Z0-9]",""), test[6]));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lineList;
    }

    public List<String> getMetroStationString() {
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

    public Map<String, List<MetroStation>> createMetro() {
        List<MetroLine> list = getMetroLine();
        List<String> stations = getMetroStationString();
        Map<String, List<MetroStation>> metro = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            metro.put(list.get(i).getLineName(), getMetroStationList(stations.get(i)));
        }
        return metro;
    }

    public List<MetroStation> getMetroStationList(String stations){
        List<MetroStation> result = new ArrayList<>();
        String[] stationArray = stations.split("[0-9]{1,2}\\.");
        for (int j = 0; j < stationArray.length; j++) {
            if (!stationArray[j].isEmpty()) {
                result.add(new MetroStation(j, stationArray[j].strip()));
            }
        }
        return result;
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
