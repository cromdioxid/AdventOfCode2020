package day10;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Day10Test {

	@Test
	public void testSortList() {
		Day10 day10 = new Day10();
		List<Integer> expectedList = day10.processInput("inputs/day10/Test1.txt");
		Collections.sort(expectedList);
		List<Integer> list = day10.processInput("inputs/day10/Test1.txt");
		list = day10.sortList(list);
		assertEquals(expectedList, list);
	}
	
	@Test
	public void test() {
		Day10 day10 = new Day10();
		assertEquals(8, day10.solution("inputs/day10/Test1.txt"));
		assertEquals(19208, day10.solution("inputs/day10/Test2.txt"));
	}
	
	

}
