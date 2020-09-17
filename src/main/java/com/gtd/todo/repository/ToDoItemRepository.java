package com.gtd.todo.repository;

import com.gtd.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtd.todo.model.ToDoItem;

import java.util.List;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Integer> {

    List<ToDoItem> findByUser(User userId);
    List<ToDoItem> findByTaskIdAndUser(int taskId,User userId);

}
