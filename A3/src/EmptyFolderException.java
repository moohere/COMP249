import java.io.File;

/**
 * This is the class for EmptyFolderException, an exception thrown if a directory is empty.
 * @author Muher
 */
public class EmptyFolderException extends Exception{
	public EmptyFolderException(String fileName, String msg) {
		super(msg);
		System.out.println("Error: Folder named " + fileName + " is empty.");
	}
	
	public EmptyFolderException() {
		super();
	}
}
