import java.util.Random;
/**
 * Write a description of class QB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QB extends player
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class QB
     */
    public QB()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * The actor class for QB
     */
    public void actor2()
    {
        int action = 1;
        
        if(action == 1)
        {
            attemptPass();
        }
        
    }
    
    /**
     * attempts a pass
     */
    public void attemptPass(Player widereciever)
    {
        //data data1 = new data();
        Random rand = new Random();
        int max = 100;
        int min = 1;
        int passPercentage = rand.nextInt((max-min) + 1) + min;
        int yardsOnPlay = 1;
        if(passPercentage > 29)
        {
            yardsOnPlay = passPercentage - 29;
            data.passComplete(yardsOnPlay);
            widereciever.hasBall();
            widreciever.updatePosition(yardsOnPlay, y)
        }
        else if(passPercentage > 9)
        {
            data.passIncomplete();
        }
        else if(passPercentage > 2)
        {
            yardsOnPlay = 3 - passPercentage;
            data.sack(yardsOnPlay);
        }
        else
        {
            data.turnover();
        }
    }
            
}
