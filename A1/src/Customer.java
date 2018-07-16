// -----------------------------------------------------
// Assignment 1
// Written by: Muherthan Thalayasingam - 27223064
// ----------------------------------------------------- 
import java.util.Scanner;
/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #1 <p>
 * Due 15/07/18 <p>
 * The program acts a a simple customer database management system. It first prompts the user for how many customers will be in the
 * database, then allows the user to add and modify customers as well as search for queries based on customer's information.
 * <p>
 * A customer name, street number, street name, and city. 
 * */
public class Customer {
	private String name;
	private int streetNumber;
	private String streetName;
	private String city;
	static int count;
	
	/** 
	 * Constructor method for the class
	 * @param name Initial customer name
	 * @param streetNumber Initial number for the street
	 * @param streetName Initial name for the street
	 * @param city Initial name for the city
	 */
	public Customer(String name, int streetNumber, String streetName, String city) {
		this.name = name;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		Customer.count++;
	}
	
	/**
	 * Accessor method for the customer name
	 * @return the customer name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Mutator method for the customer name
	 * @param name Sets new name for the customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Accessor method for the customer street number
	 * @return the customer's street number
	 */
	public int getStreetNumber() {
		return this.streetNumber;
	}
	
	/**
	 * Mutator method for the customer street number
	 * @param name Sets new street number for the customer
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	/**
	 * Accessor method for the customer street name
	 * @return the customer's street name
	 */
	public String getStreetName() {
		return this.streetName;
	}
	
	/**
	 * Mutator method for the customer street name
	 * @param name Sets new street name for the customer
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	/**
	 * Accessor method for the customer city
	 * @return the customer's city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Mutator method for the customer's city
	 * @param name Sets new city for the customer
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Method used to print the customer information
	 * @return name, streetNumber, streetName, and city
	 */
	public String toString() {
		return "Name: " + this.name + "\nStreet Number: " + this.streetNumber + "\nStreet Name: " + this.streetName + "\nCity: " + this.city;
	}
	
	/**
	 * Static method used to find the total number of customers created
	 * @return count
	 */
	static int findNumberOfCreatedCustomers() {
		return Customer.count;
	}
	
	/**
	 * Method takes in a Customer object and compares it to the current Customer object
	 * @param a Other customer object
	 * @return boolean value based on equality of streetName and city
	 */
	public boolean equals(Customer a) {
		return this.streetName.equals(a.streetName) && this.city.equals(a.city);
	}
	
	
	/**
	 * Driver class used to write the customer management program
	 * @param args
	 */
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		final String PASSWORD = "password";
		int attempts = 0;
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------- Welcome to the Muher Customer Management Program ---------");
		System.out.println("--------------------------------------------------------------------\n");
		System.out.print("What is the maximum number of customers the company can handle? ");
		
		// Prompts user for the capacity for the database and then creates the database for the appropriate size
		int capacity = input.nextInt();
		input.nextLine();
		Customer[] userDatabase = new Customer[capacity];
		System.out.println();
		
