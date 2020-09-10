package com.gtd.todo.service;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.repository.ToDoItemRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ToDoService {
	
	private final ToDoItemRepository toDoItemRepository;
	
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
