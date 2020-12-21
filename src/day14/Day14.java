package day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import main.ReadFromFile;

public class Day14 {
	
	private static String maskRegex = "mask = (\\w+)";
	private static String memRegex = "mem\\[(\\d+)\\] = ([\\d]+)";
	private static char X = 'X';
	private static String file = "inputs/day14/input.txt";
	private HashMap<Integer, String> map = new HashMap<Integer, String>();
	private HashMap<Long, Long> map2 = new HashMap<Long, Long>();
	private String mask;
	
	public long solution() {
		return solution2(file);
	}
	
	public long solution(String file) {
		List<String> input = ReadFromFile.readLines(file);
		for(String line : input) {
			Pattern maskP = Pattern.compile(maskRegex);
			Pattern memP = Pattern.compile(memRegex);
			Matcher m = maskP.matcher(line);
			if (m.matches()) {
				mask = m.group(1);
			} else {
				m = memP.matcher(line);
				if (m.matches()) {
					int loc = Integer.valueOf(m.group(1));
					long val = Long.valueOf(m.group(2));
					String binaryVal = convertToBinaryAndApplyMask(val, mask);
					map.put(loc, binaryVal);
				}
			}
		}
		long result = 0;
		for (Integer key : map.keySet()) {
			result += convertToDecimal(map.get(key));
		}
		return result;
	}
	
	public long solution2(String file) {
		List<String> input = ReadFromFile.readLines(file);
		for(String line : input) {
			Pattern maskP = Pattern.compile(maskRegex);
			Pattern memP = Pattern.compile(memRegex);
			Matcher m = maskP.matcher(line);
			if (m.matches()) {
				mask = m.group(1);
			} else {
				m = memP.matcher(line);
				if (m.matches()) {
					int loc = Integer.valueOf(m.group(1));
					long val = Long.valueOf(m.group(2));
					List<Long> locs = computeAddresses(loc, mask);
					for (Long l : locs) {
						map2.put(l, val);
					}
				}
			}
		}
		long result = 0;
		for (Long key : map2.keySet()) {
			result += map2.get(key);
		}
		return result;
	}
	
	public String convertToBinaryAndApplyMask(long val, String mask) {
		String sVal = convertToBinary(val);
		String result = applyMask(sVal, mask);
		
		return result;
	}
	
	public String convertToBinary(long value) {
		String binaryVal = Long.toBinaryString(value);
		if (binaryVal.length() == 36) {
			return binaryVal;
		}
		StringBuilder sb = new StringBuilder();
		while(sb.length() < 36 - binaryVal.length()) {
			sb.append('0');
		}
		sb.append(binaryVal);
		
		return sb.toString();
	}
	
	public String applyMask(String val, String mask) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mask.length(); i++) {
			char m = mask.charAt(i);
			if (m == X) {
				sb.append(val.charAt(i));
			} else {
				sb.append(m);
			}
		}
		return sb.toString();
	}
	
	public long convertToDecimal(String sVal) {
		long result = Long.parseLong(sVal, 2);
		return result;
	}
	
	public List<Long> computeAddresses(long addr, String mask) {
		String result = applyMask2(addr, mask);
		List<String> addresses = generateAddresses(result);
		return addresses.stream().map(a -> convertToDecimal(a)).collect(Collectors.toList());
	}
	
	public String applyMask2(long val, String mask) {
		StringBuilder sb = new StringBuilder();
		String binaryVal = convertToBinary(val);
		for (int i = 0; i < mask.length(); i++) {
			char m = mask.charAt(i);
			if (m == '0') {
				sb.append(binaryVal.charAt(i));
			} else {
				sb.append(m);
			}
		}
		return sb.toString();
	}
	
	public List<String> generateAddresses(String addr) {
		int i = 0;
		List<String> result = new ArrayList<String>();
		while(i < addr.length() && addr.charAt(i) != X) {
			i++;
		}
		if (i == addr.length()) {
			result.add(addr);
		} else {
			String prefix = addr.substring(0, i);
			List<String> sufixes = generateAddresses(addr.substring(i+1));
			for (String sufix : sufixes) {
				StringBuilder sb = new StringBuilder();
				sb.append(prefix);
				sb.append('0');
				sb.append(sufix);
				result.add(sb.toString());
				sb = new StringBuilder();
				sb.append(prefix);
				sb.append('1');
				sb.append(sufix);
				result.add(sb.toString());
			}
		}
		return result;
	}
}
