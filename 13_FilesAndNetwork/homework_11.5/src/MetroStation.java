import java.util.ArrayList;
import java.util.List;

public class MetroStation {
    private int line;
    private int stationNumber;
    private String stationName;

    public MetroStation(int line, int stationNumber, String stationName) {
        this.line = line;
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }

    public int getLine() {
        return line;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public String getStationName() {
        return stationName;
    }
}
