/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.servicelocator;

import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperRemote;
import com.mossad.jpa.lib.irp.IServiceTask;
import com.mossad.jpa.lib.irp.IServiceUser;
import com.mossad.lib.domain.constants.Constants;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author mmigdal
 */
public class ServiceLocator implements IServiceLocator {

    private static final Logger log = Logger.getLogger(Constants.SERVICE_LOCATOR);
    InitialContext ctx;

    public ServiceLocator() {

        try {
            ctx = new InitialContext();


        } catch (Exception e) {
            log.log(Level.FINEST, "Error during initialization of Service Locator: {0}", e.getMessage());
        }


    }

    public ServiceLocator(Properties props) {
        try {
            ctx = new InitialContext(props);
        } catch (Exception e) {
            log.log(Level.FINEST, "Error during initialization of Service Locator: {0}", e.getMessage());
        }
    }

    @Override
    public IServiceTask getServiceTask() throws NamingException {

        IServiceTask serviceTask =
            (IServiceTask) ctx.lookup(Constants.BINDING_SERVICE_TASK);
        return serviceTask;


    }

    @Override
    public IServiceUser getServiceUser() throws NamingException {

        IServiceUser serviceUser =
            (IServiceUser) ctx.lookup(Constants.BINDING_SERVICE_USER);

        return serviceUser;
    }

    @Override
    public IServiceTaskHelperRemote getServiceTaskHelper() throws NamingException {

        IServiceTaskHelperRemote serviceTaskHelper = (IServiceTaskHelperRemote) ctx
            .lookup(Constants.BINDING_SERVICE_HELPER);
        return serviceTaskHelper;

    }

    public Object getService(String serviceName) throws NamingException {

        return ctx.lookup(serviceName);


    }


}
