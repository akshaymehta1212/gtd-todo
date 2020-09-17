package com.gtd.todo.service;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.model.User;
import com.gtd.todo.repository.ToDoItemRepository;
import com.gtd.todo.repository.UserRepository;
import com.gtd.todo.util.ToDoTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToDoServiceTest {

    private ToDoService toDoService;
    @Mock
    private ToDoItemRepository toDoItemRepository;
    @Mock
    private UserRepository userRepository;

    private ToDoItem toDoItem = ToDoTestUtil.getToDoItem();
    private User user = ToDoTestUtil.getUser();


    @Before
    public void setup() {
        toDoService = new ToDoService(toDoItemRepository, userRepository);
        when(toDoItemRepository.findByUser(user)).thenReturn(ToDoTestUtil.getToDoList());
        when(toDoItemRepository.findById(1)).thenReturn(Optional.of(toDoItem));
        when(toDoItemRepository.save(toDoItem)).thenReturn(toDoItem);
        when(toDoItemRepository.findByTaskIdAndUser(1, user)).thenReturn(ToDoTestUtil.getToDoList());
    }

    @Test
    public void testGetAllTaskByUserId() {
        assertEquals(toDoService.getAllTaskByUserId(user).get(0).getTaskName(),
                ToDoTestUtil.getToDoList().get(0).getTaskName());
        verify(toDoItemRepository, times(1)).findByUser(user);
    }

    @Test
    public void testGetToDoItemById() {
        assertEquals(toDoService.getToDoItemById(1), toDoItem);
        verify(toDoItemRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveOrUpdate() {
        assertEquals(toDoService.saveOrUpdate(toDoItem), toDoItem);
        verify(toDoItemRepository, times(1)).save(toDoItem);
    }

    @Test
    public void testGetTasksByUserIdAndToDoId() {
        assertEquals(toDoService.getTasksByUserIdAndToDoId(1, user).get(0).getTaskName(),
                ToDoTestUtil.getToDoList().get(0).getTaskName());
        verify(toDoItemRepository, times(1)).findByTaskIdAndUser(1, user);
    }
}
