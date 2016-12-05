package tama.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tama.dao.TaskDao;
import tama.entity.Task;
import tama.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    public void save(Task object) {
        taskDao.save(object);
    }

    public List<Task> findAll() {
        return taskDao.findAll();
    }

    public Task findOne(int id) {
        return taskDao.findOne(id);
    }

    public void delete(int id) {
        taskDao.delete(id);
    }

}
