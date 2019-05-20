package com.mossad.irp.interfaces.task.helper;

import com.mossad.jpa.lib.domain.task.TaskPriority;
import com.mossad.jpa.lib.domain.task.TaskStatus;
import com.mossad.jpa.lib.domain.task.TaskType;
import java.util.List;

public interface IServiceTaskHelper {

    List<TaskType> getTaskTypes();

    List<TaskStatus> getTaskStatuses();

    List<TaskPriority> getTaskPriorities();

}
