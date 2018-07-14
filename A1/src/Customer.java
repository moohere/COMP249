import java.util.Scanner;

public class Customer {
	private String name;
	private int streetNumber;
	private String streetName;
	private String city;
	static int count;
	
	public Customer(String name, int streetNumber, String streetName, String city) {
		this.name = name;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		Customer.count++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStreetNumber() {
		return this.streetNumber;
	}
	
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getStreetName() {
		return this.streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		return "Name: " + this.name + "\nStreet Number: " + this.streetNumber + "\nStreet Name: " + this.streetName + "\nCity: " + this.city;
	}
	
	static int findNumberOfCreatedCustomers() {
		return Customer.count;
	}
	
	public boolean equals(Customer a) {
		return this.name == a.name && this.streetNumber == a.streetNumber 
				&& this.streetName == a.streetName && this.city == a.city;
	}
	
	
	//Driver class
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		final String PASSWORD = "password";
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------- Welcome to the Customer Management Program ---------");
		System.out.println("--------------------------------------------------------------\n");
		System.out.print("What is the maximum number of customers the company can handle? ");
		int capacity = input.nextInt();
		input.nextLine();
		Customer[] userDatabase = new Customer[capacity];
		System.out.println();
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
			
			while (choice < 1 || choice > 5) {
				System.out.print("Please enter a valid choice > ");
				choice = input.nextInt();
			}
			
			switch (choice) {
			case 1: 
				int attempts = 0;
				while (attempts < 4) {
					System.out.print("Please enter your password: ");
					String password = input.next();
					int passwordCount = 1;
					while (!password.equals(PASSWORD) && passwordCount < 3) {
						passwordCount++;
						System.out.print("Incorrect: Please enter your correct password. (" + (4-passwordCount) + " attempts remaining): ");
						password = input.next();
					}
					if (password.equals(PASSWORD))
						break;
					
					attempts++;
					if (passwordCount == 3 && attempts < 4) {
						System.out.println("What do you want to do?");
						System.out.println("\t1. Enter new customer (password required)");
						System.out.println("\t2. Change information of a customer (password required)");
						System.out.println("\t3. Display all customers residing on the street name");
						System.out.println("\t4. Display all customers residing in the same city");
						System.out.println("\t5. Quit");
						System.out.print("Please enter your choice > ");
						choice = input.nextInt();
						
						while (choice < 1 || choice > 5) {
							System.out.print("Please enter a valid choice > ");
							choice = input.nextInt();
						}
					}
				}
				if (attempts == 4) {
					System.out.println("Program detected suspicious activities and will terminate immediately.");
					System.exit(0);
				}
				
				System.out.print("How many customers do you want to enter? ");
				int customerNumber = input.nextInt();
				input.nextLine();
				if (capacity - Customer.findNumberOfCreatedCustomers() - customerNumber >= 0) {
					int index = Customer.findNumberOfCreatedCustomers();
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
					System.out.println("You may only add " + (capacity - Customer.findNumberOfCreatedCustomers()) + " customers.");
					break;
				}
				
				for (int i = 0; i < Customer.findNumberOfCreatedCustomers(); i++) {
					System.out.println(userDatabase[i]);
				}
				break;
			case 3:
				System.out.print("Please enter the name of the street: ");
				String street = input.nextLine();
				if (Customer.findNumberOfCreatedCustomers() > 0) {
					for (int i = 0; i < Customer.findNumberOfCreatedCustomers(); i++) {
						if(userDatabase[i].streetName.equals(street)) {
							System.out.println(userDatabase[i].name);
						}
					}
				} else
					System.out.println("There are no customers.");
				break;
			case 2:
				System.out.print("Please enter your password: ");
				String password = input.next();
				String answer = "y";
				int passwordCount = 1;
				while (!password.equals(PASSWORD) && passwordCount < 3) {
					passwordCount++;
					System.out.print("Incorrect: Please enter your correct password. (" + (4-passwordCount) + " attempts remaining): ");
					password = input.next();
				}
				if (passwordCount == 3) 
					break;
				else if (password.equals(PASSWORD)) {
					int numberOfCustomers = Customer.findNumberOfCreatedCustomers();
					System.out.print("Which customer do you wish to update? ");
					int customer = input.nextInt();
					input.nextLine();
				
					while (customer > numberOfCustomers || customer <= 0) {
						System.out.print("There is no such customer, would you like to re-enter the customer? Enter 'Y' to try again: ");
						answer = input.next();
						if (answer.equalsIgnoreCase("y")) {
							System.out.print("Which customer do you wish to update? ");
							customer = input.nextInt();
							input.nextLine();
						} else
							break;
					}
					if (!answer.equalsIgnoreCase("y"))
						break;
					System.out.println("Customer: #" + customer);
					System.out.println(userDatabase[customer-1]);
					System.out.println();
					
					int changeOption = 0;
					while (changeOption != 5) {
						System.out.println("What information would you like to change?");
						System.out.println("\t1. Customer name");
						System.out.println("\t2. Street number");
						System.out.println("\t3. Street name");
						System.out.println("\t4. City");
						System.out.println("\t5. Quit");
						System.out.println("Please enter your choice >");
						changeOption = input.nextInt();
						input.nextLine();
						
						switch(changeOption) {
						case 1:
							System.out.print("New name: ");
							String newName = input.nextLine();
							userDatabase[customer-1].setName(newName);
							System.out.println(userDatabase[customer-1]);
							break;
						case 2:
							System.out.print("New street number: ");
							int newStreetNum = input.nextInt();
							input.nextLine();
							userDatabase[customer-1].setStreetNumber(newStreetNum);
							System.out.println(userDatabase[customer-1]);
							break;
						case 3:
							System.out.print("New street name: ");
							String newStreetName = input.nextLine();
							userDatabase[customer-1].setStreetName(newStreetName);
							System.out.println(userDatabase[customer-1]);
							break;
						case 4:
							System.out.print("New city: ");
							String newCity = input.nextLine();
							userDatabase[customer-1].setCity(newCity);
							System.out.println(userDatabase[customer-1]);
							break;
						}
					}
				}
				break;
			case 4:
				System.out.print("Please enter the name of the city: ");
				String city = input.next();
				if (Customer.findNumberOfCreatedCustomers() > 0) {
					for (int i = 0; i < Customer.findNumberOfCreatedCustomers(); i++) {
						if(userDatabase[i].city.equals(city)) {
							System.out.println(userDatabase[i].name);
						}
					}
				} else
					System.out.println("There are no customers.");
				break;
			case 5:
				System.out.println("Thanks for using the Customer Management Program. Good bye.");
				end = true;
				System.exit(0);
			}
		}
	}
}