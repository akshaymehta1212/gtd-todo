package com.gtd.todo.model;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskPriority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private String priority;

    TaskPriority(String priority) {
        this.priority = priority;
    }

    @JsonValue
    public String getPriority() {
        return priority;
    }
    
    @JsonCreator
    public static TaskPriority decode(final String taskPriority) {
    	return Stream.of(TaskPriority.values())
                .filter(priority -> priority.getPriority().equals(taskPriority))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return getPriority();
    }
}
