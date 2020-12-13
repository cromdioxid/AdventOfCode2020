package day5;

import java.util.ArrayList;
import java.util.List;

import main.ReadFromFile;

public class Day5 {
	
	private String inputFile = "inputs/day5/input.txt";
	
	public int solution() {
		return solution(inputFile);
	}
	
	public int solution(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		List<Integer> ids = new ArrayList<Integer>();
		for (String s : input) {
			BoardingPass pass = new BoardingPass(s);
//			if (pass.getId() > max) {
//				max = pass.getId();
//			}
			int pos = searchPosition(ids, pass.getId(), 0, ids.size());
			ids.add(pos, pass.getId());
		}
		for (int i = 0; i < ids.size() - 1; i++) {
			if (ids.get(i) + 1 != ids.get(i + 1)) {
				return ids.get(i) + 1;
			}
		}
		return -1;
	}
	
	
	public int searchPosition(List<Integer> list, int value, int start, int end) {
		if (list.size() == 0) {
			return 0;
		}
		int m = (start + end) / 2;
		if (list.get(m) == value) {
			return m;
		}
		if (start == end) {
			if (list.get(start) > value) {
				return start;
			} else {
				return start + 1;
			}
		} else if (start + 1 == end) {
			if (value < list.get(start)) {
				return start;
			} else {
				return start + 1;
			}
		} else {
			if (value < list.get(m)) {
				return searchPosition(list, value, start, m);
			} else {
				return searchPosition(list, value, m, end);
			}
		}
		
	}
	
}
