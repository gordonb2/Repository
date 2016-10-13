package oopdaFB;

 import java.io.File; 
 import java.io.Serializable; 
 import java.util.ArrayList; 
 
 
 public class PlayerStat extends Statistic implements Serializable  
 { 
 	private static final long serialVersionUID = 1L; 
	private ArrayList<String> messages; 
 	private int touchdown = 0; 
 	private int interception= 0; 
 	private int pass = 0; 
 	private int fumble = 0; 
 	private int penalty = 0; 
 	private int firstDown = 0; 
 	private int turnover = 0; 
 	private int receiving = 0; 
 	private int point = 0; 
 	private int fieldGoal = 0; 
 	private int quarter = 1; 
 	 
 	public PlayerStat()  
 	{ 
 		super(); 
		messages = new ArrayList<String>(); 
 		addMessages(); 
 	} 
 	 
 	private int getQuarter() 
 	{ 
 		return quarter; 
 	} 
 	 
 	private int getTouchdown() 
 	{ 
 		return touchdown; 
 	} 
 	 
 	public int getInterception() 
 	{ 
 		return interception; 
 	} 
 	 
 	public int getPass() 
 	{ 
 		return pass; 
 	} 
 	 
 	public int getFieldGoal() 
 	{ 
 		return fieldGoal; 
 	} 
 	 
 	public int getFumble() 
 	{ 
 		return fumble; 
 	} 
 	 
 	public int getPenalty() 
 	{ 
 		return penalty; 
 	} 
 	 
 	public int getFirstDown() 
 	{ 
 		return firstDown; 
 	} 
 	 
 	public int getTurnover() 
 	{ 
 		return turnover; 
 	} 
 	 
 	public int getRecieving() 
 	{ 
 		return receiving; 
 	} 
 	 
 	public int getPoint() 
 	{ 
 		return point; 
 	} 
 	 
 	public void increaseScore() 
 	{ 
 		int score = 6; 
 		point = point + score; 
 	} 
 	 
 	public void fieldGoal() 
 	{ 
 		int goal = 1; 
 		point = point + goal; 
	} 
 
 
 	public void readData(String fl) throws Exception  
 	{ 
 		super.readData(fl); 
 	} 
 
 
 	public void findMessage(int messageNumber, String name, String time) 
 	{ 
 		//Will switch name and time to something other then String just place holder till we know the object type 
 		String messageGot = null; 
 		switch (messageNumber) { 
 		case 1 : messageGot = messages.get(1); 
 		touchdown++; 
 		increaseScore(); 
 				break; 
 		case 2 : messageGot = messages.get(2); 
 		interception++; 
 				break; 
 		case 3 : messageGot = messages.get(3); 
		pass++; 
 				break; 
 		case 4 : messageGot = messages.get(4); 
		fieldGoal(); 
 		fieldGoal++; 
 				break; 
 		case 5 : messageGot = messages.get(5); 
 		fumble++; 
 				break; 
 		case 6 : messageGot = messages.get(6); 
 		firstDown++; 
 				break; 
 		case 7 : messageGot = messages.get(7); 
 		turnover++; 
 		break; 
 		case 8 : messageGot = messages.get(8); 
 		penalty++; 
				break; 
 		} 
 		//When the Player calls on message we need you to pass the parrameter for name and time. 
 		System.out.println(Player.getName() + ": " + messageGot + ": at " + Interface.getTime()); 
 	} 
 	 
 	public void addMessages() 
	{ 
 		//Messages that are displayed they are in the order that they need to be called eg. Touchdown is 1 
 		messages.add("TOUCHDOWN!"); 
 		messages.add("INTERCEPTION!"); 
 		messages.add("PASS COMPLETE!"); 
 		messages.add("FIELD GOAL!"); 		messages.add("FUMBLE!"); 
 		messages.add("FIRST DOWN!"); 
 		messages.add("TURNOVER!"); 
 		messages.add("PENALTY!"); 
	} 
 	 
 	public void overviewQuarter() 
 	{ 
 		//This is the overview that can be displayed at the end of each quarter that the interface can call to display the overview 
 		System.out.println("Overview for the " + getQuarter() + " Quarter:"); 
 		System.out.println("Touchdowns: " + getTouchdown()); 
 		System.out.println("Interceptions: " + getInterception()); 
 		System.out.println("Pass Completions: " + getPass()); 
 		System.out.println("Field Goals: " + getFieldGoal()); 
 		System.out.println("Fumbles: " + getFumble()); 
 		System.out.println("First Downs: " + getFirstDown()); 
 		System.out.println("Turnovers: " + getTurnover()); 
 		System.out.println("Penalties: " + getPenalty()); 
 		System.out.println("Points Scored: " + getPoint()); 
	} 
}
