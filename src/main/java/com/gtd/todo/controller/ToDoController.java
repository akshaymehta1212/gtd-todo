package com.gtd.todo.controller;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.service.ToDoService;
import com.gtd.todo.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
@Data
public class ToDoController {

    private final ToDoService toDoService;
    private final UserService userService;

    @GetMapping("{username}/todos")
    public List<ToDoItem> getAllTasksById(@PathVariable(value = "username") String username) {
        return toDoService.getAllTaskByUsername(username);
    }

    @GetMapping("{username}/todos/{toDoId}")
    public List<ToDoItem> getAllTasks(@PathVariable(value = "toDoId") int toDoId,
                                      @PathVariable(value = "username") String username) {
        return toDoService.getTasksByUsernameAndToDoId(toDoId, username);
    }

    @PostMapping("{username}/createToDo")
    public ToDoItem createToDo(@PathVariable(value = "username") String username, 
    							@RequestBody ToDoItem toDoItem) {
		toDoItem.setUsername(username);
        return toDoService.saveOrUpdate(toDoItem);
    }

    @PutMapping("{username}/updateToDo")
    public ToDoItem updateToDo(@PathVariable(value = "username") String username,
                               @RequestBody ToDoItem toDoItem) {
    	toDoItem.setUsername(username);
        return toDoService.saveOrUpdate(toDoItem);
    }

}
