import java.util.ArrayList;
import java.util.List;

public class Structure {
    private MetroLine metroLine;
    private List<MetroStation> metroStation;

    public Structure(int count) {
        this.metroLine = MetroLine.getLineList().get(count);
        this.metroStation = test(count);
    }

    public List<MetroStation> test(int i) {
        List<MetroStation> testList = new ArrayList<>();
        String s = MetroStation.getMetroStationList().get(i);
            String[] qq = s.split("[0-9]{1,2}\\.");
            for (int j = 0; j < qq.length; j++) {
                if (!qq[j].isEmpty()) {
                    int stationNumber = j;
                    testList.add(new MetroStation(stationNumber, qq[j].strip()));
                }
            }
        return testList;
    }
    public static void main(String[] args) {
        Structure test = new Structure(0);


    }
}
