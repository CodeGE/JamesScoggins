package MyClasses;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



public class Contacts {
    //HashMap : Name key, Set (name
    HashMap<String, Person> contacts;
    
    public Contacts() {
        this.contacts = new HashMap<String, Person>();
    }
    
    // QUESTION : What needs to be added and how?
    
    public void add(Person person) {
        contacts.put(person.getName(), person);
    }
    
    public void delete(String person) {
        this.contacts.remove(person);
    }
    
    // Return a specific Person object in this.contacts
    public Person getPerson(String person) {
        return this.contacts.get(person);
    }
    
    public HashMap<String, Person> getAllPersons() {
        return this.contacts;
    }
    
    public void getSearchInfo(String whose) {
        // Store entire contents of search info return string
        String str = "";
        String addresses = "";
        String phoneNumbers = "";
        
        // Individual Person object to be accessed. Not neccessary but cleaner.
        Person p = this.contacts.get(whose);
        
        // HashSet to store all personal info passed from Person p methods.
//        HashMap<String, ArrayList<String>> personalInfo = new HashMap<String, ArrayList<String>>();
        
        
        if (p.getPhone().size() > 0) {
            for (String phoneNumber : p.getPhone()) {
                phoneNumbers += "   " + phoneNumber + "\n";
            }       
        } else {
            phoneNumbers += "phone number not found";
        }

        if (p.getAddress().size() > 0) {
            addresses += ": ";
            for (String address : p.getAddress()) {
                addresses += address + " ";
            }
        } else {
            addresses += "unknown";
        }
                
        
        // make Variable for contacts.get(whose)!!!
        str += "  address " + addresses + "\n" +
                "  phone numbers: \n" + phoneNumbers;
        
        System.out.println(str);
    }
    
    public String toString() {
        String str = "";
        
        // TODO : Work on This. Test and get it where it needs to be.
        for (Map.Entry<String, Person> entry : contacts.entrySet()) {
            str += entry.getKey() + " " + entry.getValue().getName();
        }
        
        return str;
    }
}
