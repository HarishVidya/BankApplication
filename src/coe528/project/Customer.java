/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Harish
 */
public abstract class Customer {
    
    abstract public boolean login(String username, String password);
    
    abstract public boolean logout();
    
    abstract public boolean withdraw(int value);
    
    abstract public void deposit(int value);
    
    abstract public String getUsername();
    
    abstract public String getPassword();
    
    abstract public int getBalance();
    
    abstract public boolean purchase(int value);
    
}
