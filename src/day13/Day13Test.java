package day13;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Day13Test {
	private static String file = "inputs/day13/test1.txt";

	@Test
	public void testParseInput() {
		Day13 day13 = new Day13();
		day13.parseInput(file);
		assertEquals(939, day13.getTimestamp());
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(7);
		testList.add(13);
		testList.add(59);
		testList.add(31);
		testList.add(19);
		assertEquals(testList, day13.getBuses());
	}
	
	@Test
	public void test() {
		Day13 d = new Day13();
		assertEquals(295, d.solution(file));
	}
	
	@Test
	public void solution2Test() {
		Day13 d = new Day13();
		assertEquals(BigInteger.valueOf(1068781), d.solution2(file));
		assertEquals(BigInteger.valueOf(3417), d.solution2("inputs/day13/test2.txt"));
		assertEquals(BigInteger.valueOf(754018), d.solution2("inputs/day13/test3.txt"));
		assertEquals(BigInteger.valueOf(779210), d.solution2("inputs/day13/test4.txt"));
		assertEquals(BigInteger.valueOf(1261476), d.solution2("inputs/day13/test5.txt"));
		assertEquals(BigInteger.valueOf(1202161486), d.solution2("inputs/day13/test6.txt"));
	}

}
