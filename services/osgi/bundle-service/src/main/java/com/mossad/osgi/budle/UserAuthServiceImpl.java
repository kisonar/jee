/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.osgi.budle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mmigdal
 */
public class UserAuthServiceImpl implements UserAuthService {

    Map<String, String> users = new HashMap();

    @Override
    public boolean login(String user, String password) {
        if (users.containsKey(user) && users.containsValue(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(String user, String password) {
        if (users.containsKey(user) || users.containsValue(password)) {
            return false;
        } else {
            users.put(user, password);
            return true;
        }
    }
}