/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.access.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public final class Group extends Element {

    private List<Element> elements;

    public Group() {
        elements = new ArrayList<>();
    }

    /**
     * @return the elements
     */
    public List<Element> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public void addElement(Element item) {
        elements.add(item);
    }

}
