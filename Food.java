
package com.mycompany.supermarket;



 
public class Food extends Product {
    private double unitPrice;

    public Food(double unitPrice, int id, String name, String descripoint) {
        super(id, name, descripoint);
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return super.toString()+ "food{" + "unitPrice=" + unitPrice + '}'; }
    
    
    @Override
    public  double offer(){
      double price=getUnitPrice()+getUnitPrice();
            return price; 
            
    }
    
    
}    
    
    
    
    

