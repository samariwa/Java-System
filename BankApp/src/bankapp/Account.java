/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author lihas
 */
public class Account {

   
     private double balance;
    
    public Account(){
        balance=0;
    }
    
    public void deposit(double amount){
     balance= balance + amount;   
    }
    
    public void withdraw(double amount){
        if(amount<=balance){
            balance = balance-amount;
        }
        else{
            System.out.println("Transaction cancelled due to insufficient funds");
        }
        
    }
    
    public double getBalance(){
        return balance;
    }
     @Override
    public String toString(){
        return "Balance:" + balance;
    }
}