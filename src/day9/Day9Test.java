package day9;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.ReadFromFile;

public class Day9Test {

	@Test
	public void testValidValue() {
		Day9 day9 = new Day9();
		List<String> input = ReadFromFile.readLines("inputs/day9/Test1.txt");
		List<Long> longInput = day9.convertInput(input);
		assertEquals(true, day9.testValidValue(0, 5, longInput));
		assertEquals(false, day9.testValidValue(9, 5, longInput));
	}
	
	@Test
	public void test() {
		Day9 day9 = new Day9();
		assertEquals(Long.valueOf(62), day9.solution("inputs/day9/Test1.txt", 5));
	}
	
	@Test
	public void testGetArray() {
		Day9 day9 = new Day9();
		List<String> input = ReadFromFile.readLines("inputs/day9/Test1.txt");
		List<Long> longInput = day9.convertInput(input);
		int[] result = day9.getArray(127, longInput);
		assertEquals(2, result[0]);
		assertEquals(6, result[1]);
	}
	
	@Test
	public void testGetMinMaxSum() {
		Day9 day9 = new Day9();
		List<String> input = ReadFromFile.readLines("inputs/day9/Test1.txt");
		List<Long> longInput = day9.convertInput(input);
		int[] result = day9.getArray(127, longInput);
		Long sum = day9.getMinMaxSum(longInput, result);
		assertEquals(Long.valueOf(62), sum);
	}

}
