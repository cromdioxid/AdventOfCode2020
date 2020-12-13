package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day10 {
	private String file = "inputs/day10/input.txt";
	
	public int solution() {
		return solution(file);
	}
	
	public int solution(String fileName) {
		List<Integer> input = processInput(fileName);
		input = sortList(input);
		int[] diff = new int[input.size()];
		int prev = 0;
		int result = 1;
		for (int i = 0; i < input.size(); i++) {
			diff[i] = prev - input.get(i);
			prev = input.get(i);
		}
		
		return result;
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
