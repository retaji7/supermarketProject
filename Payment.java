
package com.mycompany.supermarket;


public class Payment {
 
    private double balance;

    public Payment(double balance) {
        this.balance = balance;
    }
    public Payment(){
        this(0);
    }
    public boolean processPayment(double amount){
        
        if(amount <=0){
            System.out.println("unacceptable");
        return false;}
        
        else if (balance >= amount){
            balance-= amount;
        System.out.println("remaining balance"+balance);
        return true;}
        
        else{
            System.out.println("not enough"); 
            return false;}
    }
    
    
    
    
}
