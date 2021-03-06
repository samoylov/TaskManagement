package tama.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tama.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByName(String name);

}
