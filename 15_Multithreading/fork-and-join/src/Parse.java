import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;

public class Parse {
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.1 Safari/605.1.15";

    private final Map<String, List<String>> siteMap;
    private final String url;

    public Parse(String url) {
        this.siteMap = getResult();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    //    public static Map<String, List<String>> gettingMap(String url) {
//
//        Map<String, List<String>> struct = new Hashtable<>();
//        try {
//            Document doc = Jsoup.connect(url).userAgent(userAgent).get();
//            Elements elements = doc.select("a");
//            for (Element el : elements) {
//                if (el.attr("href").charAt(0) == '/') {
//                    List<String> hrefs = new ArrayList<>();
//                    String keyString = el.attr("href");
//                    if (keyString.length() > 1) {
//                        struct.put(keyString, hrefs);
//                        Document doc2 = Jsoup.connect(url + keyString).userAgent(userAgent).get();
//                        Elements elements2 = doc2.select("a");
//                        for (Element el2 : elements2) {
//                            try {
//                                if (el2.attr("href").charAt(0) == '/') {
//                                    String valueString = el2.attr("href");
//                                    if (!valueString.equals(keyString) & valueString.length() > 1) {
//                                        hrefs.add(valueString);
//                                    }
//                                }
//                            } catch (StringIndexOutOfBoundsException ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return struct;
//    }
//
//    public void print() {
//        Map<String, List<String>> struct = new Hashtable<>(getSiteMap());
//
//        for(Map.Entry<String, List<String>> qq : struct.entrySet()) {
//            String key = qq.getKey();
//            List<String> value = qq.getValue();
//            System.out.println(key);
//            for(String qqa : value) {
//                System.out.println("\t" + qqa);
//            }
//        }
//    }

    private Document getPage(String path) {
        Document doc = null;
        try {
            doc = Jsoup.connect(path).userAgent(USER_AGENT).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public List<String> getHref(String path){
        List<String> list = new ArrayList<>();
        try {
            for (Element element : getPage(path).select("a")) {
                String href = element.attr("href");
                if (href.length() > 1 & href.charAt(0) == '/') {
                    String result = path.concat(href);
                    if (result.charAt(result.length() - 1) == '/'){
                        list.add(result.substring(0, result.length() - 1));
                    } else {
                        list.add(result);
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return list;
    }

    public Map<String, List<String>> getResult() {
        List<String> list = getHref(getUrl());
        Map<String, List<String>> result = new Hashtable<>();
        for (String newHref : list) {
            if (newHref != null) {
                result.put(newHref, getHref(newHref));
            }
        }
        return result;
    }

    public void print() {
        for (Map.Entry<String, List<String>> qq : siteMap.entrySet()) {
            System.out.println(qq.getKey());
            qq.getValue().forEach(s -> System.out.println("\t" + s));
        }
    }


}
