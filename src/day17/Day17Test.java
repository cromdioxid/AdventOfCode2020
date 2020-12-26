package day17;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class Day17Test {
	private static String file = "inputs/day17/test1.txt";

	@Test
	public void testInitialState() {
		Day17 d = new Day17();
		d.parseInput("inputs/day17/test1.txt");
		Point p1 = new Point(2, 0, 0, 0);
		assertTrue(d.getActive(p1));
		Point p2 = new Point(1, 0, 0, 0);
		assertFalse(d.getActive(p2));
		Point p3 = new Point(0, 0, -1, 0);
		assertFalse(d.getActive(p3));
		Point p4 = new Point(2,1,1, 0);
		assertFalse(d.getActive(p4));
	}
	
	@Test
	public void testState() {
		Day17 d = new Day17();
		HashSet<Point> ns = new HashSet<Point>();
		d.parseInput(file);
		Point p1 = new Point(1, 2, 0, 0);
		assertTrue(d.getActive(p1));
		assertTrue(d.keepActive(p1, ns));
		Point p2 = new Point(0, 1, 0, 0);
		assertTrue(d.getActive(p2));
		assertFalse(d.keepActive(p2, ns));
		Point p3 = new Point(0, 0, 0, 0);
		assertFalse(d.getActive(p3));
		assertFalse(d.becomeActive(p3));
		Point p4 = new Point(2, 2, -1, 0);
		assertFalse(d.getActive(p4));
		assertTrue(d.becomeActive(p4));
	}
	
	
	@Test
	public void testSolution() {
		Day17 d = new Day17();
		assertEquals(848, d.solution(file));
	}

}
