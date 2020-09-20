package com.gtd.todo.util;

import com.gtd.todo.model.TaskPriority;
import com.gtd.todo.model.ToDoItem;
import com.gtd.todo.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

public class ToDoTestUtil {

    public static User getUser() {
        return new User(1, "test", "test@test.in", "password");
    }

    public static ToDoItem getToDoItem() {
        return new ToDoItem(1, TaskPriority.MEDIUM.getPriority(), "Test",
                "testDetails", new Date(), false, new Date(),getUser());
    }

    public static List<ToDoItem> getToDoList() {
        return Arrays.asList(getToDoItem());
    }

    public static List<User> getUserList() {
        return Arrays.asList(getUser());
    }

}
