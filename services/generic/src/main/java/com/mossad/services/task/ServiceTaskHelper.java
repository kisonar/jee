/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.task;

import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperLocal;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperRemote;
import com.mossad.jpa.lib.domain.task.TaskPriority;
import com.mossad.jpa.lib.domain.task.TaskStatus;
import com.mossad.jpa.lib.domain.task.TaskType;
import com.mossad.lib.domain.constants.Constants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author mmigdal
 */
@Stateless
@Remote(IServiceTaskHelperRemote.class)
@Local(IServiceTaskHelperLocal.class)
public class ServiceTaskHelper implements IServiceTaskHelperLocal//, IServiceTaskHelperRemote
{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<TaskType> getTaskTypes() {
        List<TaskType> taskTypes = new ArrayList<>();
        taskTypes.addAll(em.createNamedQuery(Constants.TASK_TYPE_QUERY_NAME)
            .getResultList());
        return taskTypes;

    }

    @Override
    public List<TaskStatus> getTaskStatuses() {
        List<TaskStatus> taskStatuses = new ArrayList<>();
        taskStatuses.addAll(em.createNamedQuery(
            Constants.TASK_STATUS_QUERY_NAME).getResultList());
        return taskStatuses;
    }

    @Override
    public List<TaskPriority> getTaskPriorities() {
        List<TaskPriority> taskPriorities = new ArrayList<>();
        taskPriorities.addAll(em.createNamedQuery(
            Constants.TASK_PRIORITY_QUERY_NAME).getResultList());
        return taskPriorities;
    }
}
