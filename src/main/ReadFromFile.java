package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
	
	public static List<String> readLines(String fileName) {
		List<String> result = new ArrayList<String>();
		
		File file = new File(fileName);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			String line = "";
			line = buff.readLine();
			while(line != null) {
				result.add(line);
				line = buff.readLine();
			}
			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
