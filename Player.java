import java.util.Random;
/**
 * The Player class contains an act() and act2() method that control
 * how the ball and players interact
 * 
 * act() will alter updateMessage(int messageCode, int tick, int yardage, int positionOfBall, Player player)
 * 
 * @Katie-Prochilo
 * Email prochilok3@students.rowan.edu for clarification or questions
 * 
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

    int overallSkill = 80; //we will import numbers later
    int speed = 75; //the numbers will come from data???
    int strength = 70;
    
    boolean runPlay = false;
    boolean completePass = false;
    boolean incompletePass = false;
    boolean kickBall = false;
    boolean puntBall = false;
    boolean fieldGoal = false;
    boolean timeToKickOff = false;
    
    int positionOfBall = 0;
    int score = 0; //Matt will need to implement all scoring functions
    int yardage = 0;
    int down = 1;
    int yardsToGo = 10;
    
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
         * if then case block to figure out what play will happen
         */
        
        if (timeToKickOff){
            kickBall = true;
            timeToKickOff = false;
        }
        
        /*
         * if it is fourth down
         */
        
        else if (down == 4){
            if (positionOfBall >= 60){
                fieldGoal = true;
            }
            
            else { //too far for a field goal, so the punter will punt
                puntBall = true;
            }
        }
        
        /*
         * if the offense can play the ball
         */
        
        else {
            if (down == 1){
                runPlay = true;
            }
            
            else if (down == 2){
                incompletePass = true;
            }
            
            else{
                completePass = true;
            }        
        }
        
        
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
            yardage = (overallSkill + speed + strength) / 50;
            positionOfBall = positionOfBall;
            yardsToGo = yardsToGo - yardage;
            Stats.updateMessage(1, getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            
            runPlay = false; //reset the play call
            down++;
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
                Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            else {
                yardage = 10;
                Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            yardsToGo = yardsToGo - yardage;
            completePass = false; //reset the play call
            down++;
        }
       
        
        /*
         * quarterback throws ball to wide receiver for an incomplete pass
         * this means the ball position stays the same
         * 
         * act2() does not need to do much
         * since the pass was incomplete 
         */
         else if (incompletePass){
            //keep position of the ball to that of qb
            positionWithBall = qb;
        
            //add on zero yards
            yardage = 0;
            yardsToGo = yardsToGo - yardage;
            Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            
            incompletePass = false; //reset the play call
            down++;
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
                yardage = (int) (overallSkill + strength) / 3;
                Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            else {
                yardage = (int) (overallSkill + strength) / 3.5;
                Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            yardsToGo = yardsToGo - yardage;
            kickBall = false; //reset the play call
            down = 1;//the ball has been turned over so the other team will start with new downs
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
                Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            else {
                yardage = 35;
                Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }
            
            yardsToGo = 10;//at this point it doesn't matter what YTG are.  Other team will eventually get ball with 10 YTG
            puntBall = false; //reset the play call
            down = 1;//the ball has been turned over so the other team will start with new downs
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
            
            yardsToGo = 10;//at this point it doesn't matter what YTG are.  Other team will eventually get ball with 10 YTG
            Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            
            fieldGoal = false; //reset the play call
            down = 1;//the ball has been turned over so the other team will start with new downs
        }
        
        /*
         * this should be able to be taken out eventually, but this is a blanket else statement
         * in case the previous cases are not yet sufficient for every scenario.
         */
        else {
            Stats.updateMessage(1, Clock.getTick(), yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
        }
        
        
        /*
         * this keeps track of which down it is.
         * If there is a first down, that is the yardage gained on the play is more 
         * than the yards to gain the first down, the down counter will reset
         */
        if (yardsToGo <= 0){
            down = 1;
        }
    }
}
