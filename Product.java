
package com.mycompany.supermarket;


public abstract  class Product  implements Offer{
    private  int id;
    private String name;
    private  String descripoint;
    private static int count;
    public Product() {
        this(0,null,null);
                
    }

    public Product(int id, String name, String descripoint) {
        this.id = id;
        this.name = name;
        this.descripoint = descripoint;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripoint() {
        return descripoint;
    }

    public void setDescripoint(String descripoint) {
        this.descripoint = descripoint;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    @Override
    public String toString() {
        return "product{" + "id=" + id + ", name=" + name + ", descripoint=" + descripoint + '}';
    }
    
    
}
