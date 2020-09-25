package com.gtd.todo.controller;

import com.gtd.todo.model.User;
import com.gtd.todo.service.ToDoService;
import com.gtd.todo.service.UserService;
import com.gtd.todo.util.ToDoTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private UserController userController;
    @Mock
    private UserService userService;
    @Mock
    private ToDoService toDoService;

    private User user = ToDoTestUtil.getUser();

    @Before
    public void setup() {
        userController = new UserController(userService, toDoService);
        when(userService.getAllUsers()).thenReturn(ToDoTestUtil.getUserList());
        when(userService.getUserByUsername("test")).thenReturn(user);
        when(userService.saveOrUpdate(user)).thenReturn(user);
    }

    @Test
    public void testGetAllUsers() {
        assertEquals(userController.getAllUsers().get(0).getUsername(),
                ToDoTestUtil.getUserList().get(0).getUsername());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        assertEquals(userController.getUserByUsername("test"), ResponseEntity.ok().body(user));
        verify(userService, times(1)).getUserByUsername("test");
    }

    @Test
    public void testCreateUser() {
        assertEquals(userController.createUser(user), user);
        verify(userService, times(1)).saveOrUpdate(user);
    }

    @Test
    public void testUpdateUserById() {
        assertEquals(userController.updateUserById(user), ResponseEntity.ok().body(user));
        verify(userService, times(1)).saveOrUpdate(user);
    }

}
