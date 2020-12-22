package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day15 {
	private static String file = "inputs/day15/input.txt";
	
	private int nr = 30000000;
	
	private HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	public List<Integer> processInput(String file) {
		List<String> input = ReadFromFile.readLines(file);
		String[] values = input.get(0).split(",");
		List<Integer> result = Arrays.stream(values).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		
		return result;
	}
	
	public int solution() {
		return solution(file, nr);
	}
	
	public int solution(String file, int nr) {
		List<Integer> input = processInput(file);
		int currNumber = 0;
		int i = 0;
		while(i < input.size()) {
			currNumber = input.get(i);
			addToMap(i, currNumber);
			i++;
		}
		while(i < nr) {
			List<Integer> currIndices = map.get(currNumber);
			if (currIndices.size() == 1) {
				currNumber = 0;
			} else {
				currNumber = currIndices.get(1) - currIndices.get(0);
			}
			addToMap(i, currNumber);
			i++;
		}
		return currNumber;
	}
	
	public void addToMap(int index, int val) {
		List<Integer> indices = map.get(val);
		if (indices == null) {
			indices = new ArrayList<Integer>();
		} else {
			if (indices.size() == 2) {
				indices.remove(0);
			}
		}
		indices.add(index);
		map.put(val, indices);
	}

}
