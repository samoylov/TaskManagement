package tama.service;

import org.springframework.web.multipart.MultipartFile;
import tama.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    void save(User object) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    public void saveImage(Principal principal, MultipartFile multipartFile);


}
