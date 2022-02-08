import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class DirTree extends RecursiveAction {

    File file;

    public DirTree(File file) {
        this.file = file;
    }

    @Override
    protected void compute() {
        System.out.print("\t");
        for (File file : file.listFiles()) {
            System.out.println(file.getPath());
        }

        List<DirTree> tasksList = new ArrayList<>();
        for (File direct : file.listFiles()) {
            DirTree dirTree = new DirTree(direct);
            dirTree.fork();
            tasksList.add(dirTree);
        }

        for (DirTree tasks : tasksList) {
            tasks.join();
        }

    }
}