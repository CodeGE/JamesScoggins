import java.util.Scanner;
import java.util.ArrayList;


public class UserInterface {
    private final Scanner reader;
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;
    
    public UserInterface(Scanner reader) {
        this.reader = reader;
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
    }
    
    public void addPlane() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        String planeCapacity = reader.nextLine();
        this.planes.add(new Plane(planeID, planeCapacity));
    }
    
    public Plane getPlane (String input) {
        for (Plane plane : planes) {
            if (plane.getID().equals(input)) {
                return plane;
            }
        }       
        return null;
    }
    
    public void printPlaneInfo() {
        System.out.print("Give plane ID: ");
//        String whatPlane = reader.nextLine();
//        Plane plane = getPlane(whatPlane);
        Plane.printPlaneInfo(getPlane(reader.nextLine()));
    }
    
    public void addFlight() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        // GET PLANE OBJECT? STATIC METHOD IN PLANE CLASS MAYBE?
        Plane plane = getPlane(planeID);
        
        System.out.print("Give departure airport code: ");
        String departureCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationCode = reader.nextLine();

        flights.add(new Flight(plane, departureCode, destinationCode));
    }
    
    public void start() {
        startAirportPanel();
        startFlightService();
    }
    
    public void startAirportPanel() {
        
        System.out.println("Airport panel\n" +
                            "--------------------\n");
        
        while (true) {
            System.out.println("Choose operation:\n" +
                        "[1] Add airplane\n" +
                        "[2] Add flight\n" +
                        "[x] Exit");
            
            System.out.print("> ");
            
            String option = this.reader.nextLine();
            
            if (option.equals("x")) {
                break;
            } else if (option.equals("1")) {
                addPlane();
            } else if (option.equals("2")) {
                addFlight();
            } else {
                for (Plane plane : planes) {
                    System.out.println(plane.toString());
                }
            }
        }
    }
    
    public void startFlightService() {
        System.out.println("\nFlight service\n" +
                            "------------\n");
        
        System.out.println("Choose operation:\n" +
            "[1] Print planes\n" +
            "[2] Print flights\n" +
            "[3] Print plane info\n" +
            "[x] Quit");
        
        while (true) {
            System.out.print("> ");
            String option = reader.nextLine();
            
            if (option.equals("x")) {
                break;
            } else if (option.equals("1")) {
                Plane.printPlanes(planes);
            } else if (option.equals("2")) {
                Flight.printFlights(flights);
            } else if (option.equals("3")) {
                printPlaneInfo();
                
            }
        }
    
    }
}
