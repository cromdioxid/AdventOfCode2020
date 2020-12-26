package day18;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.ReadFromFile;

public class Day18Test {
	private static String file = "inputs/day18/test1.txt";
	
	@Test
	public void testSolution() {
		Day18 d = new Day18();
		assertEquals(694173, d.solution(file));
	}

	@Test
	public void testCompute() {
		Day18 d = new Day18();
		List<String> input = ReadFromFile.readLines(file);
		assertEquals(231, d.compute(input.get(0)));
		assertEquals(51, d.compute(input.get(1)));
		assertEquals(46, d.compute(input.get(2)));
		assertEquals(1445, d.compute(input.get(3)));
		assertEquals(669060, d.compute(input.get(4)));
		assertEquals(23340, d.compute(input.get(5)));
	}

}
