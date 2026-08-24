
package com.mycompany.supermarket;


public class Cart {
    
    
 private  final int ID;
 private Customer customer;
 private Product[] product;
 private static int count=0;
 private Payment payment;
 
 
 public Cart(){    
   this.ID=++count;  
   this.customer = null;
   this.product = new Product[0]; 
   this.payment = null;
 }
 
 public Cart(int ID,Customer customer,Product [] product,Payment payment){
     this.ID=++count;
     this.customer=customer;
     this.product= product;
     this.payment=payment;
     }
 
    public int getID() {
        return ID;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product[] getProducts() {
        return product;
    }

    public void setProducts(Product[] product) {
        this.product = product;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Cart.count = count;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double calculateTotalAmount() {
    double total = 0;
    for (Product product : product) {
        total += product.offer(); 
    }
    return total;
}
    
    
    @Override
    public String toString() {
        return "Cart{" + "ID=" + ID + ", customer=" + customer + ", products=" + product + ", payment=" + payment + '}';
    }
 

}


