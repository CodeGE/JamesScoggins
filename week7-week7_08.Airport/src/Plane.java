import java.util.ArrayList;
import java.util.Scanner;

public class Plane {
    private String id;
    private String capacity;
    
    public Plane(String id, String capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    

    
    public String getID() {
        return this.id;
    }
    
    public String getCapacity() {
        return this.capacity;
    }
    
    public static void printPlanes(ArrayList<Plane> planes) {
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }
    
    public static void printPlaneInfo(Plane plane) {
        System.out.println(plane);        
        
    }
    
    public String toString() {
        //Replace later? Sample code.
        return this.id + " (" + this.capacity + " ppl)";
    }
}
