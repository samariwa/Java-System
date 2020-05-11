/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.Scanner;

/**
 *
 * @author lihas
 */
public class Menu {

    private double intialDeposit;
    String firstName,lastName;
    Account account;
    private void createAnAccount() {
        
        
        System.out.print("Please enter your first name: ");
        firstName = keyboard.nextLine();
        System.out.print("Please enter your last name: ");
        lastName = keyboard.nextLine();
        System.out.println("Please enter an initial deposit: "); 
        
        try{
           intialDeposit = Double.parseDouble(keyboard.nextLine()); 
        }
        catch(NumberFormatException e){
            System.out.println("Deposit must be a number");  
        }
        Account account = new Account();
        Customer customer = new Customer(firstName, lastName, account);
        bank.addCustomer(customer);
    }

    private void MakeADeposit() {
        Account account;
        
        System.out.println("How much would you like to deposit?");
        
    }

    private void MakeAWithdrawal() {
        account.withdraw(520);
    }

    private void ListBalance() {
        account.getBalance();
    }

    private void printMenu() {
        System.out.println("Please make a selection");
        System.out.println("1)Create a new account");
        System.out.println("2)Make a deposit");
        System.out.println("3)Make a withdrawal");
        System.out.println("4)List account balance");
    }

    private int getInput() {
      int choice= -1;
      do{
          System.out.println("Enter your choice");
      try{
       choice= Integer.parseInt(keyboard.nextLine());
      }
      catch(NumberFormatException e){
        System.out.println("Invalid selection. Numbers only please");  
      }
      if (choice <0 || choice> 4){
          System.out.println("Choice out of range. Plese choose again");
      }
      }while (choice <0 || choice> 4);
      return choice;
    }

    private void performAction(int choice) {
        switch(choice){
            case 0:
                System.out.println("Thank you for using our application");
                System.exit(0);
                break;
            case 1:
                createAnAccount();
                break;
            case 2:
                MakeADeposit();
                break;
            case 3:
                MakeAWithdrawal();
                break;
            case 4:
                ListBalance();
                break;
            default:
                System.out.println("Unknown error has occured");                
        }
    }
    Scanner keyboard = new Scanner(System.in);
    
    boolean exit; 
    
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        menu.runMenu();
        
        
       
    }
        
        public void runMenu(){
        printHeader();    
        while(!exit){
        printMenu();
        int choice= getInput();
        performAction(choice);
        }
       
    }

    private void printHeader() {
        System.out.println("................................");
        System.out.println("|           Bank App            |");
        System.out.println("................................");
        
    }
       
    
}
