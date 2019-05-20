package com.mossad.osgi.budle.service;

import com.mossad.osgi.bundle.library.BundleLibraryObject;
import com.mossad.osgi.library.ExternalLibraryFromJar;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class OsgiBundleServiceActivator implements BundleActivator {

    private BundleLibraryObject object;
    private ExternalLibraryFromJar lib;


    @Override
    public void start(BundleContext context) throws Exception {

        System.out.println("###");
        System.out.println("Mossad OSGI OsgiBUndleServiceActivator activation started");

        object = new BundleLibraryObject("Roko");
        lib = new ExternalLibraryFromJar("lib");
        lib.setName("mama");
        //context.registerService(UserAuthServiceImpl.class.getName(), new UserAuthServiceImpl(), null);

        System.out.println("Mossad OSGI OsgiBUndleServiceActivator activation finished");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("###");

        lib = null;
        object = null;
        System.out.println("Mossad OSGI OsgiBUndleServiceActivator stopped");
    }

}
