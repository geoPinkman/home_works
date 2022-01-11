import java.util.ArrayList;
import java.util.List;

public class MetroLine {
    private String lineNumber;
    private String lineName;

    public MetroLine(String lineNumber, String lineName) {
        this.lineNumber = lineNumber;
        this.lineName = lineName;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

}
