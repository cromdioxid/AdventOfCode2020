package day1;

import java.util.HashSet;
import java.util.List;

import main.ReadFromFile;

public class Day1 {
	private String inputFile = "inputs/day1/input.txt";
	
	public HashSet<Integer> processInput(List<String> input) {
		HashSet<Integer> result = new HashSet<Integer>();
		for (String s : input) {
			int val = Integer.parseInt(s);
			result.add(val);
		}
		
		return result;
	}
	
	public int solution() {
		return solution(inputFile);
	}
	
	public int solution(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		HashSet<Integer> values = processInput(input);
		
		for (Integer val : values) {
			int complement = 2020 - val;
			@SuppressWarnings("unchecked")
			HashSet<Integer> newValues = (HashSet<Integer>) values.clone();
			newValues.remove(val);
			int[] pair = searchPair(newValues, complement);
			if (pair[0] != -1 && pair[1] != -1) {
				return val * pair[0] * pair[1];
			}
		}
		
		return 0;
	}
	
	public int[] searchPair(HashSet<Integer> values, int sum) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		for (Integer val : values) {
			int complement = sum - val;
			if (values.contains(complement)) {
				result[0] = val;
				result[1] = complement;
			}
		}
		
		return result;
	}

}
