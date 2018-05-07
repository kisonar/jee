/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.access.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Administrator
 */
public class SAXParserExample extends DefaultHandler //implements ParsingInterface 
{

    private final Logger LOGGER = Logger.getLogger(this.getClass().getCanonicalName());

    private final List<Group> myGroups;
    private Group itemGroup;
    private Element itemElement;
    private final String filePath;
    private final static String GROUP = "group";
    private final static String ELEMENT = "element";
    private final static String NAME = "name";
    private final static String TYPE = "type";

    public SAXParserExample(String filePath) {
        this.myGroups = new ArrayList<>();
        this.filePath = filePath;
    }

    public List<Group> getGroups() {
        return myGroups;
    }

    public void parseDoc() {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            // get a new instance of parser
            SAXParser sp = spf.newSAXParser();
            File f = new File(this.filePath);
            sp.parse(f, this);
        } catch (SAXException se) {
            LOGGER.log(Level.SEVERE, String.format("SAX exception %s", se.getMessage()));
        } catch (ParserConfigurationException | IOException pce) {
            LOGGER.log(Level.SEVERE, String.format("SAX exception %s", pce.getMessage()));
        }

    }

    // Event Handlers
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equalsIgnoreCase(GROUP)) {
                itemGroup = new Group();
                itemGroup.setName(attributes.getValue(NAME));
                itemGroup.setType(attributes.getValue(TYPE));
            } else if (qName.equalsIgnoreCase(ELEMENT)) {
                itemElement = new Element();
                itemElement.setName(attributes.getValue(NAME));
                itemElement.setType(attributes.getValue(TYPE));
                System.out.println(itemElement.getName());
                System.out.println(itemElement.getType());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("SAX exception %s", e.getMessage()));
        }
    }

    //public void characters(char[] ch, int start, int length) throws SAXException {
    //	tempVal  = new String(ch, start, length);
    //}
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        try {
            if (qName.equalsIgnoreCase(GROUP)) {
                myGroups.add(itemGroup);
                itemGroup = null;
            } else if (qName.equalsIgnoreCase(ELEMENT)) {

                // System.out.println("End of tag element");
                System.out.println(itemElement.getName());
                System.out.println(itemElement.getType());;
                itemGroup.addElement(itemElement);
                itemElement = null;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("SAX exception %s", e.getMessage()));
        }

    }

}
