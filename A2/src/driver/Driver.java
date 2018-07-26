package driver;

import soccerplayer.SoccerPlayer;
import goalkeeper.*;
import forward.*;
import midfield.*;

import java.util.Date;

import back.*;
/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * This program makes use of 14 classes to create multiple objects derived from each of these classes.
 * Then, we use an array containing 18 of those objects to find the player(s) with the most number of
 * goals scored, and the player(s) with the least number of goals scored. We also use the array to
 * group players by club association. Finally, we make use of cloning to create a clone of the array
 * where each object within it maintain their type.
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, 
 * the number of red cards, and the number of games played. 
 */
public class Driver {
	static SoccerPlayer[] teamSimilarTo(SoccerPlayer[] players) {
		SoccerPlayer[] database = new SoccerPlayer[players.length];
		for (int i = 0; i<players.length; i++) {
			database[i] = players[i].clone();
		}
		return database;
	}
	
	
	public static void main(String[] args) {
		// Welcome Message
		System.out.println("*************************WELCOME TO ASSIGNMENT 2*************************");
		
		
		// I'll assume everyone's born on my dob for simplicity. 
		Date d1 = new Date(1995, 12, 13);
		
		SoccerPlayer soccer1 = new SoccerPlayer("P1", d1, "Club1", "Country1", 0, 0, 5);
		
		Goalkeeper goal1 = new Goalkeeper("G1", d1, "Club2", "Country2", 0, 3, 5, 2, 3, 12);	
		
		Midfielder mid = new Midfielder("M1", d1, "Club3", "Country3", 1, 0, 2, 12);
		WideMidfielder widemid= new WideMidfielder("M2", d1, "Club3", "Country3", 1, 1, 3, 12, 23);
		DefensiveMidfielder defmid = new DefensiveMidfielder("M3", d1, "Club1", "Country1", 2, 0, 12, 24, 33);
		CentreMidfielder cenmid = new CentreMidfielder("M4", d1, "Club2", "Country2", 0, 0, 2, 5, 42);
		
		Forward forward = new Forward("F1", d1, "Club4", "Country4", 1, 1, 5, 12, 11, 3);
		Winger winger = new Winger("F2", d1, "Club1", "Country5", 0, 1, 6, 15, 25, 33, 42);
		CentreForward cenforward = new CentreForward("F3", d1, "Club2", "Country4", 0, 0, 2, 5, 15, 4, 12);
		Striker striker = new Striker("F4", d1, "Club1", "Country1", 0, 0, 7, 2, 8, 2, 1.5);
		
		Defender defender = new Defender("D1", d1, "Club4", "Country5", 1, 2, 3, 6);
		Sweeper sweeper = new Sweeper("D2", d1, "Club2", "Country1", 0, 0, 5, 0, 3);
		CentreBack cenback = new CentreBack("D3", d1, "Club5", "Country2", 3, 2, 9, 15, 52);
		WingBack winback = new WingBack("D3", d1, "Club5", "Country2", 3, 2, 9, 15, 52);
		
		Goalkeeper goal2 = new Goalkeeper(goal1);
		Defender defender2 = new Defender("D5", d1, "Club3", "Country1", 3, 5, 12, 33);
		CentreForward cenforward2 = new CentreForward("F5", d1, "Club1", "Country6", 1, 3, 4, 1, 12, 3, 11);
		WideMidfielder widemid2 = new WideMidfielder("M5", d1, "Club5", "Country5", 0, 0, 3, 10, 9);
		
		System.out.println(soccer1);
		System.out.println(goal1);
		System.out.println(mid);
		System.out.println(widemid);
		System.out.println(defmid);
		System.out.println(cenmid);
		System.out.println(forward);
		System.out.println(winger);
		System.out.println(cenforward);
		System.out.println(striker);
		System.out.println(defender);
		System.out.println(sweeper);
		System.out.println(cenback);
		System.out.println(winback);
		System.out.println(goal2);
		System.out.println(defender2);
		System.out.println(cenforward2);
		System.out.println(widemid2);
		
		System.out.println("*********************************************************************************");
		System.out.println("Testing for equality: ");
		System.out.println();
		System.out.println(soccer1.equals(goal1));
		System.out.println(widemid.equals(striker));
		System.out.println(defender.equals(cenforward2));
		System.out.println(goal1.equals(goal2));
		System.out.println(defender2.equals(winger));
		System.out.println(winback.equals(cenback));
		System.out.println(cenmid.equals(defmid));
		System.out.println(soccer1.equals(striker));
		System.out.println(winger.equals(forward));
		System.out.println(mid.equals(defmid));
		System.out.println();
		
		SoccerPlayer[] database = {soccer1, goal1, mid, widemid, defmid, cenmid, forward, winger, cenforward, striker, defender, sweeper, cenback,
				winback, goal2, defender2, cenforward2, widemid2};
		
		// Searching for the highest # of goals.
		int goalsHigh = 0;
		for (int i = 0; i < database.length; i++) {
			if (database[i] instanceof Forward) {
				if (((Forward) database[i]).getGoalsScored() > goalsHigh) {
					goalsHigh = ((Forward) database[i]).getGoalsScored();
				}
			}
		}
		// Prints the player(s) with the highest # of goals.
		System.out.println("*********************************************************************************");
		System.out.println();
		System.out.println("The players with the highest number of goals scored:");
		for (int i = 0; i < database.length; i++) {
			if (database[i] instanceof Forward) {
				if (((Forward) database[i]).getGoalsScored() == goalsHigh) {
					System.out.println("Player #" + (i + 1) + "\n" + database[i]);
					System.out.println();
				}
			}
		}
		
		// Searching for the least # of goals. Starting value is the highest number of goals.
		int goalsLow = goalsHigh;
		for (int i = 0; i < database.length; i++) {
			if (database[i] instanceof Forward) {
				if (((Forward) database[i]).getGoalsScored() < goalsLow) {
					goalsLow = ((Forward) database[i]).getGoalsScored();
				}
			}
		}
		// Prints the player(s) with the least # of goals.
		System.out.println("*********************************************************************************");
		System.out.println();
		System.out.println("The player(s) with the least number of goals scored: ");
		for (int i = 0; i < database.length; i++) {
			if (database[i] instanceof Forward) {
				if (((Forward) database[i]).getGoalsScored() == goalsLow) {
					System.out.println("Player #" + (i + 1) + "\n" + database[i]);
					System.out.println();
				}
			}
		}
		
		// Searches for the players from the same association.
		System.out.println("*********************************************************************************");
		System.out.println();
		System.out.println("Similar clubs:");
		// Used this to keep track of which object we already counted.
		int[] track = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		// Once again, I added one so that the # of players makes more sense.
		for (int i = 0; i < database.length; i++) {
			String clubName = database[i].getClubName();
			if (track[i] != 1) {
				System.out.println("Club name: " + clubName +"\n");
				System.out.println("Player #" + (i+1) + "\n" + database[i]);
			}
			track[i] = 1;
			for (int j = i+1; j < database.length; j++) {
				if(database[j].getClubName().equals(clubName) && track[j] != 1) {
					System.out.println("Player #" + (j+1) + "\n" + database[j]);
					track[j] = 1;
				}
			}
		}
		System.out.println("*********************************************************************************");
		System.out.println();
		System.out.println("Cloning teams: ");
		SoccerPlayer[] newDatabase = Driver.teamSimilarTo(database);
		for (int i = 0; i < newDatabase.length; i++) {
			System.out.println("Player #" + (i+1) + ": ");
			System.out.println("Original: " + database[i]);
			System.out.println("Clone: " + newDatabase[i]);
		}
		System.out.println();
		System.out.println("************************************ GOODBYE ************************************");
	}
}
