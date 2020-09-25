package com.gtd.todo.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskPriorityConverter implements AttributeConverter<TaskPriority, String> {

    @Override
    public String convertToDatabaseColumn(TaskPriority taskPriority) {
        if(taskPriority == null)
            return null;
        return taskPriority.getPriority();
    }

    @Override
    public TaskPriority convertToEntityAttribute(String taskPriority) {
        if(taskPriority == null) {
            return null;
        }
        return Stream.of(TaskPriority.values())
                .filter(priority -> priority.getPriority().equals(taskPriority))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
