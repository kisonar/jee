/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.servicelocator;

import com.mossad.jpa.lib.irp.IServiceTask;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperRemote;
import com.mossad.jpa.lib.irp.IServiceUser;
import javax.naming.NamingException;

/**
 *
 * @author mmigdal
 */
public interface IServiceLocator {
    
    IServiceTask getServiceTask() throws NamingException;
    
    IServiceUser getServiceUser() throws NamingException ;
    
    IServiceTaskHelperRemote getServiceTaskHelper() throws NamingException ;
    
}
