import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveAction;

public class DirTree extends RecursiveAction {
    Parse parse;

    public DirTree(Parse parse) {
        this.parse = parse;
    }

    @Override
    protected void compute() {
        parse.print();

        List<DirTree> tasksList = new ArrayList<>();
        for (Map.Entry<String, List<String>> qq : parse.getResult().entrySet()) {
            DirTree dirTree = new DirTree((Parse) qq);
            dirTree.fork();
            tasksList.add(dirTree);
        }

        for (DirTree tasks : tasksList) {
            tasks.join();
        }

    }
}