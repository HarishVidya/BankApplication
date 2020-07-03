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
public class GoldCustomer extends Customer {
    private String username;
    private String password;
    private int balance;
    
    
    public GoldCustomer(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    @Override
    public boolean login(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean logout() {
        return true;
    }
    
    @Override
    public boolean withdraw(int value) {
        if(value <= balance) {
            balance = balance - value;
            return true;
        }
        return false;
    }
    
    @Override
    public void deposit(int value) {
        balance = balance + value;
    }
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public int getBalance() {
        return this.balance;
    }
    
    @Override
    public boolean purchase(int value) {
        if(value >= 50 && value <= balance) {
            balance = balance - value - 10;
            return true;
        }  
        return false;
    }
}
