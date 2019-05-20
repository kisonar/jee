/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mossad.access.xml;

/**
 * @author Administrator
 */
public class Element {

    private String name;
    private String type;

    public Element() {
    }
    /*
    public Element(String name , String type){
       this.name = name;
       this.type = type;
    }
    */

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


}
