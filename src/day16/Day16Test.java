package day16;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.ReadFromFile;

public class Day16Test {
	private static String file = "inputs/day16/test2.txt";
	
	@Test
	public void testSolution() {
		Day16 d = new Day16();
		assertEquals(11, d.solution("row", file));
		d = new Day16();
		assertEquals(12, d.solution("class", file));
		d = new Day16();
		assertEquals(13, d.solution("seat", file));
	}

	@Test
	public void testParseInterval() {
		Day16 d = new Day16();
		List<Interval> expected = new ArrayList<Interval>();
		expected.add(new Interval("class", 1, 3));
		expected.add(new Interval("class", 5, 7));
		List<Interval> actual = d.parseInterval("class: 1-3 or 5-7");
		assertEquals(actual.size(), expected.size());
		assertEquals(actual, expected);
	}
	
	@Test
	public void testParseTicket() {
		Day16 d = new Day16();
		List<Integer> expected = Arrays.asList(7,3,47);
		assertEquals(expected, d.parseTicket("7,3,47"));
	}
	
	@Test
	public void checkValidValue() {
		Day16 d = new Day16();
		List<String> input = ReadFromFile.readLines("inputs/day16/test1.txt");
		int i = 0;
		while(i < input.size() && !input.get(i).equals("")) {
			List<Interval> intFromFile = d.parseInterval(input.get(i));
			d.insertIntervals(intFromFile);
			i++;
		}
		assertTrue(d.checkValidValue(7));
		assertTrue(d.checkValidValue(3));
		assertTrue(d.checkValidValue(47));
		assertTrue(d.checkValidValue(40));
		assertFalse(d.checkValidValue(4));
		assertTrue(d.checkValidValue(50));
		assertFalse(d.checkValidValue(55));
		assertTrue(d.checkValidValue(2));
		assertTrue(d.checkValidValue(20));
		assertTrue(d.checkValidValue(38));
		assertTrue(d.checkValidValue(6));
		assertFalse(d.checkValidValue(12));
	}
	
}
