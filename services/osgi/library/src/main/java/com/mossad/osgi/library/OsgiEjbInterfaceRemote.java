/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.osgi.library;

import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Remote;

/**
 * @author mmigdal
 */
@PermitAll
@Remote
public interface OsgiEjbInterfaceRemote {

    @PermitAll
    String doTheNeedful(String input);
}