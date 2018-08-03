// -----------------------------------------------------
// Assignment 3
// Written by: Muherthan Thalayasingam - 27223064
// ----------------------------------------------------- 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #3 <p>
 * Due 03/08/18 <p>
 * This program let's the user create a log with the path of each subdirectory and file within a folder.
 * It then allows the user to process the files and generate webpages to view the jpeg images within each subdirectory.
 * <p>
 */
public class a3 {
	
	/**
	 * A method used to write the path of each file into the log
	 * @param file Takes the directory
	 * @param out The writer
	 * @throws EmptyFolderException
	 * @throws InvalidFileException
	 */
	public static void writeFile(File file, PrintWriter out) throws EmptyFolderException, InvalidFileException {
		File[] fileList = file.listFiles();
		try {
			if (fileList.length == 0) {
				throw new EmptyFolderException(file.getName(), "Try populating the folder first.");
			}
			else {
				// We check if a file is a directory, then write it in the log with directory as a prefix
				// If the file is a file, it is written with a file as a prefix
				for (File aFile: fileList) {
					if (aFile.isDirectory() && aFile.exists()) {
						out.println("directory: " + aFile.getAbsolutePath());
						writeFile(aFile, out);
					} else {	
						try {
							if (aFile.isFile() && aFile.exists()) {
								out.println(" file: " + aFile.getAbsolutePath());
							}
							else throw new InvalidFileException(aFile.getName(), "Check the spelling.");
						} catch (InvalidFileException e) {
							e.printStackTrace();
						} 
					}
				}
			}
		} catch (EmptyFolderException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * A method used to create webpages for each subdirectory
	 * @param file Takes the directory
	 * @param out1 The writer
	 * @throws InvalidFileException
	 */
	public static void html(File file, PrintStream out1) throws InvalidFileException{
		File[] fileList = file.listFiles();
		
		try {
			if (fileList.length == 0) {
				throw new EmptyFolderException(file.getName(), "Try populating the folder first.");
			}
			else {
				int count = 0;
				// We use a counter here to make the rows in blocks of 4.
				// We also use recursion to generate the web pages as well, same concept as above.
				for (File aFile: fileList) {
					if (aFile.isDirectory() && aFile.exists()) {
						out1 = new PrintStream(aFile.getName() +".html");
						out1.println("<html>");
						out1.println("<head>");
						out1.println("<link rel=\"stylesheet\" href=\"assignment3.css\">");
						out1.println("</head>");
						out1.println("<body>");
						out1.println("<div style=\"text-align:center\">");
						out1.println("<h1>Assignment 3</h1>");
						out1.println("</div>");	
						html(aFile, out1);
					} else {	
						try {
							if (aFile.isFile() && aFile.exists()) {
								if (count % 4 == 0) 
									out1.println("<div class=\"row\">");
								out1.println("<div class=\"column\">");
								out1.println("<img src=\"" + (aFile.getAbsolutePath()) + "\">");
								out1.println("</div>");
								count++;
								if (count % 4 == 0) 
									out1.println("</div>");
								
							}
							else throw new InvalidFileException(aFile.getName(), "Check the spelling.");
						} catch (InvalidFileException e) {
							e.printStackTrace();
						} 
					}
				}
				
				out1.println("</body>");
				out1.println("</html>");
			}
		} catch (EmptyFolderException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main driver wherein we have the entire process
	 * @param args
	 * @throws EmptyFolderException
	 * @throws InvalidFileException
	 */
	public static void main(String[] args) throws EmptyFolderException, InvalidFileException{
		File dataFolder = new File("Data");
		PrintWriter out = null;
		PrintStream out1 = null;

		System.out.println("********** Welcome to Muher's Program **********");
		Scanner input = new Scanner(System.in);
		
		System.out.print("What would you like to do?\n\t1 List files\n\t2 Process files\n\t3 Exit\nPlease enter your choice: ");
		int selection = input.nextInt();
		while (selection > 3 || selection < 1) {
			System.out.print("Please try again: ");
			selection = input.nextInt();
		}
		
		// Continues the loop until user exits
		while (selection != 3) {
			switch(selection) {
			
			// First case simply calls the writeFile method
			case 1:
				try {
					if (!dataFolder.exists()) 
						throw new InvalidFileException(dataFolder.getName(), "This won't work.");
					else {
						out = new PrintWriter("log.txt");
						writeFile(dataFolder, out);
					}
				} catch (InvalidFileException e){
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					out.close();
				} 
				System.out.println("The log has been created.\n");
				System.out.print("What would you like to do?\n\t1 List files\n\t2 Process files\n\t3 Exit\nPlease enter your choice: ");
				selection = input.nextInt();
				break;
				
			// Second case creates the CSS file and also calls the html method
			case 2:
				try {		
					if (!dataFolder.exists()) 
						throw new InvalidFileException(dataFolder.getName(), "This won't work.");
					else {
						html(dataFolder, out1);
						out1 = new PrintStream("assignment3.css");
						out1.println("* {");
						out1.println("box-sizing: border-box;");
						out1.println("}");
						out1.println("h1 { color: #d54d7b; font-family: \"Great Vibes\", cursive; font-size: 9vw; line-height: 300px; font-weight: normal; margin-bottom: 0px; margin-top: 10px; text-align: center; text-shadow: 0 1px 1px #fff; }");
						out1.println("body {");
						out1.println("margin: 0;");
						out1.println("font-family: Arial;}");
						out1.println(".column {");
						out1.println("float: left;");
						out1.println("width: 25%;");
						out1.println("padding: 10px;");
						out1.println("}");
						out1.println(".column img {");
						out1.println("opacity: 0.8; ");
						out1.println("cursor: pointer;");
						out1.println("width: 100%;");
						out1.println("}");
						out1.println(".column img:hover {");
						out1.println("opacity: 1;");
						out1.println("}");
						out1.println(".row:after {");
						out1.println("content: \"\";");
						out1.println("display: table;");
						out1.println("clear: both;");
						out1.println("}");
					}
			} catch (InvalidFileException e){
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				out1.close();
			} 
				System.out.println("The webpages have been processed. You may click them to view now.\n");
				System.out.print("What would you like to do?\n\t1 List files\n\t2 Process files\n\t3 Exit\nPlease enter your choice: ");
				selection = input.nextInt();	
				break;
			}
		}
		
		// If the 3rd choice is selected, the program exits.
		if (selection == 3) { 
			if (out != null) out.close();
			if (out1 != null) out1.close();
			System.out.println("\nThanks for using Muher's Program. Goodbye!");
			System.exit(0);
		}
		input.close();
	}
}
