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
import java.util.NoSuchElementException;

/**
 * The ShowList class which contains the head of the linked-list and the nested class for the Node.
 * @author Muher
 * Has a private ShowNode object for the head of the linked-list, and a private int to keep track of size.
 * Also included a searchCounter for the iteration tracking.
 */
public class ShowList {
	private ShowNode head;
	private int size;
	int searchCounter;
	
	/**
	 * Default constructor method
	 */
	public ShowList() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Copy constructor
	 * @param other ShowList object used for the copy values.
	 */
	public ShowList(ShowList other) {
		this.head = other.head;
		this.size = other.size;
	}
	
	/**
	 * Method used to add a new node to the start of the linked-list
	 * @param show Show object used for the node values.
	 */
	public void addToStart(Show show) {
		this.head = new ShowNode(show, this.head);
		this.size++;
	}
	
	/**
	 * Method used to insert a node at the given index
	 * @param show Show object used for the node values.
	 * @param index int used for the indexing.
	 */
	public void insertAtIndex(Show show, int index) {
		try {
			if (index > this.size || index < 0)
				throw new NoSuchElementException();
			
			ShowNode position = head;
			
			ShowNode node = new ShowNode(show, null);
		
			for (int i = 0; i < index-1; i++) {
				position = position.getLink();
			}
			
			node.setLink(position.getLink());
			
			position.setLink(node);
			this.size++;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Method used to delete a node at the given index.
	 * @param index int used for the indexing.
	 */
	public void deleteFromIndex(int index) {
		try {
			if (index > this.size || index < 0)
				throw new NoSuchElementException();
			ShowNode position = head;
		
			for (int i = 0; i < index-1; i++) {
				position = position.getLink();
			}
			position.setLink(position.getLink().getLink());
			this.size--;
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Method used to delete the head of the linked-list
	 */
	public void deleteFromStart() {
		if(head != null) {
			head = head.getLink();
			this.size--;
		} else {
			System.out.println("This list is empty.");
		}
	}
	
	/**
	 * Method used to replace a node at a specific index with another node
	 * @param show Show object used for the node values.
	 * @param index int used for indexing.
	 */
	public void replaceAtIndex(Show show, int index) {
		if (index > this.size || index < 0) {
			return;
		} else {
			ShowNode position = this.head;
			
			for (int i = 0; i < index; i++) {
				position = position.getLink();
			}
			position.setShow(show);
		}
	}
	
	/**
	 * Method used to find the ShowNode object given a showID.
	 * @param showID String that represents a unique identifier for each show.
	 * @return ShowNode object which is a node in the linked-list.
	 */
	public ShowNode find(String showID) {
		ShowNode position = this.head;
		this.searchCounter = 0;
		while (position != null) {
			this.searchCounter++;
			if (position.getShow().showID.equalsIgnoreCase(showID))
				return position;
			position = position.getLink();
		}
		return null;
	}
	
	/**
	 * Method used to determine if a showID exists inside the linked-list.
	 * @param showID String used to represent a unique show.
	 * @return a boolean value based on whether it does contain the showID or not.
	 */
	public boolean contains(String showID) {
		return (find(showID) != null);
	}
	
	/**
	 * Method used to check equality of two ShowLists
	 * @param other ShowList object used for comparison
	 * @return a boolean value which states the equality
	 */
	public boolean equals(ShowList other) {
		if (other == null) return false;
		if (other == this) return true;
		
		ShowNode position = head;
		ShowNode next = position.link;
		ShowNode otherPos = other.head;
		ShowNode otherNext = otherPos.link;
		
		for (int i = 0; i < size; i++) {
			if (position.show.equals(otherPos.show)) {
				position = next;
				next = position.link;
				otherPos = otherNext;
				otherNext = otherPos.link;
			} else
				return false;
		}
		return true;
	}
	
	/**
	 * An inner-class used for the node of the linked-list
	 * @author Muher
	 * Has a private Show object to act as the values of the node and a private ShowNode object as a pointer for the node.
	 */
	public class ShowNode{
		private Show show;
		private ShowNode link;
		
		/**
		 * Default constructor
		 */
		public ShowNode(){
			this.show = null;
			this.link = null;
		}
		
		/**
		 * Constructor that takes parameters and assigns to instance variables
		 * @param show Show object to assign
		 * @param link ShowNode object to assign
		 */
		public ShowNode(Show show, ShowNode link) {
			this.show = show;
			this.link = link;
		}
		
		/**
		 * Copy constructor
		 * @param other Another ShowNode object used for copying
		 */
		public ShowNode(ShowNode other) {
			this.show = other.show;
			this.link = other.link;
		}
		
		/**
		 * Clone method
		 */
		public ShowNode clone() {
			return new ShowNode(this);
		}
		
		/**
		 * Accesors and mutators
		 * @return varies
		 */
		public Show getShow() {
			return show;
		}

		public void setShow(Show show) {
			this.show = show;
		}

		public ShowNode getLink() {
			return link;
		}

		public void setLink(ShowNode link) {
			this.link = link;
		}
	}
}
