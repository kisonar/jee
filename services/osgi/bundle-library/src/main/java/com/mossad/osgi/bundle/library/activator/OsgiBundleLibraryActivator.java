package com.mossad.osgi.bundle.library.activator;

import com.mossad.osgi.library.ExternalLibraryFromJar;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class OsgiBundleLibraryActivator
        implements BundleActivator {

    private ExternalLibraryFromJar ext;

    @Override
    public void start(BundleContext bc) throws Exception {
        ext = new ExternalLibraryFromJar("Mossad OSGI OsgiBundleLibraryActivator started");
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        ext = null;
        System.out.println("Mossad OSGI OsgiBundleLibraryActivator stopped");
    }
}
