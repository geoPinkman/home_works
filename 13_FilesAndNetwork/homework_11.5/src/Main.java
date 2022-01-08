import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            String htmlString = getHtml("data/MoscowMetro.html");
            Document document = Jsoup.parse(htmlString);
            System.out.println(document.title());
            Elements stations = document.select("body > div.b-global-wrapper.s-metro-scheme > div.b-vd-metro-wrapper > div.b-vd-metro > div.b-metro-stations-by-lines.t-metro-section.js-metro-section");
            Elements test = document.select("#metrodata");
            for (Element qq : test) {
                System.out.println(qq.toString());
            }
//            for(Element el : elements) {
//                if (!el.select("#metrodata > div > div.js-depend.s-depend-active > div").text().isBlank()) {
//                    System.out.println(el.select("#metrodata > div > div.js-depend.s-depend-active > div").text());
//                }
//            }
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
