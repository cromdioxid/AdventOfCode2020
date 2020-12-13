package day8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
	private static String JMP = "jmp";
	private static String NOP = "nop";
	
	private String op;
	private String sign;
	private int arg;
	
	public Instruction(String inst) {
		Pattern p = Pattern.compile("([a-z]{3}) ([+\\-])(\\d+)");
		Matcher m = p.matcher(inst);
		if (m.matches()) {
			op = m.group(1);
			sign = m.group(2);
			arg = Integer.valueOf(m.group(3));
		}
	}
	
	private Instruction(String op, String sign, int arg) {
		this.op = op;
		this.sign = sign;
		this.arg = arg;
	}
	
	public String getOp() {
		return op;
	}
	
	public String getSign() {
		return sign;
	}
	
	public int getArg() {
		return arg;
	}
	
	public Instruction modify() {
		if (op.equals(JMP)) {
			return new Instruction(NOP, this.sign, this.arg);
		}
		if (op.equals(NOP)){
			return new Instruction(JMP, this.sign, this.arg);
		}
		
		return this;
	}

}
