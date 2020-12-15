package day11;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day11Test {
	private static String file = "inputs/day11/Test1.txt";
	
	@Test
	public void solution() {
		Day11 d = new Day11();
		assertEquals(26, d.solution(file));
	}

	@Test
	public void testOccupiedSeat() {
		Day11 day11 = new Day11();
		int[][] input = day11.processInput(file);
		assertFalse(day11.checkOccupiedSeat(input[0][3]));
		assertFalse(day11.checkOccupiedSeat(input[0][1]));
	}
	
	@Test
	public void testComputeSeatStatus1() {
		Day11 d = new Day11();
		int[][] m = d.processInput(file);
		int[][] r = new int[m.length][m[0].length];
		assertTrue(d.computeSeatStatus(m, 0, 3,r));
		assertEquals(1, r[0][3]);
		assertFalse(d.computeSeatStatus(m, 0, 4,r));
		assertEquals(-1, r[0][4]);
		assertTrue(d.computeSeatStatus(m, 1, 2,r));
		assertEquals(1, r[1][2]);
	}
	
	@Test
	public void computeSeatsStatus() {
		Day11 d = new Day11();
		int[][] m = d.processInput(file);
		int[][] r = new int[m.length][m[0].length];
		assertTrue(d.computeSeatsStatus(m, r));
		assertEquals(1, r[0][2]);
		assertEquals(1, r[m.length-1][m[0].length-1]);
		assertEquals(-1, r[0][1]);
		m = new int[r.length][r[0].length];
		assertTrue(d.computeSeatsStatus(r, m));
		assertEquals(1, m[0][0]);
		assertEquals(-1, m[0][1]);
		assertEquals(0, m[0][2]);
	}

}
