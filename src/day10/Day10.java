package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day10 {
	private String file = "inputs/day10/input.txt";
	
	public long solution() {
		return solution(file);
	}
	
	public long solution(String fileName) {
		List<Integer> input = processInput(fileName);
		input = sortList(input);
		int[] diff = new int[input.size()];
		int prev = 0;
		long result = 1;
		for (int i = 0; i < input.size(); i++) {
			diff[i] = input.get(i) - prev;
			prev = input.get(i);
		}
		int start = -1;
		for (int end = 0; end < diff.length; end++) {
			if(diff[end] == 3) {
				result *= returnMultiplier(start, end, diff);
				start = end;
			}
		}
		//check also for the last element which
		//might not be 3
		if (diff[diff.length - 1] != 3) {
			result *= returnMultiplier(start, diff.length, diff);
		}
		
		
		return result;
	}
	
	public int returnMultiplier(int start, int end, int[] diff) {
		int a = end-1;
		while(diff[a] == 3) {
			a--;
		}
		if(a - start - 1 == 3) {
			return 7;
		} else if(a - start - 1 == 2) {
			return 4;
		} else if(a - start - 1 == 1) {
			return 2;
		}
		return 1;
	}
	
	public List<Integer> processInput(String fileName) {
		List<String> processInput = ReadFromFile.readLines(fileName);
		List<Integer> result = processInput.stream().map(Integer::valueOf).collect(Collectors.toList());
		
		return result;
	}
	
	public List<Integer> sortList(List<Integer> list) {
		List<Integer> result;
		if (list.size() < 2) {
			return list;
		}
		int m = list.size() / 2;
		List<Integer> leftList = sortList(list.subList(0, m));
		List<Integer> rightList = sortList(list.subList(m, list.size()));
		result = merge(leftList, rightList);
		return result;
	}
	
	public List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
		int pLeft = 0;
		int pRight = 0;
		List<Integer> result = new ArrayList<Integer>();
		while(pLeft < leftList.size() && pRight < rightList.size()) {
			if (leftList.get(pLeft) < rightList.get(pRight)) {
				result.add(leftList.get(pLeft));
				pLeft++;
			} else {
				result.add(rightList.get(pRight));
				pRight++;
			}
		}
		while(pLeft < leftList.size()) {
			result.add(leftList.get(pLeft));
			pLeft++;
		}
		while(pRight < rightList.size()) {
			result.add(rightList.get(pRight));
			pRight++;
		}
		return result;
	}

}
