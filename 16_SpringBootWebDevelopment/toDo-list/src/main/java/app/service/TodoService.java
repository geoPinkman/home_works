package app.service;

import app.model.Task;

public interface TodoService {

    void create(Task task);

    Iterable<Task> readAll();

    Task read(int id);

    boolean update(Task task, int id);

    boolean delete(int id);

}
