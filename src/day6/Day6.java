package day6;

import java.util.HashMap;
import java.util.List;

import main.ReadFromFile;

public class Day6 {
	
	private String fileName = "inputs/day6/input.txt";
	
	public int solution() {
		return solution(fileName);
	}
	
	public int solution(String fileName) {
		int result = 0;
		List<String> input = ReadFromFile.readLines(fileName);
		HashMap<Character, Integer> answers = new HashMap<Character, Integer>();
		int pers = 0;
		for (String line : input) {
			if (line.equals("")) {
				for (char c : answers.keySet()) {
					if (answers.get(c) == pers) {
						result++;
					}
				}
				answers = new HashMap<Character, Integer>();
				pers = 0;
			} else {
				for(int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (answers.get(c) == null) {
						answers.put(c, 1);
					} else {
						int val = answers.get(c);
						val++;
						answers.put(c, val);
					}
				}
				pers++;
			}
		}
		for (char c : answers.keySet()) {
			if (answers.get(c) == pers) {
				result++;
			}
		}
		
		return result;
	}

}
