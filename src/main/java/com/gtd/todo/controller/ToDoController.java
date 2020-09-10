package com.gtd.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.service.ToDoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ToDoController {
	
	@Autowired
	ToDoService toDoService;
	
	@GetMapping("/toDoItems")
	public List<ToDoItem> getAllTasks(){
		return toDoService.getAllToDos();
	}
	
	@GetMapping("/toDoItems/{toDoId}")
	public ResponseEntity<ToDoItem> getTaskById(@PathVariable(value="toDoId") int taskId){
		ToDoItem toDoItem = toDoService.getToDoItemById(taskId);
		return ResponseEntity.ok().body(toDoItem);
	}
	
	@PostMapping("/toDoItems")
	public void createToDo(@RequestBody ToDoItem toDoItem){
		 toDoService.save(toDoItem);
	}
	
	@PutMapping("/toDoItems/{toDoId}")
	public ResponseEntity<ToDoItem> updateTaskById(@PathVariable(value="toDoId") int taskId,
			@RequestBody ToDoItem toDoItemDetails){
		ToDoItem toDoItem = toDoService.getToDoItemById(taskId);
		
		toDoItem.setTaskType(toDoItemDetails.getTaskType());
		toDoItem.setTaskDetails(toDoItemDetails.getTaskDetails());
		toDoItem.setCreatedOn(toDoItemDetails.getCreatedOn());
		
		final ToDoItem newToDoItem = toDoService.save(toDoItem);
		return ResponseEntity.ok().body(newToDoItem);
		
	}
	
	@DeleteMapping("toDoItems/{toDoId}")
	public Map<String,Boolean> deleteTask(@PathVariable(value="toDoId") int taskId){
		ToDoItem toDoItem = toDoService.getToDoItemById(taskId);
		
		toDoService.delete(taskId);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
	
	

}
