/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.osgi.bundle.library;

/**
 *
 * @author mmigdal
 */
public class BundleLibraryObject {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BundleLibraryObject(String name) {
        this.name = name;
    }
    
    private String name;
    
    
    
    
}
