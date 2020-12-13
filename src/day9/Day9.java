package day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import main.ReadFromFile;

public class Day9 {
	private int pre = 25;
	private String inputFile = "inputs/day9/input.txt";
	
	public Long solution() {
		return solution(inputFile, pre);
	}

	public Long solution(String fileName, int pre) {
		List<String> input = ReadFromFile.readLines(fileName);
		List<Long> longInput = convertInput(input);
		Long value = getValue(longInput, pre);
		int[] pos = getArray(value, longInput);
		Long sum = getMinMaxSum(longInput, pos);
		
		return sum;
	}
	
	public Long getValue(List<Long> input, int pre) {
		for (int i = 0; i < input.size() - pre;i++) {
			if(!testValidValue(i, pre, input)) {
				return input.get(i + pre);
			}
		}
		return -1L;
	}
	
	public Long getMinMaxSum(List<Long> input, int[] pos) {
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for (int i = pos[0]; i < pos[1]; i++) {
			if (input.get(i) > max) {
				max = input.get(i);
			}
			if (input.get(i) < min) {
				min = input.get(i);
			}
		}
		return min + max;
	}
	
	public List<Long> convertInput(List<String> input) {
		List<Long> result = new ArrayList<Long>();
		for (String i : input) {
			result.add(Long.valueOf(i));
		}
		return result;
	}
	
	public boolean testValidValue(int start, int pre, List<Long> input) {
		HashSet<Long> set = new HashSet<Long>();
		int length = start + pre;
		long value = input.get(length);
		for (int i = start; i < length; i++) {
			long curr = input.get(i);
			long complement = value - curr;
			if (set.contains(complement)) {
				return true;
			}
			set.add(curr);
		}
		
		return false;
	}
	
	public int[] getArray(long val, List<Long> input) {
		int[] result = new int[2];
		int n = input.size();
		long[] arr = new long[n];
		int start = 0;
		int stop = 1;
		while(stop < n) {
			for (int i = start; i < stop; i++) {
				arr[i] += input.get(stop-1);
				if(arr[i] == val) {
					result[0] = start;
					result[1] = stop;
					return result;
				} else if(arr[i] > val){
					start++;
				}
			}
			stop++;
		}
		return null;
	}
}
