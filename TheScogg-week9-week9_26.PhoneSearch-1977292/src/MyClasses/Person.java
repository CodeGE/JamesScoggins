package MyClasses;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Person implements Comparable<Person> {
    private String name;
    
    // Street, City
    private ArrayList<String> address;
    private ArrayList<String> phone;
    
    public Person(String name) {
        this.name = name;
        this.address = new ArrayList<String>();
        this.phone = new ArrayList<String>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<String> getPhone() {
        return this.phone;
    }
    
    public ArrayList<String> getAddress() {
        return this.address;
    }
    
    public void addNumber(String number) {
        this.phone.add(number);
    }
    
    public void addAddress(String street, String city) {
//        String addressString = street + " " + city;
        
        // ArrayList : Pass street & city as two fields in ArrayList
        this.address.add(street);
        this.address.add(city);
    }
    
    public void addPhone(String phone) {
        this.phone.add(phone);
    }

    @Override
    public int compareTo(Person o) {
        if (this.name != null && o.name !=null) {
            return this.name.compareTo(o.name);
        } else {
            return 0;
        }
    }
}
