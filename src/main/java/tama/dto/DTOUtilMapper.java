package tama.dto;

import tama.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DTOUtilMapper {

//    public static List<TaskDTO> tasksToTasksDTO(List<Task> tasks) {
//        List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
//
//        for (Task task : tasks)
//            taskDTOs.add(new TaskDTO(task.getId(), task.getName()));
//
//        return taskDTOs;
//    }

    public static List<UserDTO> usersToUsersDTO(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        for (User user : users)
            userDTOs.add(new UserDTO(user.getId(), user.getName(), user.getPhone(), user.getEmail()));

        return userDTOs;
    }

}
