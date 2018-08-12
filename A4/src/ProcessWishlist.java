// -----------------------------------------------------
// Assignment 4
// Written by: Muherthan Thalayasingam - 27223064
// ----------------------------------------------------- 
/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #4 <p>
 * Due 11/08/18 <p>
 * This program lets the user find out whether or not they can watch a show based on their current watchlist and their interests.
 * This program makes uses of I/O to read the watchlist/interest, and uses a linked-list to keep track of the different shows and time slots.
 * <p>
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main driver class used for the program.
 * @author Muher
 *
 */
public class ProcessWishlist {
	public static void main(String[] args) {
		// Created two linked lists, one used later for part e of task 4.
		Scanner input = new Scanner(System.in);
		ShowList list1 = new ShowList();
		ShowList list2;
		BufferedReader reader;
		
		// Put in try-catch clause for exception handling
		try {
			File guide = new File("TVGuide.txt");
			reader = new BufferedReader(new FileReader(guide));
			
			String line = reader.readLine();
			int counter = 0;
			String showID = ""; 
			String showName = "";
			double startTime = 0; 
			double endTime = 0;
			String[] unique = new String[10];
			int nameCounter = 0;
			int repeat = 0;
			Show show = null;

			// First I start by getting rid of the extra line between each shows. Then I separate the values by line.
			while (line != null) {
				counter++;
				if (!line.equals("")) {
					if(counter == 1) {
						showID = line.substring(0, line.indexOf(" "));
						showName = line.substring(line.indexOf(" ")+1);
						unique[nameCounter] = line.substring(line.indexOf(" ")+1);
						nameCounter++;
					}
					else if (counter == 2) startTime = Double.parseDouble(line.substring(2));
					else endTime = Double.parseDouble(line.substring(2));
				}
				line = reader.readLine();

				// This is used to keep track of when the show information has been collected, moves onto next show
				if (counter % 4 == 0) {
					for (int i = 0; i < unique.length; i++) {
						if (unique[i] != null && unique[i].equals(showName)) repeat++;				
					}
					if (repeat <= 1) {
						show = new Show(showID, showName, startTime, endTime);
						list1.addToStart(show);
					} 
					repeat = 0;
					counter = 0;	
				}
			}
			reader.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// For this, I used an ArrayList and populated it using while loop.
		try {
			File interest = new File("Interest.txt");
			reader = new BufferedReader(new FileReader(interest));
			ArrayList<String> watching = new ArrayList<String>();
			ArrayList<String> wishlist = new ArrayList<String>();
			
			String line = reader.readLine();
			
			while (line != null) {
				if (line.equals("Watching")) {
					line = reader.readLine();
				} 
				watching.add(line);
				line = reader.readLine();
				if (line.equals("Wishlist")) {
					break;
				}	
			}
			
			while (line != null) {
				if (line.equals("Wishlist")) {
					line = reader.readLine();
				} 
				wishlist.add(line);
				line = reader.readLine();
			}
			Show watch = null;
			Show interested = null;

			// Use nested for loops to go over all the comparisons
			int track = 0;
			for (int i = 0; i < wishlist.size()-1; i ++) {
				interested = list1.find(wishlist.get(i)).getShow();
				for (int j = 0; j < watching.size(); j ++) {
					watch = list1.find(watching.get(j)).getShow();
					
					if (interested.isOnSameTime(watch).equals("Same time")) {
						System.out.println("User can't watch show " + interested.getShowID() + " as he/she will begin another show at the same time.");
						break;
					} else if (interested.isOnSameTime(watch).equals("Some overlap")) {
						System.out.println("User can't watch show "+ interested.getShowID() +" as he/she is not finished with a show he/she is watching.");
						break;
					} else {
						track++;
					if (track == 2)
						System.out.println("User can watch show " + interested.getShowID()+ " as he/she is not watching anything else during that time.");
					}
				}
			}			
			
			reader.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Prompts user for two showID to check in the linked-list.
		System.out.println();
		System.out.println("Please enter a showID: ");
		String id = input.nextLine();
		
		if (list1.find(id) != null)
		{
			System.out.println("Show name: " + list1.find(id).getShow().getShowName() + " - Iterations Performed: " + list1.searchCounter);
			System.out.println();
		} else
			System.out.println("Not a valid showID.");
		System.out.println();
		
		System.out.println("Please enter a showID: ");
		String id2 = input.nextLine();
		
		if (list1.find(id2) != null)
		{
			System.out.println("Show name: " + list1.find(id2).getShow().getShowName() + " - Iterations Performed: " + list1.searchCounter);
			System.out.println();
		} else
			System.out.println("Not a valid showID.");

		input.close();
		
		System.out.println();
		
		// Part e, tested all methods that weren't already used before. Double checked with sysout.
		list2 = new ShowList(list1);
		Show show1 = new Show("CBC25", "Abc", 20.00, 21.00);
		Show show2 = show1.clone("CBC26");
		
		System.out.println(show1.equals(show2));
		list2.addToStart(show1);
		System.out.println(list2.contains("CBC25"));
		System.out.println(list2.contains("CBC26"));
		list2.replaceAtIndex(show2, 0);
		list2.deleteFromIndex(1);
		list2.deleteFromStart();
		list2.insertAtIndex(show2, 1);
	}
}