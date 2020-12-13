package day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.ReadFromFile;

public class Day7 {
	private String inputFile = "inputs/day7/input.txt";
	
	public int solution() {
		return solution(inputFile);
	}
	
	public int solution(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		HashMap<String, List<Tuple>> nodes = new HashMap<String, List<Tuple>>();
		for (String line : input) {
			String[] parts = line.split(" contain ");
			String parent = parts[0];
			parent = parent.split(" bags")[0];
			String[] children = parts[1].split(", ");
			for (String c : children) {
				Pattern p = Pattern.compile("(\\d) (.*) bags*\\.*");
				Matcher m = p.matcher(c);
				if (m.matches()) {
					int count = Integer.valueOf(m.group(1));
					String child = m.group(2);
					Tuple t = new Tuple(count, child);
					List<Tuple> vals = nodes.get(parent);
					if (vals == null) {
						vals = new ArrayList<Tuple>();
					}
					vals.add(t);
					nodes.put(parent, vals);
				}
				
			}
		}
		String s = "shiny gold";
		int result = countBags(nodes, s);
		return result;
			
		
		
	}
	
	public int countBags(HashMap<String, List<Tuple>> nodes, String node) {
		List<Tuple> values = nodes.get(node);
		int result = 0;
		if (values == null) {
			return 0;
		} else {
			for (Tuple t : values) {
				result += t.getCount() + t.getCount() * countBags(nodes, t.getBag());
			}
			return result;
		}

	}
	
	

}
