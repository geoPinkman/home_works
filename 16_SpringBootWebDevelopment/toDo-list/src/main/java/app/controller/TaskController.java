package app.controller;

import app.model.Task;
import app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TaskController {

    private final TodoService todoService;

    @Autowired
    public TaskController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping("/tasks/")
    public ResponseEntity<?> create(@RequestBody Task task) {
        todoService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/tasks/")
    public ResponseEntity<List<Task>> readAll() {
        Iterable<Task> tasks = todoService.readAll();
        List<Task> result = new ArrayList<>();
        tasks.forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> read(@PathVariable(name = "id") int id) {
        final Task task = todoService.read(id);
        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable(name = "id") int id) {
        final boolean updated = todoService.update(task, id);
        return updated
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = todoService.delete(id);
        return deleted
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }


}
