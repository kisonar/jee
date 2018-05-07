/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.factories;

import com.mossad.jpa.lib.domain.task.TaskPriority;
import com.mossad.jpa.lib.domain.task.TaskStatus;
import com.mossad.jpa.lib.domain.task.TaskType;

/**
 *
 * @author mmigdal
 */
public class TaskRelatedFactory {

    private TaskType taskType;
    private TaskStatus taskStatus;
    
    private TaskPriority taskPriority;
    
    public TaskRelatedFactory() {
    }
    
    

    public TaskType createTaskType(String value) {

        taskType = new TaskType();
        taskType.setValue(value);
        return taskType;

    }

    
    public TaskStatus createTaskStatus(String value) {

        taskStatus = new TaskStatus();
        taskStatus.setValue(value);
        return taskStatus;

    }
     
    public TaskPriority createTaskPriority(String value){
        taskPriority = new TaskPriority();
        taskPriority.setValue(value);
        return taskPriority;
    
    }
 
}
