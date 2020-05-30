package com.mckesson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mckesson.dto.TaskDTO;
import com.mckesson.service.TaskService;

@RestController
public class TodoController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/test")
    public String getTest() {
        return "================> Service is UP...... <===============";
    }
    
    // CREATE
    @PostMapping(path = "/todos", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String addTask(@RequestBody TaskDTO taskDTO) {
    	taskService.save(taskDTO.getTaskSummary(), taskDTO.getTaskDescription(),"testuser", "testpwd");
        return "Task added succesfully";
    }

    // READ
    @GetMapping(path = "/todos/{todoId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TaskDTO getTask(@PathVariable(value = "todoId") Long todoId) {
        return taskService.findById(todoId);
    }
    
    // READ
    @GetMapping(path = "/todos", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<TaskDTO> getAllTasks() {
        return taskService.findAll();
    }
    
    // UPDATE
    @PutMapping(path = "/todos/{todoId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TaskDTO updateTask(@PathVariable(value = "todoId") Long todoId, @RequestBody TaskDTO taskDTO) { 
        taskDTO.setId(todoId);
        return taskService.save(taskDTO);
    }

    // DELETE
    @DeleteMapping(path = "/todos/{todoId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String deleteTask(@PathVariable(value = "todoId") Long todoId) {
        if (todoId != null) {
        	taskService.deleteById(todoId);
        }
        return "Task deleted succesfully";
    }


}
