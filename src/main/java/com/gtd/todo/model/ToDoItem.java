package com.gtd.todo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "todoitems")
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int task_id;
    private String taskType;
    private String taskName;
    private String taskDetails;
    private Date createdOn;
    private Boolean isDone;

}
