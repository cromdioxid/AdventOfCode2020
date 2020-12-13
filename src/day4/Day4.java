package day4;

import java.util.List;

import main.ReadFromFile;

public class Day4 {
	
	private String inputFile = "inputs/day4/input.txt";
	
	public List<String> processInput(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		return input;
	}
	
	public int solution() {
		return solution(inputFile);
	}
	
	public int solution(String fileName) {
		List<String> input = processInput(fileName);
		int result = 0;
		Passport p = new Passport();
		for(int i = 0; i < input.size(); i++) {
			if (!input.get(i).equals("") && !input.get(i).equals("\n")
					&& !input.get(i).equals("\s")) {
				String line = input.get(i);
				String[] elems = line.split(" ");
				for (String elem : elems) {
					String[] e = elem.split(":");
					if (e.length == 2) {
						p.addField(e[0], e[1]);
					}
				}
			} else {
				if (p.isValid()) {
					result++;
				}
				p = new Passport();
			}
		}
		if (p.isValid()) {
			result++;
		}
		return result;
	}
	

}
