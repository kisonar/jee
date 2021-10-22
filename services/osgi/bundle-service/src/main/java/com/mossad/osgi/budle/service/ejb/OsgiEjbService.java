/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.osgi.budle.service.ejb;

import com.mossad.osgi.library.OsgiEjbInterfaceRemote;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

/**
 * @author mmigdal
 */

@PermitAll
@Stateless
@Remote(OsgiEjbInterfaceRemote.class)
public class OsgiEjbService implements OsgiEjbInterfaceRemote {

    @PermitAll
    @Override
    public String doTheNeedful(String input) {
        return ("OsgiEjbService done the needful: " + input);
    }
}