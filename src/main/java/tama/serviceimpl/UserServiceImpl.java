package tama.serviceimpl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tama.dao.UserDao;
import tama.entity.User;
import tama.entity.UserRole;
import tama.service.UserService;
import tama.validation.Validator;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    public void save(User user) throws Exception {

        validator.validate(user);

        user.setRole(UserRole.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));

        userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }


    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.findByName(name);
    }

    @Transactional
    public void saveImage(Principal principal, MultipartFile multipartFile) {

        User user = userDao.findOne(Integer.parseInt(principal.getName()));

        String path = System.getProperty("catalina.home") + "/resources/"
                + user.getName() + "/" + multipartFile.getOriginalFilename();

        user.setPhotoPath("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

        File file = new File(path);

        try {
            file.mkdirs();
            try {
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            multipartFile.transferTo(file);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        userDao.save(user);
    }

}
