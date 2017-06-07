import java.util.ArrayList;

public class Flight {
    private Plane plane;
    private String departureCode;
    private String destinationCode;
    
    public Flight(Plane plane, String departureCode, String destinationCode) {
        this.plane = plane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }
    
    public static void printFlights(ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
    
    public String toString() {
        return this.plane.toString() + " (" + departureCode + "-" + destinationCode + ")";
    }
}
