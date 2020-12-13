package day3;

import java.util.List;

import main.ReadFromFile;

public class Day3 {
	private String inputFile = "inputs/day3/input.txt";
	
	public long solution() {
		return solution(inputFile);
	}
	
	public long solution(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		return (long)(checkSlope(input, 1, 1)) 
				* checkSlope(input, 3, 1)
				* checkSlope(input, 5, 1)
				* checkSlope(input, 7, 1)
				* checkSlope(input, 1, 2);
	}
	
	public int checkSlope(List<String> input, int moveRight, int moveDown) {
		int i = 0;
		int j = 0;
		int result = 0;
		int lineSize = input.get(0).length();
		
		while(i < input.size()) {
			String line = input.get(i);
			char c = line.charAt(j);
			if (c == '#') {
				result++;
			}
			i += moveDown;
			j = (j + moveRight) % lineSize;
		}
		
		return result;
	}

}
