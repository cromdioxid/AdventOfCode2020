package day15;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Day15Test {

	@Test
	public void testParseInput() {
		Day15 d = new Day15();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(3);
		expected.add(6);
		assertEquals(expected, d.processInput("inputs/day15/test1.txt"));
	}
	
	@Test
	public void testSolution() {
		Day15 d = new Day15();
		assertEquals(436, d.solution("inputs/day15/test1.txt"));
		d = new Day15();
		assertEquals(1, d.solution("inputs/day15/test2.txt"));
		d = new Day15();
		assertEquals(10, d.solution("inputs/day15/test3.txt"));
		d = new Day15();
		assertEquals(27, d.solution("inputs/day15/test4.txt"));
		d = new Day15();
		assertEquals(78, d.solution("inputs/day15/test5.txt"));
		d = new Day15();
		assertEquals(438, d.solution("inputs/day15/test6.txt"));
		d = new Day15();
		assertEquals(1836, d.solution("inputs/day15/test7.txt"));
	}

}
