package resources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileWriter {
	
	public static void write(String filename, ArrayList<String> content) throws IOException{
	  BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));
	  
	  for (int i = 0; i < content.size(); i++) {
		outputWriter.write(content.get(i) + "\r\n"); // writes one line, each on the same line (not a newLine), so add the line break
	  }
	  
	  outputWriter.flush();
	  outputWriter.close();
}
	
	public static void write(String filename, String[] content) throws IOException{
		  BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));
		  
		  for (int i = 0; i < content.length; i++) {
			outputWriter.write(content[i] + "\r\n"); // writes one line, each on the same line (not a newLine)
		  }
		  
		  outputWriter.flush();
		  outputWriter.close();
	}
	
	public static void write(String filename, String content) throws IOException{
		  BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));
		  
		  outputWriter.write(content);

		  outputWriter.flush();
		  outputWriter.close();
	}
	
}
