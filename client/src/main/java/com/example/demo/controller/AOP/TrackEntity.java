/**
 * Provide necessary to create log the amount of time for method to execute
 * 
 * version 1.1
 */
package com.example.demo.controller.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * It is used to log the amount of time for method to execute
 * 
 * @author GAYATHIRI
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackEntity {


}
