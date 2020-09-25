package com.gtd.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtd.todo.model.ToDoItem;

import java.util.List;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Integer> {

    List<ToDoItem> findByUsername(String username);
    List<ToDoItem> findByTaskIdAndUsername(int taskId, String username);

}