		// While loop continues until the user selects the 5th option, in which case it will end
		boolean end = false;
		while(!end) {
			System.out.println("What do you want to do?");
			System.out.println("\t1. Enter new customer (password required)");
			System.out.println("\t2. Change information of a customer (password required)");
			System.out.println("\t3. Display all customers residing on the street name");
			System.out.println("\t4. Display all customers residing in the same city");
			System.out.println("\t5. Quit");
			System.out.print("Please enter your choice > ");
			int choice = input.nextInt();
			
			// Ensures the user will select a valid option
			while (choice < 1 || choice > 5) {
				System.out.print("Please enter a valid choice > ");
				choice = input.nextInt();
			}
			
			// Switch case used for the 5 different options
			switch (choice) {
			case 1: 
				// Keeps track of the # of outer loops attempted for the password
				boolean pwdConfirmed = false;
				while (attempts < 4) {
					System.out.print("Please enter your password: ");
					String password = input.next();
					int passwordCount = 1;
					// Allows users to try 3 times before it exits this inner loop
					while (!password.equals(PASSWORD) && passwordCount < 3) {
						passwordCount++;
						System.out.print("Incorrect: Please enter your correct password. (" + (4-passwordCount) + " attempts remaining): ");
						password = input.next();
					}
					System.out.println();
					attempts++;

					// Exits the program if the outer loop was executed 4 times and the user still failed to provide the correct password
					if (attempts == 4) {
						System.out.println("Program detected suspicious activities and will terminate immediately.");
						System.exit(0);
					}
					choice = 0;
					// Breaks loop if password is entered correctly or if the choice is no longer 1
					if (password.equals(PASSWORD)) {
						pwdConfirmed = true;
						break;
					} else if (choice != 1) {
						break;
					}
				}
				
				if (pwdConfirmed == true) {
					// Once password is correctly entered, proceeds to prompt user for the # of customers to enter
					System.out.print("How many customers do you want to enter? ");
					int customerNumber = input.nextInt();
					input.nextLine();
					// Ensures that the requested number is possible, otherwise tells user how many customers may still be added
					if (capacity - Customer.findNumberOfCreatedCustomers() - customerNumber >= 0) {
						int index = Customer.findNumberOfCreatedCustomers();
						// Adds customer to database (i.e. the array)
						for(int i = 0; i < customerNumber; i++) {
							System.out.print("Name: ");
							String name = input.nextLine();
							System.out.print("Street number: ");
							int streetNumber = input.nextInt();
							input.nextLine();
							System.out.print("Street name: ");
							String streetName = input.nextLine();
							System.out.print("City: ");
							String city = input.nextLine();
							userDatabase[index + i] = new Customer(name, streetNumber, streetName, city);
						}
					} else {
						System.out.println("You may only add " + (capacity - Customer.findNumberOfCreatedCustomers()) + " customers.\n");
						break;
					}
					
					// Prints customers information once added
					for (int i = 0; i < Customer.findNumberOfCreatedCustomers(); i++) {
						System.out.println(userDatabase[i] +"\n");
					}
				}
				break;
			case 2:
				// Prompts for password and allows user 3 tries before it breaks the loop
				System.out.print("Please enter your password: ");
				String password = input.next();
				String answer = "y";
				int passwordCount = 1;
				while (!password.equals(PASSWORD) && passwordCount < 3) {
					passwordCount++;
					System.out.print("Incorrect: Please enter your correct password. (" + (4-passwordCount) + " attempts remaining): ");
					password = input.next();
				}
				System.out.println();
				if (passwordCount == 3) 
					break;
				// If password is correct, it will allow user to edit customer information
				else if (password.equals(PASSWORD)) {
					int numberOfCustomers = Customer.findNumberOfCreatedCustomers();
					System.out.print("Which customer do you wish to update? (Starts at 1): ");
					int customer = input.nextInt();
					input.nextLine();
					// Prevents the user from editing customers that are not within the database, allows user to try again or exit
					while (customer > numberOfCustomers || customer <= 0) {
						System.out.print("There is no such customer, would you like to re-enter the customer? Enter 'Y' to try again: ");
						answer = input.next();
						if (answer.equalsIgnoreCase("y")) {
							System.out.print("Which customer do you wish to update? (Starts at 1): ");
							customer = input.nextInt();
							input.nextLine();
						} else
							break;
					}
					System.out.println();
					if (!answer.equalsIgnoreCase("y"))
						break;
					// Prints the current information of the desired customer 
					System.out.println("Customer: #" + customer);
					System.out.println(userDatabase[customer-1]);
					System.out.println();
					
					// Prints the option to let user decide what to edit
					int changeOption = 0;
					while (changeOption != 5) {
						System.out.println("What information would you like to change?");
						System.out.println("\t1. Customer name");
						System.out.println("\t2. Street number");
						System.out.println("\t3. Street name");
						System.out.println("\t4. City");
						System.out.println("\t5. Quit");
						System.out.print("Please enter your choice > ");
						changeOption = input.nextInt();
						input.nextLine();
						
						// Depending on choice, edits the desired customer information and then prints them
						switch(changeOption) {
						case 1:
							System.out.print("New name: ");
							String newName = input.nextLine();
							userDatabase[customer-1].setName(newName);
							System.out.println(userDatabase[customer-1]+"\n");
							break;
						case 2:
							System.out.print("New street number: ");
							int newStreetNum = input.nextInt();
							input.nextLine();
							userDatabase[customer-1].setStreetNumber(newStreetNum);
							System.out.println(userDatabase[customer-1]+"\n");
							break;
						case 3:
							System.out.print("New street name: ");
							String newStreetName = input.nextLine();
							userDatabase[customer-1].setStreetName(newStreetName);
							System.out.println(userDatabase[customer-1]+"\n");
							break;
						case 4:
							System.out.print("New city: ");
							String newCity = input.nextLine();
							userDatabase[customer-1].setCity(newCity);
							System.out.println(userDatabase[customer-1]+"\n");
							break;
						}
					}
					System.out.println();
				}
				break;
			case 3:
				// Prompts user to enter the street name, then returns all customers in the database with the street name
				System.out.print("Please enter the name of the street: ");
				String street = input.next();
				if (Customer.findNumberOfCreatedCustomers() > 0) {
					for (int i = 0; i < Customer.findNumberOfCreatedCustomers(); i++) {
						if(userDatabase[i].streetName.equals(street)) {
							System.out.println(userDatabase[i].name);
						}
					}
					System.out.println();
				} else
					System.out.println("There are no customers who live on this street.\n");
				break;
			case 4:
				// Prompts user to enter the city name, then returns all customers in the database with the city name
				System.out.print("Please enter the name of the city: ");
				String city = input.next();
				if (Customer.findNumberOfCreatedCustomers() > 0) {
					for (int i = 0; i < Customer.findNumberOfCreatedCustomers(); i++) {
						if(userDatabase[i].city.equals(city)) {
							System.out.println(userDatabase[i].name);
						}
					}
					System.out.println();
				} else
					System.out.println("There are no customers who live in this city.\n");
				break;
			case 5:
				// Exits the program when the 5th option is selected
				System.out.println("\nThanks for using the Customer Management Program. Good bye.");
				end = true;
				System.exit(0);
			}
		}
		input.close();
	}
}