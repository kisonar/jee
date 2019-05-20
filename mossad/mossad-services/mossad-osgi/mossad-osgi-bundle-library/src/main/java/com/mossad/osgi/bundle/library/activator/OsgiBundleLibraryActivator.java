package com.mossad.osgi.bundle.library.activator;

import com.mossad.osgi.library.ExternalLibraryFromJar;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class OsgiBundleLibraryActivator
    implements BundleActivator {


    private ExternalLibraryFromJar ext;

    @Override
    public void start(BundleContext bc) throws Exception {

        System.out.println("### ####");

        ext = new ExternalLibraryFromJar("test zewnetrznej biblioteki z mossad-osgi-library");

        System.out.println("Mossad OSGI OsgiBundleLibraryActivator started");
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        System.out.println("### ####");
        ext = null;
        System.out.println("Mossad OSGI OsgiBundleLibraryActivator stopped");
    }

}
