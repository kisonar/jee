/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.access.xml;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\

        String path = Main.class.getResource("xmlFileTest.xml").getFile();

        SAXParserExample sp = new SAXParserExample(path);
        sp.parseDoc();
        List<Group> grs = sp.getGroups();
        System.out.println(grs.size());

        for (int i = 0; i < grs.size(); i++) {
            Group g = grs.get(i);
            System.out.println("Group name: " + g.getName());
            System.out.println("Group type: " + g.getType());

            List<Element> elems = g.getElements();
            for (int j = 0; j < elems.size(); j++) {
                Element e = elems.get(j);
                System.out.println("Element name: " + e.getName());
                System.out.println("Element type: " + e.getType());
            }
        }
    }
}
