
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int totalPoints;
    private int jumpLength;
    private int[] judgeScores;
    private ArrayList<Integer> jumpLengths;
    private Random random = new Random();
    
    public Jumper(String name) {
        this.name = name;
        this.totalPoints = totalPoints;
        this.jumpLengths = new ArrayList<Integer>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPoints() {
        return totalPoints;
    }
    
    public int getJumpLength() {
        return jumpLength;
    }
    
    public int[] getJudgeScores() {
        return judgeScores;
    }
    
    public ArrayList<Integer> getJumpLengths() {
        return this.jumpLengths;
    }
    
    // TEST METHOD TO HELP DEBUG SORTING BY POINTS
    public void debugPoints(int points) {
        this.totalPoints += points;
    }
    
    public void addJump() {
        // Random number for Length between 60-120 random.randint(61) + 60? 
        jumpLength = random.nextInt(61) + 60;
        jumpLengths.add(jumpLength);
        
        // 5 index array of Random Numbers
        judgeScores = new int[5];
        for (int i = 0; i < judgeScores.length; i++) {
            judgeScores[i] = random.nextInt(11) + 10;
        }
        
        // Sort individual judges scores, so the lowest and highest can be negated
        Arrays.sort(judgeScores);
        
//        System.out.println(this.name + " jump length: " + jumpLength);
//        System.out.println(Arrays.toString(judgeScores));
        
        // Add index 1:3 of judgeScores to totalPoints
        for (int i = 1; i < 4; i++) {this.totalPoints += judgeScores[i];}
        this.totalPoints += jumpLength;
        
    }
    
    
    ////////////////////BOILERPLATE FOR COMPARABLE INTERFACE///////////////////////
    public int compareTo(Jumper otherJumper) {
        if (this.getPoints() == otherJumper.getPoints()) {
            return 0;
        } else if (this.getPoints() > otherJumper.getPoints()) {
            return 1;
        } else {
            return -1;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////
    
    public String toString() {
        return this.name + " has " + this.getPoints() + " points.";
    }
}
