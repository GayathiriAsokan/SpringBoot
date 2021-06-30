/**
 *  Provide necessary for storing the username and password from the client
 *
 * Version 1.0
 */
package com.example.demo.Model;

import java.io.Serializable;

/**
 *  For storing the username and password from the client 
 * 
 * @author GAYATHIRI
 */
public class AuthenticationRequest implements Serializable {


    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

}
