import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MetroLine extends Metro {
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

}
