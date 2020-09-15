package com.gtd.todo.controller;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.service.ToDoService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Data
public class ToDoController {
	
	private final ToDoService toDoService;
	
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
		/*ToDoItem toDoItem = toDoService.getToDoItemById(taskId);
		
		toDoItem.setTaskType(toDoItemDetails.getTaskType());
		toDoItem.setTaskDetails(toDoItemDetails.getTaskDetails());
		toDoItem.setCreatedOn(toDoItemDetails.getCreatedOn());*/
		
		final ToDoItem newToDoItem = toDoService.save(toDoItemDetails);
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
