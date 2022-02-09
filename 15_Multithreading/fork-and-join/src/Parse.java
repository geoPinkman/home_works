import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Parse {
    private Map<String, List<String>> siteMap;

    public Parse(String url) {
        this.siteMap = gettingMap(url);
    }

    public Map<String, List<String>> getSiteMap() {
        return siteMap;
    }

    public static Map<String, List<String>> gettingMap(String url) {
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.1 Safari/605.1.15";
        Map<String, List<String>> struct = new Hashtable<>();
        try {
            Document doc = Jsoup.connect(url).userAgent(userAgent).get();
            Elements elements = doc.select("a");
            for (Element el : elements) {
                if (el.attr("href").charAt(0) == '/') {
                    List<String> hrefs = new ArrayList<>();
                    String keyString = el.attr("href");
                    if (keyString.length() > 1) {
                        struct.put(keyString, hrefs);
                        Document doc2 = Jsoup.connect(url + keyString).userAgent(userAgent).get();
                        Elements elements2 = doc2.select("a");
                        for (Element el2 : elements2) {
                            try {
                                if (el2.attr("href").charAt(0) == '/') {
                                    String valueString = el2.attr("href");
                                    if (!valueString.equals(keyString) & valueString.length() > 1) {
                                        hrefs.add(valueString);
                                    }
                                }
                            } catch (StringIndexOutOfBoundsException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return struct;
    }

    public void print() {
        Map<String, List<String>> struct = new Hashtable<>(getSiteMap());

        for(Map.Entry<String, List<String>> qq : struct.entrySet()) {
            String key = qq.getKey();
            List<String> value = qq.getValue();
            System.out.println(key);
            for(String qqa : value) {
                System.out.println("\t" + qqa);
            }
        }
    }

}
