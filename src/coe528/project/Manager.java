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
import java.io.*;
import java.util.*;


public class Manager {
 
    private String username;
    private int bal;
    private String level;
    private String balance;
    private String pass;
    private Customer current;
    private String newBal;
    private int balNewInt;                          
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    private int getBalance =11000;
    
    public boolean managerLogin(String username, String password) {
        if(username == "admin" && password == "admin") {                                                                                                                                                                                                                                                                                 
            return true;
        }
        else {
            return false;
        }
    }
    
    
    public boolean verification(String username, String password) {
        
        try {
        Scanner scanner = new Scanner(new File(username +".txt"));
      
        String pass = scanner.nextLine();
        String balance = scanner.nextLine();
        String level = scanner.nextLine(); 
        
        scanner.close();
        
        this.pass = pass;
        this.balance = balance;
        this.level = level; 
        this.username = username;
        
        //scanner.close();
                  
        }
        catch (Exception e) {
            System.out.println("No user");
                }
        try {
        this.bal = Integer.parseInt(balance.trim());
        }
        catch (NumberFormatException nfe) {
            
        }
        if(this.pass.equals(password)) {
           Customer temp;
           
           if(bal < 10000) {
               current = new SilverCustomer(username, password, this.bal);
               
           }
           else if(bal >= 10000 && bal < 20000) {
               current = new GoldCustomer(username, password, this.bal);
               
           }
           else if(bal >= 20000) {
               current = new PlatinumCustomer(username, password, this.bal);
               
           }
           
           return true;           
       }
              
       else {
            System.out.println("Wrong Password!");
           return false;
       }
       
        
         
    }
        
    public void addCustomer(String username, String password, int balance) {
        
        try {
            
            File file = new File(username +".txt");   
            
            if(!file.exists()) {
                file.createNewFile();
            }          
            
            PrintWriter pw = new PrintWriter(file);
            //pw.println(username);
            pw.println(password);
            pw.println(balance);
            
            if(balance < 10000) {
                pw.println("Silver");
            }
            else if(balance >= 10000 && balance < 20000) {
                pw.println("Gold");
            }
            else if(balance > 20000) {
                pw.println("Platinum");
            }
            pw.close();
            
                                
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
     
        
    }
    
    public void deleteCustomer(String username) {
        
        File file = new File(username +".txt");
        
        if(file.exists()) {
            if(file.delete()) {
            }
        }
    }
    
    public void deposit(int value) {
        current.deposit(value);
        update();
    }
    
    public boolean withdraw(int value) {
        if(current.withdraw(value)) {
            update();
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getBalance(){
        return getBalance;
    }

    
    public boolean purchase(int value) {
        if(current.purchase(value)) {
            update();
            return true;
        }
        else {
            return false;
        }
    }
    
    public void logout() {
        update();
        current = null;
    }
    
    public void update(){
        File file = new File(this.username +".txt");
        
        if(file.exists()) {
            if(file.delete()) {
            }
        }
        
        try {
        
        PrintWriter pw = new PrintWriter(file);
            //pw.println(username);
            pw.println(this.pass);
            pw.println(current.getBalance());
            
            if(current.getBalance() < 10000) {
                pw.println("Silver");
            }
            else if(current.getBalance() >= 10000 && current.getBalance() < 20000) {
                pw.println("Gold");
            }
            else if(current.getBalance() > 20000) {
                pw.println("Platinum");
            }
            pw.close();
        }
        
        catch (Exception e) {
                               
    }
    
    
}
}   
