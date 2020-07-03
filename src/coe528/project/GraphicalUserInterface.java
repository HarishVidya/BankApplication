/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author veeha
 */
public class GraphicalUserInterface extends Application {
    
    //String username;
    //String password;
    int balanceInt, depos, withdr, purch;
    
    Stage window;
    Scene scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9;
    //scene3 = manager, scene5 = create
    //scene4 = customer
    //scene6 = deposit
    //scene7 = withdraw
    //scene8 = purchase
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        Manager m1 = new Manager();
        
        primaryStage.setTitle("Bank Application");
        
        Button managerLogin = new Button("Manager Login");
        Button customerLogin = new Button("Customer Login");
        
        HBox first = new HBox(10);
        first.getChildren().addAll(managerLogin, customerLogin);
        Scene scene = new Scene(first, 500, 500);   
        
        Label username = new Label("Username:");
        Label password = new Label("Password:");
                
        managerLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            //Manager m1 = new Manager();            
            window.setScene(scene2);
            }
        });
        
        customerLogin.setOnAction(e -> window.setScene(scene2));
        
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(username, 0, 0);

        GridPane.setConstraints(nameInput, 1, 0);

        GridPane.setConstraints(password, 0, 1);

        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);
        
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        Button back = new Button("Back");
        GridPane.setConstraints(back, 1, 3);
        back.setOnAction(e -> window.setScene(scene));
          
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
            String username = nameInput.getText();
            String password = passInput.getText(); 
            if(username.equals("admin") && password.equals("admin")) {
                window.setScene(scene3);
            }
            else if(m1.verification(username, password)) {
                window.setScene(scene4);
                }
            
            }
        });       
                

        grid2.getChildren().addAll(username, nameInput, password, passInput, loginButton, back);
        scene2 = new Scene(grid2, 500, 500);     

        Button add = new Button("Create New Customer");
        Button delete = new Button("Delete Customer");
        VBox manager = new VBox(30);
        manager.getChildren().addAll(add, delete);
        scene3 = new Scene(manager, 500, 500);
        
        add.setOnAction(e -> window.setScene(scene5));
        
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(8);
        grid3.setHgap(10);
        
        TextField createName = new TextField();
        createName.setPromptText("Set Username");
        GridPane.setConstraints(username, 0, 0);

        GridPane.setConstraints(createName, 1, 0);

        GridPane.setConstraints(password, 0, 1);

        TextField createPass = new TextField();
        createPass.setPromptText("Set Password");
        GridPane.setConstraints(createPass, 1, 1);
        
        Label bal = new Label("Balance:");
        
        GridPane.setConstraints(bal, 0, 2);
        
        TextField createBal = new TextField();
        createBal.setPromptText("Set Balance");
        GridPane.setConstraints(createBal, 1, 2);        
        
        Button create = new Button("Create");
        GridPane.setConstraints(create, 1, 3);
        
        Button home = new Button("Home");
        GridPane.setConstraints(home, 1, 4);
        home.setOnAction(e -> window.setScene(scene));
        
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = createName.getText();
                String password = createPass.getText(); 
                String balanceS = createBal.getText();
               
                try {
                    balanceInt = Integer.parseInt(balanceS.trim());
                }
                catch (NumberFormatException nfe) {
                }
                m1.addCustomer(username, password, balanceInt);
            }
        });
        
        grid3.getChildren().addAll(username, createName, password, createPass, bal, createBal, create, home);
        scene5 = new Scene(grid3, 500, 500);
        
        Button deposit = new Button("Deposit");
        deposit.setOnAction(e -> window.setScene(scene6)); 
       
        Label dep = new Label("Deposit Amount:");
        TextField depAm = new TextField();
        depAm.setPromptText("Amount");
        
        Button depConfirm = new Button("Confirm");
        depConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               String depo = depAm.getText();
               try {
                    depos = Integer.parseInt(depo.trim());
                }
                catch (NumberFormatException nfe) {
                }
               m1.deposit(depos);
            }
            });
        
        
        HBox deposit1 = new HBox(10);
        deposit1.getChildren().addAll(dep, depAm, depConfirm);
        scene6 = new Scene(deposit1, 500, 500);
      
        Button withdraw = new Button("Withdraw");
        withdraw.setOnAction(e -> window.setScene(scene7)); 
        
        Label with = new Label("Withdraw Amount:");
        TextField withAmp = new TextField();
        withAmp.setPromptText("Amount");
        
        Button withConfirm = new Button("Confirm");
        withConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               String withd = withAmp.getText();
               try {
                    withdr = Integer.parseInt(withd.trim());
                }
                catch (NumberFormatException nfe) {
                }
               m1.withdraw(withdr);
            }
            });
        
        
        HBox withdraw1 = new HBox(10);
        withdraw1.getChildren().addAll(with, withAmp, withConfirm);
        scene7 = new Scene(withdraw1, 500, 500);
     
        Button purchase = new Button("Purchase");
        purchase.setOnAction(e -> window.setScene(scene8)); 
        
        Label pur = new Label("Purchase Amount:");
        TextField purAm = new TextField();
        purAm.setPromptText("Amount");
        
        Button purConfirm = new Button("Confirm");
        purConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               String purc = purAm.getText();
               try {
                    purch = Integer.parseInt(purc.trim());
                }
                catch (NumberFormatException nfe) {
                }
               m1.purchase(purch);
            }
            });
       
        
        HBox purchase1 = new HBox(10);
        purchase1.getChildren().addAll(pur, purAm, purConfirm);
        scene8 = new Scene(purchase1, 500, 500);
      
        Button balance9;
        balance9 = new Button("Get Balance");
        balance9.setOnAction(e -> window.setScene(scene9));
        
        Label balance1 = new Label("Balance: " + m1.getBalance());
        HBox balan = new HBox(10);
        balan.getChildren().addAll(balance1);
        scene9 = new Scene(balan, 500, 500);
        
        VBox vbox = new VBox(30);
        vbox.getChildren().addAll(deposit, withdraw, purchase, balance9);
        scene4 = new Scene(vbox, 500, 500);        
        
        primaryStage.setScene(scene);
        primaryStage.show();
            
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
