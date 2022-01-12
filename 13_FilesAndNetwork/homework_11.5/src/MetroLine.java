import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MetroLine {
    private String lineNumber;
    private String lineName;

    public MetroLine(String lineNumber, String lineName) {
        this.lineNumber = lineNumber;
        this.lineName = lineName;
    }
    public MetroLine() {}

    public String getLineNumber() {
        return lineNumber;
    }

    public String getLineName() {
        return lineName;
    }


    public static List<MetroLine> getLineList() {
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
