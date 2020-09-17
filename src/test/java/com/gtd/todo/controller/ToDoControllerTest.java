package com.gtd.todo.controller;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.service.ToDoService;
import com.gtd.todo.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToDoControllerTest {

    private ToDoController toDoController;

    @Mock
    private ToDoService toDoService;
    @Mock
    private UserService userService;
    @Mock
    private ToDoItem toDoItem;

    @Before
    public void setup() {
       // toDoController = new ToDoController(toDoService, userService);
       // when(toDoService.getAllToDos()).thenReturn(getAllToDo());
        when(toDoService.getToDoItemById(1)).thenReturn(toDoItem);
       // when(toDoService.save(toDoItem)).thenReturn(toDoItem);
    }

    /*@Test
    public void testGetAllTask() {
        assertEquals(toDoController.getAllTasks(), getAllToDo());
    }*/

    /*@Test
    public void testGetTaskById() {
        assertEquals(toDoController.getTaskById(1), ResponseEntity.ok().body(toDoItem));
    }*/

    /*@Test
    public void testCreateToDo() {
        toDoController.createToDo(toDoItem);
        verify(toDoService, times(1)).save(toDoItem);
    }*/

   /* @Test
    public void testUpdateTaskById() {
        assertEquals(toDoController.updateTaskById(1, toDoItem), ResponseEntity.ok().body(toDoItem));
        verify(toDoService, times(1)).save(toDoItem);
    }*/

    @Ignore
    @Test
    public void testDeleteTask() {
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        //assertEquals(toDoController.deleteTask(1), response);
    }

    private List<ToDoItem> getAllToDo() {
        List<ToDoItem> taskList = new ArrayList<>();
        taskList.add(toDoItem);
        return taskList;
    }


}
