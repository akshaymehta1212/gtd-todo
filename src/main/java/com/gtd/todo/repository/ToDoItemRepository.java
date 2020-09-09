package com.gtd.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gtd.todo.model.ToDoItem;

@Repository
public interface ToDoItemRepository extends CrudRepository<ToDoItem,Integer >{

}
