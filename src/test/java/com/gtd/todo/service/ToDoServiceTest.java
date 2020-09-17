package com.gtd.todo.service;

import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.repository.ToDoItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
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
    private ToDoItem toDoItem;

    @Before
    public void setup() {
       // toDoService = new ToDoService(toDoItemRepository);
        when(toDoItemRepository.findAll()).thenReturn(getListOfToDoItems());
        when(toDoItemRepository.findById(1)).thenReturn(Optional.of(toDoItem));
        when(toDoItemRepository.save(toDoItem)).thenReturn(toDoItem);
    }

    /*@Test
    public void testGetAllToDos() {
        assertEquals(toDoService.getAllToDos().get(0), toDoItem);
    }*/

    @Test
    public void testGetToDoItemById() {
        assertEquals(toDoService.getToDoItemById(1), toDoItem);
    }

    /*@Test
    public void testSave() {
        assertEquals(toDoService.save(toDoItem), toDoItem);
    }*/

    @Test
    public void testDelete() {
        toDoService.delete(1);
        verify(toDoItemRepository, times(1)).deleteById(1);
    }

    /*@Test
    public void testUpdate() {
        toDoService.update(toDoItem, 1l);
        verify(toDoItemRepository, times(1)).save(toDoItem);
    }*/

    private List<ToDoItem> getListOfToDoItems() {
        List<ToDoItem> list = new ArrayList<>();
        list.add(toDoItem);
        return list;
    }
}
