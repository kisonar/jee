/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.domain.task;

import com.mossad.jpa.lib.domain.abstraction.AbstractEntity;

/**
 * @author mmigdal
 */
public class TaskRepetition extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public TaskRepetition(Long id, String value) {
        super(id, value);
    }
}
