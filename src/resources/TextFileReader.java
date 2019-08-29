package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TextFileReader
{
	private File file;
	private BufferedReader reader;
	
	public TextFileReader(String filename)
	{
		try
		{
			file = new File(filename);
			reader = new BufferedReader(new FileReader(file));
		}
		catch(Exception e)
		{
			System.out.println("Error reading file: " + filename);
			e.printStackTrace();
		}
	}
	
	public TextFileReader(File f)
	{
		file = f;
		try
		{
			reader = new BufferedReader(new FileReader(file));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error reading file: " + file.getAbsolutePath() + file.getName());
		}
	}
	
	/**
	 * This method returns the next line of data from the text file. It will return
	 * null if you have reached the end of the file, so be sure to check for null.
	 * @return next line from text file or null if there are no more lines
	 */
	public String nextLine()
	{
		try
		{
			return reader.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
