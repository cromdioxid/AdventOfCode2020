package day7;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day7Test {

	@Test
	public void test() {
		Day7 day7 = new Day7();
		assertEquals(32, day7.solution("inputs/day7/Test1.txt"));
		assertEquals(126, day7.solution("inputs/day7/Test2.txt"));
	}

}
