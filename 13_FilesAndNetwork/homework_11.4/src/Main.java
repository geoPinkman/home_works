import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {
    public static void main(String[] args) {

        File dir = new File("data/img/");
        dir.mkdir();
        for(Element el : getElements()) {
            System.out.println(el.attr("abs:src"));
            try {
                File file = new File(el.attr("abs:src"));
                URL url = new URL(el.absUrl("src"));
                InputStream is = url.openStream();
                Files.copy(is, Paths.get(dir.getAbsolutePath() + "/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Document getDoc(String path) {
        Document document = new Document("");
        try {
           document = Jsoup.connect(path).get();
           System.out.println(document.title());
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return document;
    }
    public static Elements getElements() {
        Elements elements = getDoc("https://google.com").select("img");
        return elements;
    }
}
