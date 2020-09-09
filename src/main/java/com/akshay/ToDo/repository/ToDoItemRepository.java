package com.akshay.ToDo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshay.ToDo.model.ToDoItem;

@Repository
public interface ToDoItemRepository extends CrudRepository<ToDoItem,Integer >{

}
