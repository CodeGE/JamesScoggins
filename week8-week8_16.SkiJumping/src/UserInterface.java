
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    
    Scanner reader = new Scanner(System.in);
    private Participants participants;
    
    public UserInterface() {
        this.participants = new Participants();
    }
    
    public void startRound() {
    
        int round = 0;
        
        System.out.println("\nThe tournament begins!\n");
        
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            System.out.println("");
            
            if (command.equals("jump")) {
                round++;
                System.out.println("Round " + round);

                // Begin play routine in Participants Class
                this.participants.play(round);           
            } else {
                this.participants.printResults();
                break;
            }
            
        }

    }
    
    public void start() {        
        System.out.println("Kumpula ski jumping week\n");
        
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        
        // Accept names until user enters blank space
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            
            if (name.equals("")) {
                break;
            } else {
                // Add names of partipants to ArrayList jumpers in Participants Class
                participants.add(new Jumper(name));
            }
        }
        
        startRound();
        
    }
    

    
    public String toString() {
        return "UI Created";
    }
}
