package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day16 {
	
	private static String intervalRegex = "([a-z ]+): ([\\d]+)-([\\d]+) or ([\\d]+)-([\\d]+)";
	private static String file = "inputs/day16/input.txt";
	private static String prefix = "departure";
	
	private HashMap<String, List<Interval>> intervals = new HashMap<String, List<Interval>>();
	private List<Integer> myTicket;
	private List<List<Integer>> validTickets = new ArrayList<List<Integer>>();
	//here I gave up on using too many hashmaps :))
	private HashMap<Integer, List<String>> labelNameCandidates = new HashMap<Integer, List<String>>();
	private Set<String> labels;
	
	public long solution() {
		return solution(prefix, file);
	}
	
	public long solution(String prefix, String file) {
		long result = 0;
		List<String> input = ReadFromFile.readLines(file);
		int i = 0;
		while(i < input.size() && !input.get(i).equals("")) {
			List<Interval> intFromFile = parseInterval(input.get(i));
			insertIntervals(intFromFile);
			i++;
		}
		labels = intervals.keySet();
		i+=2;
		while(i < input.size() && !input.get(i).equals("")) {
			myTicket = parseTicket(input.get(i));
			i++;
		}
		i += 2;
		while(i < input.size()) {
			List<Integer> ticket = parseTicket(input.get(i));
			if (ticket.stream().filter(x -> checkValidValue(x)).count() == ticket.size()) {
				validTickets.add(ticket);
			}
			i++;
		}
		for (int j = 0; j < validTickets.get(0).size(); j++) {
			List<String> names = findLabelNameCandidates(j, labels);
			labelNameCandidates.put(j, names);
		}
		
		while(!valuesFound()) {
			for (Integer key : labelNameCandidates.keySet()) {
				if (labelNameCandidates.get(key).size() == 1) {
					String label = labelNameCandidates.get(key).get(0);
					for (Integer key2 : labelNameCandidates.keySet()) {
						if (key2 != key) {
							List<String> l = labelNameCandidates.get(key2);
							if (l.contains(label)) {
								l.remove(label);
								labelNameCandidates.put(key2, l);
							}
						}
					}
				}
			}
		}
		
		result = computeProduct2(prefix);
		
		return result;
	}
	
	public boolean valuesFound() {
		for (Integer key : labelNameCandidates.keySet()) {
			if (labelNameCandidates.get(key).size() != 1) {
				return false;
			}
		}
		return true;
	}
	
	public long computeProduct2(String prefix) {
		Long result = labelNameCandidates.keySet().stream()
				.filter(x -> labelNameCandidates.get(x).get(0).startsWith(prefix))
				.map(x -> myTicket.get(x)).map(Long::valueOf).reduce(1L, (e1, e2) -> e1 * e2);
		
		return result;
	}
	
	public List<String> findLabelNameCandidates(int index, Set<String> labels) {
		List<String> candidates = new ArrayList<String>();
		for (String label : labels) {
			if (checkValidLabel(index, label)) {
				candidates.add(label);
			}
		}
		return candidates;
	}
	
	public boolean checkValidLabel(int index, String label) {
		for (List<Integer> ticket : validTickets) {
			Integer val = ticket.get(index);
			if (!isValueInInterval(val, intervals.get(label))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValueInInterval(int val, List<Interval> intervalsList) {
		for (Interval i : intervalsList) {
			if (i.getStart() <= val && val <= i.getEnd()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkValidValue(int val) {
		for (String key : intervals.keySet()) {
			List<Interval> vals = intervals.get(key);
			for (Interval i : vals) {
				if (i.getStart() <= val && val <= i.getEnd()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public List<Interval> parseInterval(String s) {
		List<Interval> result = new ArrayList<Interval>();
		Pattern p = Pattern.compile(intervalRegex);
		Matcher m = p.matcher(s);
		if (m.matches()) {
			result.add(new Interval(m.group(1), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3))));
			result.add(new Interval(m.group(1), Integer.valueOf(m.group(4)), Integer.valueOf(m.group(5))));
		}
		
		return result;
	}
	
	public List<Integer> parseTicket(String s) {
		String[] tickets = s.split(",");
		return Arrays.stream(tickets).map(x -> Integer.valueOf(x)).collect(Collectors.toList());
	}
	
	public void insertIntervals(List<Interval> newIntervals) {
		String name = newIntervals.get(0).getName();
		intervals.put(name, newIntervals);
	}
}
