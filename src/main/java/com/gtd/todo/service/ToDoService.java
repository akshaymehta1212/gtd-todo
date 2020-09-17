package com.gtd.todo.service;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.model.User;
import com.gtd.todo.repository.ToDoItemRepository;
import com.gtd.todo.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ToDoService {

    private final ToDoItemRepository toDoItemRepository;
	private final UserRepository userRepository;

    public List<ToDoItem> getAllTaskByUserId(User userId) {
        return toDoItemRepository.findByUser(userId);
    }

    public ToDoItem getToDoItemById(int id) {
        return toDoItemRepository.findById(id).get();
    }

    public ToDoItem saveOrUpdate(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public void delete(int id) {
        toDoItemRepository.deleteById(id);
    }

    public List<ToDoItem> getTasksByUserIdAndToDoId(int taskid, User userid) {
        return toDoItemRepository.findByTaskIdAndUser(taskid, userid);
    }

}
