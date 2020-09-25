package com.gtd.todo.controller;

import com.gtd.todo.model.TaskPriority;
import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.model.User;
import com.gtd.todo.service.ToDoService;
import com.gtd.todo.service.UserService;
import com.gtd.todo.util.ToDoTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

    private User user = ToDoTestUtil.getUser();
    private ToDoItem toDoItem = ToDoTestUtil.getToDoItem();

    @Before
    public void setup() {
        for(TaskPriority task: TaskPriority.values()) {
            System.out.println(task + task.getPriority());
        }
        toDoController = new ToDoController(toDoService, userService);
        when(toDoService.getAllTaskByUserId(user)).thenReturn(ToDoTestUtil.getToDoList());
        when(toDoService.getTasksByUserIdAndToDoId(1, user)).thenReturn(ToDoTestUtil.getToDoList());
        when(userService.getUserByUsername("test")).thenReturn(user);
        when(toDoService.saveOrUpdate(toDoItem)).thenReturn(toDoItem);
    }

    @Test
    public void testGetAllTaskById() {
        assertEquals(toDoController.getAllTasksById(user).get(0).getTaskName(),
                ToDoTestUtil.getToDoList().get(0).getTaskName());
        verify(toDoService, times(1)).getAllTaskByUserId(user);
    }

    @Test
    public void testGetAllTasks() {
        assertEquals(toDoController.getAllTasks(1, user).get(0).getTaskName(),
                ToDoTestUtil.getToDoList().get(0).getTaskName());
        verify(toDoService, times(1)).getTasksByUserIdAndToDoId(1, user);
    }

    @Test
    public void testCreateToDo() {
        assertEquals(toDoController.createToDo("test", toDoItem), toDoItem);
        verify(userService, times(1)).getUserByUsername("test");
        verify(toDoService, times(1)).saveOrUpdate(toDoItem);
    }

    @Test
    public void testUpdateToDo() {
        assertEquals(toDoController.updateToDo("test", toDoItem), toDoItem);
        verify(userService, times(1)).getUserByUsername("test");
        verify(toDoService, times(1)).saveOrUpdate(toDoItem);
    }

}
