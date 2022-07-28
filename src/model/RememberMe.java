/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author poojithairosha
 */
public class RememberMe implements Serializable {
    
    public String username;
    public String password;

    public RememberMe(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
}
