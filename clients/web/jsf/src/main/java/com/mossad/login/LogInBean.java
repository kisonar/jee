package com.mossad.login;

import org.glassfish.jersey.process.internal.RequestScoped;

import java.io.Serializable;

@RequestScoped
public class LogInBean implements Serializable {

    private String userName;
    private String password;
    private boolean loggedIn;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean b) {
        if (!b) {
            password = null;
            userName = null;

        }
        loggedIn = b;
    }
}
