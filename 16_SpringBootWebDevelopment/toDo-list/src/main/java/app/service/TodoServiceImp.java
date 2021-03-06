package app.service;

import app.model.Task;
import app.model.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TodoServiceImp implements TodoService {

    private final TaskRepo taskRepo;
    private static final AtomicInteger taskId = new AtomicInteger();

    @Autowired
    public TodoServiceImp(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public void create(Task task) {
        final int id = taskId.incrementAndGet();
        task.setId(id);
        taskRepo.save(task);
    }

    @Override
    public List<Task> readAll() {
        Iterable<Task> iterable = taskRepo.findAll();
        List<Task> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    @Override
    public Task read(int id) {
        if (taskRepo.existsById(id)) {
            return taskRepo.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Task task, int id) {
        if (taskRepo.existsById(id)) {
            task.setId(id);
            taskRepo.save(task);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
