import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Structure {

    public Structure() {
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

    public static void main(String[] args) {
//        String website = "https://www.moscowmap.ru";
//        String qq = getHtml("data/MoscowMetro.html");
//        Document test = Jsoup.parse(qq);
//        Document tTest = null;
//        for(var q : test.select("#metrodata > div > div > p > a")) {
//            //System.out.println(q.select("div > div.js-toggle-depend > span"));
//            System.out.println(website + q.attr("href"));
//            try{
//                tTest = Jsoup.connect(website + q.attr("href")).get();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            for(var aa : tTest.select("body > div.b-global-wrapper.s-overlay-disable > div.b-vd-content > div.t-content-2column > div.t-content-2column-main > div:nth-child(5) > div > div")) {
//                System.out.println(aa);
//            }
//        }

        File lineDir = new File("data/lines");

        for(File htmlFile : lineDir.listFiles()) {
            System.out.println(htmlFile.getName());
            if (!htmlFile.isHidden()) {
                Document doc = Jsoup.parse(getHtml("data/lines/" + htmlFile.getName()));
                for(var qq : doc.select("body > div.b-global-wrapper.s-overlay-disable > div.b-vd-content > " +
                        "div.t-content-2column > div.t-content-2column-main > div:nth-child(5) > " +
                        "div > div > p > a")){
                    String[] toCorrect = qq.text().split("\\.");
                    int index = Integer.parseInt(toCorrect[0].strip());
                    String [] test = (index + "" + qq.select("span.t-icon-metroln")).split("<span ");
                    String result = "";
                    for (String s : test) {
                        result += s;
                    }
                    System.out.println(result.replaceAll("\n", "")
                            .replaceAll("class=\"t-icon-metroln", "")
                            .replaceAll("\"></span>", ""));
                }
            }
        }
    }
}
