package com.gtd.todo.service;

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
public class UserServiceTest {

    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setup() {
        userService = new UserService(userRepository);
        when(userRepository.findAll()).thenReturn(ToDoTestUtil.getUserList());
        when(userRepository.findById(1)).thenReturn(Optional.of(ToDoTestUtil.getUser()));
        when(userRepository.save(ToDoTestUtil.getUser())).thenReturn(ToDoTestUtil.getUser());
    }

    @Test
    public void testGetAllUsers() {
        assertEquals(userService.getAllUsers(), ToDoTestUtil.getUserList());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserById() {
        assertEquals(userService.getUserById(1), ToDoTestUtil.getUser());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveOrUpdate() {
        assertEquals(userService.saveOrUpdate(ToDoTestUtil.getUser()), ToDoTestUtil.getUser());
        verify(userRepository, times(1)).save(ToDoTestUtil.getUser());
    }

}
