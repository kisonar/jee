/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.osgi.budle;

/**
 * @author mmigdal
 */
public interface UserAuthService {

    boolean login(String user, String password);

    boolean register(String user, String password);
}