import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MetroLineList list = new MetroLineList();
        try {
            String htmlString = getHtml("data/MoscowMetro.html");
            Document document = Jsoup.parse(htmlString);
            System.out.println(document.title());
            for(var qq : document.select("#metrodata > div > div.js-toggle-depend > span")) {
                String qqString = qq.toString();
                String[] test = qqString.split(" ");
                list.addData(new MetroLine(test[5].replaceAll("[^0-9]", ""), test[6]));
                //String [] test = qqString.split(" ");
                //System.out.println(qq.select("div.js-metro-stations").text());
                //System.out.println(qq.select("div > div.js-depend > div"));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
