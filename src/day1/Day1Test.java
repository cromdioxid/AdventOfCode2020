package day1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day1Test {
	
	private String testInput = "inputs/day1/Test1.txt";

	@Test
	public void test() {
		Day1 day1 = new Day1();
		assertEquals(241861950, day1.solution(testInput));
		
	}

}
