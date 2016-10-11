import java.util.Random;
/**
 * The Player class contains an act() and act2() method that control
 * how the ball and players interact
 */
public class Player{
    String qb = "qbstr";
    String wr = "wrstr";
    String rb = "rbstr";
    String kr = "krstr";
    String pr = "prstr";
    String def = "defstr";
    String positionWithBall = "";
    int position = 0;
    //int score = 0;
    /*
     * Player constructor, no parameters
     */
    public Player(){
        String positionWithBall = "";
    }
    
    /*  START OFFENSIVE PLAYS
     * quarterback hands ball to running back
     */
    public int runPlay(){
        positionWithBall = rb;
        //change position of the ball to that of rb
        
        //add on a certain amount of yards
        return position+=5;
    }
      
    /*
     * quarterback throws ball to wide receiver for a complete pass
     */
    public int completePass(){
        positionWithBall = wr;
        //change position of the ball to that of wr who caught ball
        
        //add on a certain amount of yards
        return position+=5;
    }
       
    /*
     * quarterback throws ball to wide receiver for an incomplete pass
     */
    public int incompletePass(){
        positionWithBall = qb;
        //keep position of the ball to that of qb
        
        //add on zero yards
        return position+=0;
    }
    
    /*START DEFENSIVE PLAYS
     * tackle offensive player with ball
     */
//    public int tackle(){
        
  //  }
    
    /*START SPECIAL TEAMS PLAYS
     * kick the ball
     */
    public int kickBall(){
        positionWithBall = kr;
        //change position of the ball to that of kr
        
        //add on a certain amount of yards
        return position+=5;
    }
       
    /*
     * quarterback throws ball to wide receiver for an incomplete pass
     */
    public int puntBall(){
        positionWithBall = pr;
        //change position of the ball to that of pr
        
        //add on a certain amount of yards
        return position+=5;
    }

    }
