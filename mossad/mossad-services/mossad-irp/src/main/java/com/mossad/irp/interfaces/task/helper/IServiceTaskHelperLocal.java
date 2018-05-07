/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.interfaces.task.helper;

/**
 *
 * @author mmigdal
 */
import com.mossad.jpa.lib.domain.task.TaskPriority;
import com.mossad.jpa.lib.domain.task.TaskStatus;
import com.mossad.jpa.lib.domain.task.TaskType;
import javax.ejb.Local;
import java.util.List;

@Local
public interface IServiceTaskHelperLocal //extends IServiceTaskHelper 

{
    List<TaskType> getTaskTypes();

    List<TaskStatus> getTaskStatuses();

    List<TaskPriority> getTaskPriorities();
    

}