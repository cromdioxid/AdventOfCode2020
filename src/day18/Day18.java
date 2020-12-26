package day18;

import java.util.List;
import java.util.Stack;

import main.ReadFromFile;

public class Day18 {
	private static char PLUS = '+';
	private static char MULTIPLY = '*';
	private static String file = "inputs/day18/input.txt";
	
	public long solution() {
		return solution(file);
	}
	
	public long solution(String file) {
		List<String> input = ReadFromFile.readLines(file);
		long result = input.stream().map(s -> compute(s)).reduce(0L, (a, b) -> a + b);
		
		return result;
	}
	
	public long compute(String exp) {
		Stack<Long> terms = new Stack<Long>();
		Stack<Character> signs = new Stack<Character>();
		int openP = 0;
		int val = 0;
		int i = 0;
		boolean isNr = false;
		while(i < exp.length()) {
			char c = exp.charAt(i);
			if (Character.isDigit(c)) {
				if (isNr) {
					val = val * 10 + (c - '0');
				} else {
					val = c - '0';
					isNr = true;
				}
			} else if (c == PLUS || c == MULTIPLY) {
				if (isNr) {
					terms.push(Long.valueOf(val));
					isNr = false;
				}
				if (c == MULTIPLY) {
					while (signs.size() > 0 && signs.peek() == PLUS) {
						signs.pop();
						terms.push(terms.pop() + terms.pop());
					}
				}
				signs.add(c);
			} else {
				if (c == '(') {
					openP++;
					StringBuilder sb = new StringBuilder();
					i++;
					while(i < exp.length() && openP != 0) {
						c = exp.charAt(i);
						if (c == ')') {
							openP--;
						}
						if (c == '(') {
							openP++;
						}
						sb.append(c);
						i++;
					}
					terms.push(compute(sb.toString()));
				} 
			}
			i++;
		}
		if (isNr) {
			terms.push(Long.valueOf(val));
			isNr= false;
		}
		while(signs.size() > 0) {
			char s = signs.pop();
			if (s == PLUS) {
				terms.push(terms.pop() + terms.pop());
			} else {
				terms.push(terms.pop() * terms.pop());
			}
		}
		
		return terms.pop();
	}

}
