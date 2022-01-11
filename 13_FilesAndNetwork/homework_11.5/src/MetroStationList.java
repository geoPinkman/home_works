import java.util.ArrayList;
import java.util.List;

public class MetroStationList {
    private List<MetroStation> list;

    public MetroStationList() {
        list = new ArrayList<>();
    }

    public void addData(MetroStation metroStation) {
        list.add(metroStation);
    }

    public List<MetroStation> getList() {
        return list;
    }
}
