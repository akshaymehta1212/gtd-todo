package com.gtd.todo.controller;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.model.User;
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
@RequestMapping("/api")
@Data
public class ToDoController {

    private final ToDoService toDoService;
    private final UserService userService;

    @GetMapping("/users/{userId}/toDoItems")
    public List<ToDoItem> getAllTasksById(@PathVariable(value = "userId") User userId) {
        return toDoService.getAllTaskByUserId(userId);
    }

    @GetMapping("/users/{userId}/toDoItems/{toDoId}")
    public List<ToDoItem> getAllTasks(@PathVariable(value = "toDoId") int toDoId,
                                      @PathVariable(value = "userId") User userId) {
        return toDoService.getTasksByUserIdAndToDoId(toDoId, userId);
    }

    @PostMapping("/users/{userId}/createToDo")
    public ToDoItem createToDo(@PathVariable(value = "userId") int userId, @RequestBody ToDoItem toDoItem) {
		toDoItem.setUser(userService.getUserById(userId));
        return toDoService.saveOrUpdate(toDoItem);
    }

    @PutMapping("users/{userId}/updateToDo")
    public ToDoItem updateToDo(@PathVariable(value = "userId") int userId,
                               @RequestBody ToDoItem toDoItemRequest) {
        toDoItemRequest.setUser(userService.getUserById(userId));
        return toDoService.saveOrUpdate(toDoItemRequest);
    }

}
