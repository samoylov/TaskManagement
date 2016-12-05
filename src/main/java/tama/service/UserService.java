package tama.service;

import tama.entity.User;

import java.util.List;

public interface UserService {

    void save(User object);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

}
