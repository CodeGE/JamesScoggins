import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.get(plate) == null) {
            this.owners.put(plate, owner);
            return true;
        }
        
        return false;
    }
    
    public String get(RegistrationPlate plate) {
        return this.owners.get(plate);
    }

    // public boolean delete(RegistrationPlate plate), which delete the information connected 
    // to the parameter registration plate. The method returns true if the information was deleted, 
    // and false if there was no information connetted to the parameter in the register.
    
    public boolean delete(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            this.owners.remove(plate);
            return true;
        }
        
        return false;
    }
    
    // prints all registration plates
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : this.owners.keySet()) {
            System.out.println(plate.toString());
        }
    }
    
    // print all owners, only once
    public void printOwners() {
        ArrayList<String> printNames = new ArrayList<String>();
        
        for (RegistrationPlate plate : this.owners.keySet()) {
            if (!printNames.contains(this.owners.get(plate))) {
                printNames.add(this.owners.get(plate));
            }
        }
        
        for (String owner : printNames) {
            System.out.println(owner);
        }
    }
    
    public void testHash() {
        System.out.println(this.owners);
    }
}
