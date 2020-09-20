package com.gtd.todo.model;

public enum TaskPriority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private String priority;

    TaskPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
