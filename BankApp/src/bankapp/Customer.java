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
public class Customer {

    private final String firstName;
    private final String lastName;
    private final Account account;

    Customer(String firstName, String lastName, Account account) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.account = account;
    }
    
    @Override
    public String toString(){
        return "\n Customer information \n"+
                "First name:" + firstName +
                "Last name: " + lastName + account;
        
    }

    void addCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
