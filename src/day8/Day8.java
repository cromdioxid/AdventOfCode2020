package day8;

import java.util.ArrayList;
import java.util.List;

import main.ReadFromFile;

public class Day8 {
	private String ACC = "acc";
	private String JMP = "jmp";
	private String PLUS = "+";
	private String inputFile = "inputs/day8/input.txt";
	
	private boolean[] processed;
	private int acc = 0;
	
	public int solution() {
		return solution(inputFile);
	}
	
	public int solution(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		List<Instruction> instructions = processInput(input);
		int end = executeCode(instructions);
		if (end != input.size()) {
			List<Integer> toBeModified = getVisitedOperations(processed);
			int i = 0;
			while(end != input.size()) {
				List<Instruction> inst = modifyInstruction(instructions, toBeModified.get(i));
				end = executeCode(inst);
				i++;
			}
		}
		
		return acc;
	}
	
	public List<Instruction> modifyInstruction(List<Instruction> instr, int index) {
		List<Instruction> result = new ArrayList<Instruction>();
		for (int i = 0; i < instr.size(); i++) {
			Instruction in = instr.get(i);
			if (i == index) {
				in = in.modify();
			}
			result.add(in);
		}
		return result;
	}
	
	public List<Instruction> processInput(List<String> input) {
		List<Instruction> result = new ArrayList<Instruction>();
		for (String line : input) {
			Instruction i = new Instruction(line);
			result.add(i);
		}
		return result;
	}
	
	public List<Integer> getVisitedOperations(boolean[] visited) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				result.add(i);
			}
		}
		return result;
	}
	
	public int executeCode(List<Instruction> input) {
		processed = new boolean[input.size()];
		acc = 0;
		int i = 0;
		while(i < input.size() && !processed[i]) {
			processed[i] = true;
			Instruction inst = input.get(i);
			String op = inst.getOp();
			String sign = inst.getSign();
			int arg = inst.getArg();
			if (op.equals(ACC)) {
				if (sign.equals(PLUS)) {
					acc += arg;
				} else {
					acc -= arg;
				}
				i++;
			} else if(op.equals(JMP)) {
				if (sign.equals(PLUS)) {
					i += arg;
				} else {
					i -= arg;
				}
			} else {
				i++;
			}
		}
		return i;
	}

}
