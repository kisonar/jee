/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.domain.task;

import com.mossad.jpa.lib.domain.abstraction.AbstractEntity;
import com.mossad.lib.domain.constants.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * @author mmigdal
 */


@Entity(name = Constants.TASK_PRIORITY_DEF)
@Table(name = Constants.TASK_PRIORITY_DEF)
@NamedQueries({
        @NamedQuery(name = Constants.TASK_PRIORITY_QUERY_NAME, query = Constants.TASK_PRIORITY_QUERY)
})

public class TaskPriority extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public TaskPriority() {
    }

    public TaskPriority(Long id, String value) {
        super(id, value);
    }
}
