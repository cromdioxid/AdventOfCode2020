package day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day19 {
	private static String characterRegex = "\"([\\w])\"";
	private static String file = "inputs/day19/input.txt";
	
	private HashMap<Integer, String> rules = new HashMap<Integer, String>();
	private List<String> strings = new ArrayList<String>();
	
	public void parseInput(String file) {
		List<String> input = ReadFromFile.readLines(file);
		int i = 0;
		while(i < input.size() && !input.get(i).equals("")) {
			rules.put(Integer.valueOf(input.get(i).split(": ")[0]), input.get(i).split(": ")[1]);
			i++;
		}
		i++;
		while(i < input.size()) {
			strings.add(input.get(i));
			i++;
		}
	}
	
	public long solution() {
		return solution(file);
	}
	
	public long solution(String file) {
		parseInput(file);
		List<String> list = expandRule(0).getAllRules();
		return strings.stream().filter(s -> list.contains(s)).count();
	}
	
	public Rule expandRule(int nr) {
		String rule = rules.get(nr);
		Pattern p = Pattern.compile(characterRegex);
		Matcher m = p.matcher(rule);
		if (m.matches()) {
			List<String> result = new ArrayList<String>();
			result.add(m.group(1));
			return new Rule(result);
		} else {
			String[] parts = rule.split(" \\| ");
			if (parts.length == 2)  {
				String left = parts[0];
				String right = parts[1];
				Rule rLeft = processRule(left);
				Rule rRight = processRule(right);
				return new Rule(rLeft.getAllRules(), rRight.getAllRules());
			} else {
				String left = parts[0];
				Rule r = processRule(left);
				return new Rule(r.getAllRules());
			}
			
		}
	}
	
	public Rule processRule(String part) {
		String[] parts = part.split(" ");
		List<Rule> rulesList = Arrays.stream(parts).map(s -> Integer.valueOf(s))
				.map(x -> expandRule(x)).collect(Collectors.toList());
		Rule result = rulesList.get(0);
		for (int i = 1; i < rulesList.size(); i++) {
			List<List<String>> rules1 = result.getRulesAsLists();
			List<List<String>> rules2 = rulesList.get(i).getRulesAsLists();
			List<String> newResult = new ArrayList<String>();
			for (List<String> l1 : rules1) {
				for(List<String> l2 : rules2) {
					for(String s1 : l1) {
						for(String s2: l2) {
							newResult.add(s1 + s2);
						}
					}
				}
			}
			result = new Rule(newResult);
		}
		return result;
	
	}
	

}
