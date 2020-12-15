package day12;

import java.util.List;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day12 {
	private static String file = "inputs/day12/input.txt";
	
	public List<Instruction> processInput(String file) {
		List<String> input = ReadFromFile.readLines(file);
		List<Instruction> result = input.stream().map(s -> new Instruction(s)).collect(Collectors.toList());
		return result;
	}
	
	public int solution() {
		return solution(file);
	}
	
	public int solution(String file) {
		List<Instruction> input = processInput(file);
		Ship ship = new Ship();
		input.stream().forEach(i -> ship.move(i));
		
		int result = Math.abs(ship.getX()) + Math.abs(ship.getY());
		return result;
	}

}
