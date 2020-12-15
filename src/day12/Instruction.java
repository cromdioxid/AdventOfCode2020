package day12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
	
	private static String regex = "([A-Z])([\\d]+)";
	private String action;
	private int value;
	
	public Instruction(String inst) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inst);
		if (m.matches()) {
			this.action = m.group(1);
			this.value = Integer.valueOf(m.group(2));
		}
	}
	
	public String getAction() {
		return action;
	}
	
	public int getValue() {
		return value;
	}
	

}
