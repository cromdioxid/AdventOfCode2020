package day5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day5Test {

	@Test
	public void testGetRowAndSeat() {
		BoardingPass pass = new BoardingPass("FBFBBFFRLR");
		assertEquals(44, pass.getRow());
		assertEquals(5, pass.getSeat());
		assertEquals(357, pass.getId());
	}
	
	@Test
	public void testId() {
		BoardingPass p1 = new BoardingPass("BFFFBBFRRR");
		assertEquals(567, p1.getId());
		BoardingPass p2 = new BoardingPass("FFFBBBFRRR");
		assertEquals(119, p2.getId());
		BoardingPass p3 = new BoardingPass("BBFFBBFRLL");
		assertEquals(820, p3.getId());
	}
	
	@Test
	public void test() {
		Day5 day5 = new Day5();
		assertEquals(820, day5.solution("inputs/day5/Test1.txt"));
	}

}
