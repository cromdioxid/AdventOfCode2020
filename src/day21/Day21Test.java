package day21;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day21Test {
	private static String file = "inputs/day21/test1.txt";

	@Test
	public void test() {
		Day21 d = new Day21();
		assertEquals(5, d.solution(file));
	}

}
