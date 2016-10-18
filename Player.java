import java.util.Random;
import java.util.ArrayList;
/**
 * The Player class contains an act() and act2() method that control
 * how the ball and players interact
 * 
 * act() will return a single String that other classes may parse
 * 
 * This will always be in the format as follows
 * "IntScore IntCurrentBallPosition LastName BooleanHasBall"
 * Each entry will be one word
 * Players with multiple last names will by hyphenated
 * One space between each entry, and no commas
 */
public class Player{
    String qb = "quarterback";
    String wr = "wide-receiver";
    String rb = "running-back";
    String kr = "kick-returner";
    String pr = "punt-returner";
    String k = "kicker";
    String p = "punter";
    String def = "defenseman";
    String positionWithBall;

    int positionOfBall = 0;
    int overallSkill = 80; //we will import numbers later
    int speed = 75; //the numbers will come from data???
    int strength = 70;
    
    boolean runPlay = false;
    boolean completePass = false;
    boolean tackle = false;
    boolean kickBall = false;
    boolean puntBall = false;
    boolean fieldGoal = false;
    
    int score = 0;
    int yardage = 0;
    
    ArrayList<String> list = new ArrayList<String>();
    
    /*
     * Player constructor, no parameters
     */
    public Player(){
        positionWithBall = "";
    }
    
    /*
     * act() will communicate using
     * updateMessage(int messageCode, int tick, int yardage, int positionOfBall, Player player)
     * that comes from the Stats team
     */
    public void act(){
        /*  
         * START OFFENSIVE PLAYS
         * 
         * quarterback hands ball to running back
         * 
         * act2() will decide how far the running back goes
         */
        
        if (runPlay){
            //change position of the ball to that of rb
            positionWithBall = rb;
        
            //add on a certain amount of yards
            yardage = 0;
            positionOfBall = positionOfBall;
            updateMessage(1, 0, yardage, positionOfBall, player);//this should not compile until shared and commited with Stats message class
        }
      
        
        /*
         * quarterback throws ball to wide receiver for a complete pass
         * if the receiver is good, they'll have caught the ball for more yards
         * if they aren't so good, it will have been a shorter catch
         * 
         * act2() will decide what happens after the wide receiver catches the ball
         * they can get tackled immediately or run for yards after the catch
         */
        
        else if (completePass){
            //change position of the ball to that of wr who caught ball
            positionWithBall = wr;
        
            //add on a certain amount of yards
            if ((overallSkill + speed + strength) > 210){
                yardage = 15;
                updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            else {
                yardage = 10;
                updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
        }
       
        
        /*
         * quarterback throws ball to wide receiver for an incomplete pass
         * this means the ball position stays the same
         * 
         * act2() does not need to do much
         * since the pass was incomplete 
         */
        
         else if (!completePass){
            //keep position of the ball to that of qb
            positionWithBall = qb;
        
            //add on zero yards
            yardage = 0;
            updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
        }
        
        
        /*START SPECIAL TEAMS PLAYS
         * this statement will cover from from when the kicker has the ball up until the kick
         * returner catches the ball
         * 
         * act2() will decide how far the ball advances up the field
         * when the kick returner returns it
         */
        
        else if (kickBall){
            /*
             * this statement will cover from from when the kicker has the ball up until the kick
             * returner catches the ball
             * act2() will decide how far the ball advances up the field
             */
            //position with the ball is kicker
            positionWithBall = k;
        
            //add on a certain amount of yards depending on the strength and ability of the kicker
             if ((overallSkill + strength) > 120){
                yardage = 50;
                updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            else {
                yardage = 40;
                updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
        }
       
        
        /*
         * this statement will cover from from when the kicker has the ball up until the kick
         * returner catches the ball
         * 
         * act2() will decide how far the ball advances up the field
         * when the kick returner returns it
         */
        
        else if (puntBall){
            //position with the ball is punter
            positionWithBall = p;
        
            //add on a certain amount of yards depending on the strength and ability of the punter
            if ((overallSkill + strength) > 120){
                yardage = 40;
                updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            else {
                yardage = 35;
                updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
        }
       
        
        /*
         * this statement will cover from from when the kicker has the ball up until he
         * kicks it for an attempted field goal.  Position will stay the same 
         * 
         * act2() will decide if the kick is good.
         * If the kick is good, add three points and restart for a kickoff
         * If the kick is not good, the position of the ball is the same, but possesion switches
         */
        
        else if (fieldGoal){
            //position with the ball is kicker
            positionWithBall = k;
            
            updateMessage(1, 0, yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
        }
        
        /*
         * this should be able to be taken out eventually, but this is a blanket else statement
         * in case the previous cases are not yet sufficient for every scenario.
         */
        else {
            updateMessage(1, 0, 0, positionOfBall, player);//this should not compile until shared and commited with Stats message class
        }
    }
}
