import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        String syote = "1\nAY-123\n108\n"
        + "1\nDE-213\n75\n"
        + "1\nRU-999\n430\n"
        + "2\nAY-123\nHEL\nTXL\n"
        + "2\nAY-123\nJFK\nHEL\n"
        + "2\nDE-213\nTXL\nBAL\n"
        + "x\n"
        + "2\n"
        + "1\n"
        + "3\n"
        + "AY-123\n"
        + "x\n";
        
        Scanner reader = new Scanner(System.in);
        UserInterface ui = new UserInterface(reader);
        ui.start();
    }
}
