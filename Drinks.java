
package com.mycompany.supermarket;



 public  class Drinks extends Product {
    private double price;
    private int Number_of_cans;

    public Drinks(double price, int Number_of_cans, int id, String name, String descripoint) {
        super(id, name, descripoint);
        this.price = price;
        this.Number_of_cans = Number_of_cans;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber_of_cans() {
        return Number_of_cans;
    }

    public void setNumber_of_cans(int Number_of_cans) {
        this.Number_of_cans = Number_of_cans;
    }
    
     
        @Override
            public  final double offer() {
         double totalPrice=price * Number_of_cans;
                if (Number_of_cans== 2) {
            double discount = totalPrice * 0.10; 
            totalPrice -= discount;
            System.out.println("10% discount applied for " + Number_of_cans);
            System.out.println("Total price after discount: " + totalPrice  );
        } else {
            System.out.println("No offer for " + Number_of_cans );

        }
        return totalPrice;        
                
 }    

    @Override
    public String toString() {
        return super.toString()+"Drinks{" + "price=" + price + ", Number_of_cans=" + Number_of_cans + '}';
    }

    
}
