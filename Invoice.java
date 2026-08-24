
package com.mycompany.supermarket;


public   class Invoice  implements Offer {
    
    private Cart cart;

    
    public Invoice(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
        public   void printinvoice(){
           
    System.out.println("===== Supermarket Invoice =====");
    System.out.println("Order ID: " + cart.getID());
    System.out.println("Customer Name: " + cart.getCustomer().getName());

    double amount = cart.calculateTotalAmount();
    boolean paymentSuccess = cart.getPayment().processPayment(amount);
    System.out.println("Order payment: " + (paymentSuccess ? "Payment successful" : "Payment failed"));

    System.out.println("Products:");
    
    for (Product product : cart.getProducts()) {
        double productPrice = product.offer();
        System.out.println("- " + product.getName() + " | Price: " + productPrice);
    }

    System.out.println("================================");
    System.out.println("Total amount: " + amount);
        }
        
    @Override
public double offer() {
    double total = 0.0;
    
    for (Product product : cart.getProducts()) {
        total += product.offer(); 
    }

    double discount = 0.0;
    double discountRate = 0.5;

    
    if (total >= OFFERLIM) {
        discount = total * discountRate;
    }

    return total - discount;
}
}

        
        