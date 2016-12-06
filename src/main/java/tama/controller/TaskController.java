package tama.controller;

import tama.dto.DTOUtilMapper;
import tama.entity.Task;
import tama.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/newTask", method = RequestMethod.GET)
    public String newTask(Model model) {

        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("addTask", new Task(""));
        // model.addAttribute("taskDTOs", DTOUtilMapper.tasksToTasksDTO(taskService.findAll()));
        // make use of DTOs to lighten data exchange, e.g. full object is 100kb but we need to display only Name

        return "newTask";
    }

    @RequestMapping(value = "/saveTask", method = RequestMethod.POST)
    public String saveTask(/*@RequestParam String name*/
                            @ModelAttribute Task addTask) {
        taskService.save(addTask);
        return "redirect:/newTask";
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
    public String deleteTask(@RequestParam String[] ids) {
        for (String id : ids) {
            System.out.println(id);
            taskService.delete(Integer.parseInt(id));
        }
        return "redirect:/newTask";
    }
}