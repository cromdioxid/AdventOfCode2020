package day16;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Day16Test {
	private static String file = "inputs/day16/test1.txt";
	
	@Test
	public void testSolution() {
		Day16 d = new Day16();
		assertEquals(71, d.solution(file));
	}

	@Test
	public void testParseInterval() {
		Day16 d = new Day16();
		List<Interval> expected = new ArrayList<Interval>();
		expected.add(new Interval(1, 3));
		expected.add(new Interval(5, 7));
		List<Interval> actual = d.parseInterval("class: 1-3 or 5-7");
		assertEquals(actual.size(), expected.size());
	}
	
	@Test
	public void testParseTicket() {
		Day16 d = new Day16();
		List<Integer> expected = Arrays.asList(7,3,47);
		assertEquals(expected, d.parseTicket("7,3,47"));
	}
	
	@Test
	public void testInsertIntervals() {
		Day16 d = new Day16();
		Interval i1 = new Interval(1, 3);
		d.insertInterval(i1);
		Interval i2 = new Interval(5, 7);
		d.insertInterval(i2);
		Interval i3 = new Interval(6, 11);
		d.insertInterval(i3);
		Interval i4 = new Interval(33, 44);
		d.insertInterval(i4);
		Interval i5 = new Interval(13, 40);
		d.insertInterval(i5);
		Interval i6 = new Interval(45, 50);
		d.insertInterval(i6);
		List<Interval> actual = d.getIntervals();
		List<Interval> expected = getExpectedIntervals();
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkValidValue() {
		Day16 d = new Day16();
		List<Interval> expected = getExpectedIntervals();
		assertTrue(d.checkValidValue(7, expected));
		assertTrue(d.checkValidValue(3, expected));
		assertTrue(d.checkValidValue(47, expected));
		assertTrue(d.checkValidValue(40, expected));
		assertFalse(d.checkValidValue(4, expected));
		assertTrue(d.checkValidValue(50, expected));
		assertFalse(d.checkValidValue(55, expected));
		assertTrue(d.checkValidValue(2, expected));
		assertTrue(d.checkValidValue(20, expected));
		assertTrue(d.checkValidValue(38, expected));
		assertTrue(d.checkValidValue(6, expected));
		assertFalse(d.checkValidValue(12, expected));
	}
	
	private List<Interval> getExpectedIntervals() {
		List<Interval> expected = new ArrayList<Interval>();
		expected.add(new Interval(1, 3));
		expected.add(new Interval(5, 11));
		expected.add(new Interval(13, 44));
		expected.add(new Interval(45, 50));
		return expected;
	}
}
