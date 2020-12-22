package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day16 {
	
	private static String intervalRegex = "([a-z]+): ([\\d]+)-([\\d]+) or ([\\d]+)-([\\d]+)";
	private static String file = "inputs/day16/input.txt";
	
	private List<Interval> intervals = new ArrayList<Interval>();
	
	public int solution() {
		return solution(file);
	}
	
	public int solution(String file) {
		int result = 0;
		List<String> input = ReadFromFile.readLines(file);
		int i = 0;
		while(i < input.size() && !input.get(i).equals("")) {
			List<Interval> intFromFile = parseInterval(input.get(i));
			for (Interval interval : intFromFile) {
				insertInterval(interval);
			}
			i++;
		}
		i++;
		while(i < input.size() && !input.get(i).equals("")) {
			i++;
		}
		i += 2;
		while(i < input.size()) {
			List<Integer> tickets = parseTicket(input.get(i));
			Integer sum = tickets.stream().filter(x -> !checkValidValue(x, intervals)).reduce(0, Integer::sum);
			result += sum;
			i++;
		}
		
		return result;
	}
	
	public boolean checkValidValue(int val, List<Interval> intervals) {
		int i = 0;
		while(i < intervals.size()) {
			if (intervals.get(i).getStart() <= val && val <= intervals.get(i).getEnd()) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public List<Interval> parseInterval(String s) {
		List<Interval> result = new ArrayList<Interval>();
		Pattern p = Pattern.compile(intervalRegex);
		Matcher m = p.matcher(s);
		if (m.matches()) {
			result.add(new Interval(Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3))));
			result.add(new Interval(Integer.valueOf(m.group(4)), Integer.valueOf(m.group(5))));
		}
		
		return result;
	}
	
	public List<Integer> parseTicket(String s) {
		String[] tickets = s.split(",");
		return Arrays.stream(tickets).map(x -> Integer.valueOf(x)).collect(Collectors.toList());
	}
	
	public void insertInterval(Interval newInt) {
		if (intervals.size() == 0) {
			intervals.add(newInt);
		} else {
			int i = 1;
			Interval curr = intervals.get(0);
			while(i < intervals.size() && (curr.getEnd() < newInt.getStart())) {
				curr = intervals.get(i);
				i++;
			}
			if(i == intervals.size() && curr.getEnd() < newInt.getStart()) {
				intervals.add(newInt);
			} else {
				if (curr.getEnd() > newInt.getStart()) {
					int newStart = Math.min(curr.getStart(), newInt.getStart());
					int newEnd = Math.max(curr.getEnd(), newInt.getEnd());
					i = i-1;
					int j = i+1;
					while(j < intervals.size() && newEnd > intervals.get(j).getStart()) {
						newEnd = Math.max(newEnd, intervals.get(j).getEnd());
						j++;
					}
					int k = i-1;
					while(k >= 0 && newStart < intervals.get(k).getEnd()) {
						newStart = Math.min(newStart, intervals.get(k).getStart());
						k--;
					}
					intervals.set(i, new Interval(newStart, newEnd));
					j--;
					while(j > i+1) {
						intervals.remove(j);
						j--;
					}
					k++;
					while(k < i-1) {
						intervals.remove(k);
						k++;
					}
				}
			}
		}
		
	}
	
	public List<Interval> getIntervals() {
		return intervals;
	}
	
	

}
