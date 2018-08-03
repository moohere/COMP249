import java.io.File;

/**
 * This is the class for InvalidFileException, an exception thrown if a file is invalid or if the file paths are invalid.
 * @author Muher
 */
public class InvalidFileException extends Exception{	
	public InvalidFileException(String fileName, String msg) {
		super(msg);
		System.out.println("Error: Input file named " + fileName + " cannot be found.");
	}
	
	public InvalidFileException() {
		super();
	}
}
