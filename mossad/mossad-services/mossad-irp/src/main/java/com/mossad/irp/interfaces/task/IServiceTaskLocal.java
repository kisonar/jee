/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.interfaces.task;

/**
 * @author mmigdal
 */

import com.mossad.jpa.lib.domain.task.Task;
import com.mossad.lib.domain.task.TaskAttributes;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IServiceTaskLocal //extends IServiceTask 
{

    Task createTask(TaskAttributes taskAttributes);

    Task updateTask(Long taskId, TaskAttributes taskAttributes);

    void deleteTask(Long taskId);

    Task getTask(Long taskId);

    List<Task> getTasks(Long userId);

    List<Task> getTasks();

}
