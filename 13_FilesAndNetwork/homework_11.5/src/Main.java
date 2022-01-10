import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MetroLineList lineList = new MetroLineList();
        List<String> stationsList = new ArrayList<>();
        try {
            String htmlString = getHtml("data/MoscowMetro.html");
            Document document = Jsoup.parse(htmlString);
            System.out.println(document.title());
            for(var lines : document.select("#metrodata > div > div.js-toggle-depend > span")) {
                String[] test = lines.toString().split(" ");
                lineList.addData(new MetroLine(test[5].replaceAll("[^0-9]", ""), test[6]));
            }
            for(var stations : document.select("#metrodata > div > div > div")){
                stationsList.add(stations.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<MetroLine> test = lineList.getList();
        for (int i = 0; i < test.size(); i++) {
            System.out.println("Линия: " + test.get(i).getLineNumber() + " - "
                    + test.get(i).getLineName() + " линия, Станции: " + stationsList.get(i));
        }
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
