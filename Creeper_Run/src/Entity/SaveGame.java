package Entity;

import java.io.*;

/*
 * This will read player info from the savegame.txt file
 * 
 * Eventually it will be able to choose between save files
 */

/** JDK 6 or before. */
public class SaveGame {

  /**
  * Fetch the entire contents of a text file, and return it in a String.
  * This style of implementation does not throw Exceptions to the caller.
  *
  * @param aFile is a file which already exists and can be read.
  */
  static public String Read(File aFile) {
    //...checks on aFile are eluded
    StringBuilder contents = new StringBuilder();
    
    try {
      //use buffering, reading one line at a time
      //FileReader always assumes default encoding is OK!
      BufferedReader input =  new BufferedReader(new FileReader(aFile));
      try {
        String line = null; //not declared within while loop
        /*
        * readLine is a bit quirky :
        * it returns the content of a line MINUS the newline.
        * it returns null only for the END of the stream.
        * it returns an empty String if two newlines appear in a row.
        */
        while (( line = input.readLine()) != null){
          contents.append(line);
          contents.append(System.getProperty("line.separator"));
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    
    return contents.toString();
  }

  /**
  * Change the contents of text file in its entirety, overwriting any
  * existing text.
  *
  * This style of implementation throws all exceptions to the caller.
  *
  * @param aFile is an existing file which can be written to.
  * @throws IllegalArgumentException if param does not comply.
  * @throws FileNotFoundException if the file does not exist.
  * @throws IOException if problem encountered during write.
  */
  static public void Write(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    //These lines just catch various errors
	if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }

    //use buffering
    Writer output = new BufferedWriter(new FileWriter(aFile));
    try {
      //FileWriter always assumes default encoding is OK!
      output.write( aContents );
    }
    finally {
      output.close();
    }
  }

  /** Simple test harness.   */
  public static void init(String... aArguments) throws IOException {
	
	 /*
	  * Starting stats
	int a = NewPlayerSaveInfo.getLives();
	int b = NewPlayerSaveInfo.getHealth();
	long c = NewPlayerSaveInfo.getTime();
	*/
	
	String lives = Integer.toString(a);
	String health = Integer.toString(b);
	String time = Long.toString(c);
	String info = (lives + health + time);
	
    File testFile = new File("test.txt");
    final String input = Read(testFile);
    System.out.println("Original file contents: " + Read(testFile));
    Write(testFile, info);
    System.out.println("New file contents: " + Read(testFile));
  }
} 