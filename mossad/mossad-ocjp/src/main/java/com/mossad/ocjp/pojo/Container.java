/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.ocjp.pojo;

/**
 * @author mmigdal
 */
public class Container {

    private String name;
    private int value;

    public Container(String name, int value) {
        this.name = name;
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseValue() {
        ++this.value;
    }


}
