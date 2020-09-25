package com.gtd.todo.controller;

import com.gtd.todo.model.User;
import com.gtd.todo.service.ToDoService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gtd.todo.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
@Data
public class UserController {

    private final UserService userService;
    private final ToDoService toDoService;

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok().body(user);
    }
    
    @GetMapping("signUp/{username}/check")
    public ResponseEntity<Map<String, String>> isUsernameExists(@PathVariable(value = "username") String username) {
    	boolean isUsernameAvilable = !userService.isUsernameExists(username);
    	Map<String, String> returnMap = new HashMap<String, String>();
    	returnMap.put("isUsernameAvailable", String.valueOf(isUsernameAvilable));
    	return ResponseEntity.ok().body(returnMap);
    }

    @PostMapping("signUp")
    public User createUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @PutMapping("updateUser")
    public ResponseEntity<User> updateUserById(@RequestBody User userDetails) {
        return ResponseEntity.ok().body(userService.saveOrUpdate(userDetails));
    }

}
