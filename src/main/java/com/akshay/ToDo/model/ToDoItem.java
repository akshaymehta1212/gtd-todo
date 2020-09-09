package com.akshay.ToDo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="todoitems")
public class ToDoItem {
	
	
	private int task_id;
	
	private String taskType;
	
	private String taskDetails;
	
	private Date createdOn;
	
	
	public ToDoItem() {}
	
	
	/*public ToDoItem(String taskType, String taskDetails,Date createdOn ) {
		//this.task_id
		this.taskType = taskType;
		this.taskDetails = taskDetails;
		this.createdOn = createdOn;
	}*/
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	
	@Column(name="taskType",nullable = false)
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	
	@Column(name="taskDetails",nullable = false)
	public String getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	@Column(name="createdOn",nullable = false)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	
	
	

}
