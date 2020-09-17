package com.gtd.todo.controller;

import com.gtd.todo.model.User;
import com.gtd.todo.service.ToDoService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gtd.todo.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Data
public class UserController {

    private final UserService userService;
    private final ToDoService toDoService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") int userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUserById(@RequestBody User userDetails) {
        return ResponseEntity.ok().body(userService.saveOrUpdate(userDetails));
    }

}
