/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import MyClasses.Contacts;
import MyClasses.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class UserInterface implements Interface{
    private Contacts contacts;
    private Scanner reader;
    
    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.contacts = new Contacts();
    }
    
    public void printOptions() {      
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println("\n");
    }
    
    public void inputCommand() {
        String number;
        String whose;
        String address;
        String street;
        String city;
        

        
        while (true) {
            System.out.print("command: ");
            String command = this.reader.nextLine();
            
            if ("x".equals(command.toLowerCase())) {
                break;
            } else if ("1".equals(command)) {
                addNumber();
            } else if ("2".equals(command)) {
                searchNumber();
            } else if ("3".equals(command)) {
                searchPerson();
            } else if ("4".equals(command)) {
                addAddress();
            } else if ("5".equals(command)) {
                searchInfo();
            } else if ("6".equals(command)) {
                deleteInfo();
            } else if ("7".equals(command)) {
                filteredListing();
            }
        }
        

    }
    
    public void addNumber() {
        System.out.print("whose number: ");
        String whose = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();
        System.out.println("");
        
        // Add new Person and their phone number to Contacts object;1       
        if (this.contacts.getPerson(whose) == null) {
             this.contacts.add(new Person(whose)); 
        }

        this.contacts.getPerson(whose).addNumber(number);

    }
    
    public void searchNumber() {
        System.out.print("whose number: ");
        String whose = this.reader.nextLine();
        
        Person person = this.contacts.getPerson(whose);
        
        if (person != null) {
            for (String num : person.getPhone()) {
                System.out.println(" " + num);
            }
        } else {
            System.out.println("  not found");
        }
        
        System.out.println("");

    }
    
    public void searchPerson() {
        System.out.print("number: ");
        String number = this.reader.nextLine();
        String name = "";
        
        for (Map.Entry<String, Person> p : this.contacts.getAllPersons().entrySet()) {
            if (p.getValue().getPhone().contains(number)) {
                name = " " + p.getValue().getName();
            }
        }
        
        if (name.length() == 0) {
            name = " not found";
        }
        
        System.out.println(name);
        System.out.println("");
    }
    
    public void addAddress() {
        System.out.print("whose address: ");
        String whose = this.reader.nextLine();
        System.out.print("street: ");
        String street = this.reader.nextLine();
        System.out.print("city: ");    
        String city = this.reader.nextLine(); 
        
        Person person = this.contacts.getPerson(whose);
        
        // Works when object exists, but not when null
        if (person == null) {
            this.contacts.add(new Person(whose));
        }
        
        this.contacts.getPerson(whose).addAddress(street, city);
        
        System.out.println("");
    }
  
    public void searchInfo() {
        System.out.print("whose information: ");    
        String whose = this.reader.nextLine();
        
        Person person = this.contacts.getPerson(whose);
        
        if (person != null) {
            this.contacts.getSearchInfo(whose);     
        } else {
            System.out.println("  not found");
        }
    }
    
    public void deleteInfo() {
        System.out.print("whose information: ");
        String whose = this.reader.nextLine();  
        
        this.contacts.delete(whose);
        System.out.println("");
    }
    
    public void filteredListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();
        
        //ALPHABETIZE LIST OF NAMES;
        List<String> keys = new ArrayList<String>(this.contacts.getAllPersons().keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        
        if (keyword.length() == 0) {
            for (String p : keys) {
                System.out.println(" " + p);
                this.contacts.getSearchInfo(p);
            }
        } else {
            boolean keywordFound = false;
            
            for (String p : keys) {
                Person person = this.contacts.getPerson(p);
                
                if (person.getAddress().toString().contains(keyword) || person.getName().contains(keyword)) {
                    keywordFound = true;
                    System.out.println(" " + p);
                    this.contacts.getSearchInfo(p);
                }
            }
            
//            for (Map.Entry<String, Person> p : this.contacts.getAllPersons().entrySet()) {
//                if (p.getValue().getAddress().toString().contains(keyword) || p.getValue().getName().contains(keyword)) {
//                    keywordFound = true;
//                    System.out.println(" " + p.getKey());
//                    this.contacts.getSearchInfo(p.getKey());
//                } 
//            }
            
            if (!keywordFound) {
                System.out.println(" keyword not found");       
                System.out.println("");
            }
        }
    }
    
    
    public void start() {
        printOptions();
        inputCommand();
    }
}
