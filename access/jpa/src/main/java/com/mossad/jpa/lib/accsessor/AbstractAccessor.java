/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.accsessor;


import jakarta.persistence.EntityManager;

/**
 * @author mmigdal
 */
public abstract class AbstractAccessor {

    protected EntityManager em;

    public AbstractAccessor(EntityManager em) {
        this.em = em;
    }

}
