/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.accsessor.task;

import com.mossad.jpa.lib.accsessor.AbstractAccessor;
import com.mossad.jpa.lib.domain.task.Task;
import com.mossad.jpa.lib.factories.TaskFactory;
import com.mossad.jpa.lib.irp.IServiceTask;
import com.mossad.lib.domain.task.TaskAttributes;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mmigdal
 */
public class TaskAccessor extends AbstractAccessor implements IServiceTask {

    private final TaskFactory taskFactory;

    public TaskAccessor(EntityManager em) {

        super(em);
        taskFactory = new TaskFactory();
    }

    @Override
    public Task createTask(TaskAttributes taskAttributes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Task updateTask(Long taskId, TaskAttributes taskAttributes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTask(Long taskId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Task getTask(Long taskId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> getTasks(Long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> getTasks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
