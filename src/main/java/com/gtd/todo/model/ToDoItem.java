package com.gtd.todo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todoitems")
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    @Convert(converter = TaskPriorityConverter.class)
    private TaskPriority priority;
    private String taskName;
    private String taskDetails;
    private Date createdOn;
    private Boolean isDone;
    private Date lastUpdated;
    private String username;


}
