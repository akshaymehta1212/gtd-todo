package com.gtd.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.model.User;
import com.gtd.todo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(items -> users.add(items));
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

}
