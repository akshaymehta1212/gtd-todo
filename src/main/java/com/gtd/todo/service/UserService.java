package com.gtd.todo.service;

import com.gtd.todo.model.User;
import com.gtd.todo.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

}
