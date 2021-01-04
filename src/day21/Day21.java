package day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.ReadFromFile;

public class Day21 {
	private static String file = "inputs/day21/input.txt";
	
	private HashMap<String, List<List<String>>> ingredients = new HashMap<String, List<List<String>>>();
	private HashMap<String, List<String>> alergensToIngredients = new HashMap<String, List<String>>();
	private Set<String> identifiedIngredients = new HashSet<String>();
	private List<String> allIngredients = new ArrayList<String>();
 	
	public void parseInput(String file) {
		List<String> input = ReadFromFile.readLines(file);
		for (String line : input) {
			parseLine(line);
		}
	}
	
	public long solution() {
		return solution(file);
	}
	
	public long solution(String file) {
		parseInput(file);
		identifyIngredients();
		return allIngredients.stream().filter(i -> !identifiedIngredients.contains(i)).count();
	}
	public void parseLine(String line) {
		List<String> ingredientsPerLine = Arrays.asList(line.split(" \\(contains ")[0].split(" "));
		allIngredients.addAll(ingredientsPerLine);
		List<String> alergens = Arrays.asList(line.split(" \\(contains ")[1].substring(0, line.split(" \\(contains ")[1].length() - 1)
				.split(", "));
		for (String alergen : alergens) {
			List<List<String>> result = ingredients.get(alergen);
			if (result == null) {
				result = new ArrayList<List<String>>();
			}
			result.add(ingredientsPerLine);
			ingredients.put(alergen, result);
		}
	}
	
	public void identifyIngredients() {
		for (String key : ingredients.keySet()) {
			HashMap<String, Integer> count = new HashMap<String, Integer>();
			for (List<String> list : ingredients.get(key)) {
				for (String e : list) {
					Integer value = count.get(e);
					if (value == null) {
						value = 1;
					} else {
						value++;
					}
					count.put(e,  value);
				}
			}
			for (String ing : count.keySet()) {
				if (count.get(ing) == ingredients.get(key).size()) {
					List<String> ings = alergensToIngredients.get(key);
					if (ings == null) {
						ings = new ArrayList<String>();
					}
					ings.add(ing);
					alergensToIngredients.put(key, ings);
					identifiedIngredients.add(ing);
				}
			}
		}
	}

}
