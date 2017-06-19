import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Participants{
    List<Jumper> jumpers;
    
    public Participants() {
        this.jumpers = new ArrayList<Jumper>();
    }
    
    // ADD specific jumper to jumpers ArrayList, has nothing to do with adding points or anything else
    public void add(Jumper jumper) {
        this.jumpers.add(jumper);
    }
    
    public void play(int round) {
        int order = 1;
        
        System.out.println("\nJumping order:");
        
        Collections.sort(jumpers);
//        Collections.reverse(jumpers);
        
        for (Jumper jumper : jumpers) {
            System.out.println("  " + order++ + ". " + jumper.getName() + " (" + jumper.getPoints() + " points)");
        }
        
        for (Jumper jumper : jumpers) {
            jumper.addJump();
        }
        
        System.out.println("\nResults of round " + round);
            for (Jumper jumper : jumpers) {
                System.out.println("  " + jumper.getName());
                System.out.println("    length: " + jumper.getJumpLength());
                System.out.println("    judge votes: " + Arrays.toString(jumper.getJudgeScores()));
            }
        System.out.println("");
        
    }
    
    public void printResults() {
        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        
        for (int i = 0; i < jumpers.size(); i++) {
            Jumper jumper = jumpers.get(i);
            System.out.println((i+1) + "           " + jumper.getName() + " (" + jumper.getPoints() + " points)");
            System.out.print("            jump lengths: ");
            
            for (int j = 0; j < jumper.getJumpLengths().size(); j++) {
                System.out.print(jumper.getJumpLengths().get(j) + "m");
                if (j < jumper.getJumpLengths().size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println("");
                }
            }
        }
        
    }
    

}
