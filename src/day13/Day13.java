package day13;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day13 {
	private static String file = "inputs/day13/input.txt";
	private long timestamp;
	private List<Integer> buses;
	private TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
	
	public BigInteger solution() {
//		return solution(file);
		return solution2(file);
	}
	
	public BigInteger solution2(String file) {
		TreeMap<Integer, Integer> map = parseInput2(file);
		List<Integer> bussesList = new ArrayList<Integer>();
		//biggest bus number
		int prevBus = map.lastKey();
		BigInteger bus = BigInteger.valueOf(prevBus);
		BigInteger result = bus;
		//diff from 0 timestamp to bus timestamp
		BigInteger base = BigInteger.valueOf(map.get(prevBus));
		while(map.lowerKey(prevBus) != null) {
			prevBus = map.lowerKey(prevBus);
			bussesList.add(prevBus);
			boolean expression = true;
			for (int i = 0; i < bussesList.size(); i++) {
				BigInteger diff = BigInteger.valueOf(map.get(bussesList.get(i)));
				BigInteger currBus = BigInteger.valueOf(bussesList.get(i));
				expression = expression && (result.subtract(base).add(diff).mod(currBus).equals(BigInteger.ZERO));
			}
			while(!expression) {
				result = result.add(bus);
				expression = true;
				for (int i = 0; i < bussesList.size(); i++) {
					BigInteger diff = BigInteger.valueOf(map.get(bussesList.get(i)));
					BigInteger currBus = BigInteger.valueOf(bussesList.get(i));
					expression = expression && (result.subtract(base).add(diff).mod(currBus).equals(BigInteger.ZERO));
				}
				
			}
			bus = bus.multiply(BigInteger.valueOf(prevBus));
		}
		return result.subtract(base);
	}
	
	public void parseInput(String file) {
		List<String> input = ReadFromFile.readLines(file);
		this.timestamp = Integer.valueOf(input.get(0));
		this.buses = Arrays.stream(input.get(1).split(",")).filter(s -> !s.equals("x"))
				.map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}
	
	public TreeMap<Integer, Integer> parseInput2(String file) {
		List<String> input = ReadFromFile.readLines(file);
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		String[] buses = input.get(1).split(",");
		for(int i = 0; i < buses.length; i++) {
			if (!buses[i].equals("x")) {
				int bus = Integer.valueOf(buses[i]);
				//add bus number and timestamp dif
				map.put(bus, i);
			}
		}
		return map;
	}
	
	public long solution(String file) {
		parseInput(file);
		this.buses.stream().forEach(b -> getNextTimestamp(b));
		long nextTimestamp = map.higherKey(timestamp);
		int bus = map.get(nextTimestamp);
		long diff = nextTimestamp - timestamp;
		
		return bus * diff;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public List<Integer> getBuses() {
		return buses;
	}
	
	public void getNextTimestamp(int bus) {
		long multiplier = timestamp / bus;
		multiplier = multiplier + 1;
		long nextTimestamp = multiplier * bus;
		map.put(nextTimestamp, bus);
	}

}
