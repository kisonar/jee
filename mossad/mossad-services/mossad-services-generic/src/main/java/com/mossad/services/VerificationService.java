/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services;

import com.mossad.irp.interfaces.IVerificationInterfaceLocal;
import com.mossad.irp.interfaces.IVerificationInterfaceRemote;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author mmigdal
 */
@Stateless
@Remote(IVerificationInterfaceRemote.class)
@Local(IVerificationInterfaceLocal.class)
public class VerificationService implements IVerificationInterfaceRemote, IVerificationInterfaceLocal {

    @Override
    public void verify() {
        throw new UnsupportedOperationException(
            "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
