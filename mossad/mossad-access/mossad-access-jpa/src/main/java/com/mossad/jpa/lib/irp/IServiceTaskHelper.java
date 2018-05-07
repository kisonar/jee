/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.irp;

import com.mossad.jpa.lib.domain.task.TaskPriority;
import com.mossad.jpa.lib.domain.task.TaskStatus;
import com.mossad.jpa.lib.domain.task.TaskType;
import java.util.List;

/**
 *
 * @author mmigdal
 */
public interface IServiceTaskHelper {

    List<TaskType> getTaskTypes();

    List<TaskStatus> getTaskStatuses();

    List<TaskPriority> getTaskPriorities();
}
