import java.util.ArrayList;
import java.util.List;

public class MetroLineList {
    private List<MetroLine> list;

    public MetroLineList() {
        this.list = new ArrayList<>();
    }
    public void addData(MetroLine metroLine) {
        list.add(metroLine);
    }

    public List<MetroLine> getList() {
        return list;
    }

    public void setList(List<MetroLine> list) {
        this.list = list;
    }
}
