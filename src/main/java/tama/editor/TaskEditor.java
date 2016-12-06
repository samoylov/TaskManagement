package tama.editor;

import tama.service.TaskService;

import java.beans.PropertyEditorSupport;

public class TaskEditor extends PropertyEditorSupport{

    private final TaskService taskService;

    public TaskEditor(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(taskService.findOne(Integer.parseInt(text)));
    }

}
