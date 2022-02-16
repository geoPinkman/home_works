package app.controller;

import app.model.Task;
import app.model.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    TaskRepo repo;

    @Autowired
    public ListController(TaskRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/test")
    public String tasks(Model model) {
        Iterable<Task> iterable = repo.findAll();
        List<Task> result = new ArrayList<>();
        iterable.forEach(task -> result.add(task));
        model.addAttribute("tasks", result);
        return "test";
    }

}
