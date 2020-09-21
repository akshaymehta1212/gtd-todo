package com.gtd.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.concurrent.Task;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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



    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


}
