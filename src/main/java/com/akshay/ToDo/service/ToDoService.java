package com.akshay.ToDo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.ToDo.model.ToDoItem;
import com.akshay.ToDo.repository.ToDoItemRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoItemRepository toDoItemRepository;
	
	public List<ToDoItem> getAllToDos(){
		List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
		toDoItemRepository.findAll().forEach(items -> toDoItems.add(items));
		return toDoItems;
	}
	
	public ToDoItem getToDoItemById(int id){
		return toDoItemRepository.findById(id).get();
	}
	
	public ToDoItem save(ToDoItem toDoItem){
		return toDoItemRepository.save(toDoItem);
	}
	
	public void delete(int id){
		toDoItemRepository.deleteById(id);
	}
	
	public void update(ToDoItem toDoItem,Long id){
		toDoItemRepository.save(toDoItem);
	}
}
