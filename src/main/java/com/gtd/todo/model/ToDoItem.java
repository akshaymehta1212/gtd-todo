package com.gtd.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "todoitems")
public class ToDoItem {

	private int task_id;
	
	private String taskType;
	
	private String taskName;
	
	private String taskDetails;
	
	private Date createdOn;
	
	private Boolean isDone;
	
	
	public ToDoItem() {

	}

	public ToDoItem(int task_id,String taskType, String taskName, String taskDetails, Date createdOn,Boolean isDone) {
		this.task_id = task_id;
		this.taskType = taskType;
		this.taskName = taskName;
		this.taskDetails = taskDetails;
		this.createdOn = createdOn;
		this.isDone = isDone;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	
	
	
	
	

}
