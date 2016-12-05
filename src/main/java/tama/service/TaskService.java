package tama.service;

import tama.entity.Task;

import java.util.List;

public interface TaskService {

    void save(Task object);

    List<Task> findAll();

    Task findOne(int id);

    void delete(int id);

}
