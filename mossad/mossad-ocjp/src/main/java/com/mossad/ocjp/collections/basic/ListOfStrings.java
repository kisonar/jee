/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.ocjp.collections.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmigdal
 */
public class ListOfStrings {

    public static void main(String[] args) {

        List<String> list = new ArrayList();
        list.add("Lions and");
        list.add("tigers and");
        list.add("bears.");
        list.add("Oh My!");
        list.stream().forEach((word) -> {
            System.out.print(word + " ");
        });
        System.out.println("---------------------------------------------");

        list.stream().filter((word) -> (word.equals("bears."))).map((word) -> {
            list.remove(word);
            return word;
        }).forEach((word) -> {
            System.out.println(word + " removed");
        });
        list.stream().forEach((word) -> {
            System.out.print(word + " ");
        });
        System.out.println();
    }

}
