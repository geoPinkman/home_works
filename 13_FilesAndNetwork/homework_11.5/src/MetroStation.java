import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MetroStation extends Metro {
    private int stationNumber;
    private String stationName;

    public MetroStation(int stationNumber, String stationName) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }
    public MetroStation() {}

    public int getStationNumber() {
        return stationNumber;
    }

    public String getStationName() {
        return stationName;
    }


}
