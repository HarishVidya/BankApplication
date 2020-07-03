/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
/**
 *
 * @author veeha
 */

//ABSTRACTION FUNCTION:
// AF(c) = c is a platinum member

//REP INVARIANT:
// RI(c) = true if username and password are not null and balance is higher than 20000
//         false otherwise


public class PlatinumCustomer extends Customer {
    // OVERVIEW: creates and contains all the functions of a platinum customer
    
    private String username;
    private String password;
    private int balance;
    
    
    public PlatinumCustomer(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    //REQUIRES: username and password to NOT be null
    //EFFECTS: inputs username and password must equal the customer's username and password
    @Override
    public boolean login(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
    
    //NO CLAUSES NEEDED
    @Override
    public boolean logout() {
        return true;
    }
    
    //REQUIRES: value to be less than the balance
    //EFFECTS: reduces the value of balance by the input value
    @Override
    public boolean withdraw(int value) {
        if(value <= balance) {
            balance = balance - value;
            return true;
        }
        return false;
    }
    
    //REQUIRES: a positive value for value
    //EFFECTS: balance is increased by the value of the input value
    @Override
    public void deposit(int value) {
        balance = balance + value;
    }
    
    //REQUIRES: a username
    //EFFECTS: returns username
    @Override
    public String getUsername() {
        return this.username;
    }
    
    //REQUIRES: a password
    //EFFECTS: returns password
    @Override
    public String getPassword() {
        return this.password;
    }
    
    //REQUIRES: a positive balance
    //EFFECTS: returns balance
    @Override
    public int getBalance() {
        return this.balance;
    }
    
    //REQUIRES: value to be higher than 50 and lower than balance
    //EFFECTS: decreases the value of balance by the input value
    @Override
    public boolean purchase(int value) {
        if(value >= 50 && value <= balance) {
            balance = balance - value;
            return true;
        }  
        return false;
    }
    
    //REQUIRES: username and password to NOT be null and balance to be above 20000
    //EFFECTS: returns true if username and password are NOT null and balance is above 20000 otherwise returns false
    public boolean repOk() {
        if(username == null || password == null || balance < 20000) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return ("Level: Platinum\nUsername: " + this.username + "\nPassword: " + this.password + "\nBalance: " + this.balance);
    }
}
