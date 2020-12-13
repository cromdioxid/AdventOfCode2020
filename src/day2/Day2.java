package day2;

import java.util.List;

import main.ReadFromFile;

public class Day2 {
	
	private String inputFile = "inputs/day2/input.txt";
	
	public int solution() {
		return solution(inputFile);
	}
	
	public int solution(String fileName) {
		int valid = 0;
		List<String> input = ReadFromFile.readLines(fileName);
		for (String s : input) {
			PasswordPolicy pass = new PasswordPolicy(s);
			if (pass.isValid()) {
				valid++;
			}
		}
		return valid;
	}

}
