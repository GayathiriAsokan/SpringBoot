/**
 * Provide necessary to create a class to get response too user
 *
 * Version 1.0
 */
package com.example.demo.Model;

import java.io.Serializable;

/**
 * For creating a response containing the JWT to be returned to the user.
 * 
 * @author GAYATHIRI
 *
 */
public class AuthenticationResponse implements Serializable {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}