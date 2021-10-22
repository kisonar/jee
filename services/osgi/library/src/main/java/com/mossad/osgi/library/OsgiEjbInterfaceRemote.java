/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.osgi.library;

import jakarta.ejb.Remote;

import javax.annotation.security.PermitAll;

/**
 * @author mmigdal
 */
@PermitAll
@Remote
public interface OsgiEjbInterfaceRemote {

    @PermitAll
    String doTheNeedful(String input);
}
