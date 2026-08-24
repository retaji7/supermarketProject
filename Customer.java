
package com.mycompany.supermarket;


public class Customer {
    private String name;
    private String phoneNum;
    private Location location;
public Customer(String name,String phoneNum,Location location) {

        setName(name);
        setPhoneNum(phoneNum);
        setLocation(location);
    }
    public Customer(){
         this("", "", null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", phoneNum=" + phoneNum + ", location=" + location + '}';
    }
    
    
    
}
