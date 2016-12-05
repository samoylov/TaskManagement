package tama.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tama.entity.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {
}
