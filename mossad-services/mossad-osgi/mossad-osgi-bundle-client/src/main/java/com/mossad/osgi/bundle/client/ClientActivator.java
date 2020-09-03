package com.mossad.osgi.bundle.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ClientActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("### Mossad OSGI service client started");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("### Mossad OSGI service client stopped");
    }

}
