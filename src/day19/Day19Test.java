package day19;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day19Test {
	private static String file = "inputs/day19/test1.txt";

	@Test
	public void testExpandRule() {
		Day19 d = new Day19();
		d.parseInput(file);
		assertEquals("a", d.expandRule(4).getRule1().get(0));
		assertTrue(d.expandRule(3).getAllRules().contains("ab"));
		assertTrue(d.expandRule(3).getAllRules().contains("ba"));
		assertTrue(d.expandRule(1).getAllRules().contains("aaab"));
		assertTrue(d.expandRule(1).getAllRules().contains("aaba"));
		assertTrue(d.expandRule(1).getAllRules().contains("bbab"));
		assertTrue(d.expandRule(1).getAllRules().contains("bbba"));
		assertTrue(d.expandRule(1).getAllRules().contains("abaa"));
		assertTrue(d.expandRule(1).getAllRules().contains("abbb"));
		assertTrue(d.expandRule(1).getAllRules().contains("baaa"));
		assertTrue(d.expandRule(1).getAllRules().contains("babb"));
		assertTrue(d.expandRule(0).getAllRules().contains("ababbb"));
		assertTrue(d.expandRule(0).getAllRules().contains("abbbab"));
		assertFalse(d.expandRule(0).getAllRules().contains("bababa"));
		assertFalse(d.expandRule(0).getAllRules().contains("aaabbb"));
		assertFalse(d.expandRule(0).getAllRules().contains("aaaabbb"));
	}
	
	@Test
	public void testSolution() {
		Day19 d = new Day19();
		assertEquals(2, d.solution(file));
	}

}
