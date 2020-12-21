package day14;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Day14Test {
	private static String file = "inputs/day14/test1.txt";
	
	@Test
	public void testSolution() {
		Day14 d = new Day14();
		assertEquals(165, d.solution(file));
	}
	
	@Test
	public void testSolution2() {
		Day14 d = new Day14();
		assertEquals(208, d.solution2("inputs/day14/test2.txt"));
	}

	@Test
	public void testConvertToBinary() {
		Day14 d = new Day14();
		assertEquals("000000000000000000000000000000001011", d.convertToBinary(11));
		assertEquals("000000000000000000000000000001001001", d.convertToBinary(73));
		assertEquals("000000000000000000000000000001100101", d.convertToBinary(101));
		assertEquals("000000000000000000000000000000000000", d.convertToBinary(0));
		assertEquals("000000000000000000000000000001000000", d.convertToBinary(64));
	}
	
	@Test
	public void testConvertApplyMask() {
		Day14 d = new Day14();
		String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
		assertEquals("000000000000000000000000000001001001",
				d.convertToBinaryAndApplyMask(11, mask));
		assertEquals("000000000000000000000000000001100101",
				d.convertToBinaryAndApplyMask(101, mask));
		assertEquals("000000000000000000000000000001000000",
				d.convertToBinaryAndApplyMask(0, mask));
	}
	
	@Test
	public void testConvertToDecimal() {
		Day14 d = new Day14();
		assertEquals(73, d.convertToDecimal("000000000000000000000000000001001001"));
		assertEquals(101, d.convertToDecimal("000000000000000000000000000001100101"));
		assertEquals(64, d.convertToDecimal("000000000000000000000000000001000000"));
	}
	
	@Test
	public void testGenerateAddresses() {
		Day14 d = new Day14();
		List<String> result = new ArrayList<String>();
		result.add("000000000000000000000000000000011010");
		result.add("000000000000000000000000000000111010");
		result.add("000000000000000000000000000000011011");
		result.add("000000000000000000000000000000111011");
		assertEquals(result, d.generateAddresses("000000000000000000000000000000X1101X"));
	}
	
	@Test
	public void testApplyMask2() {
		Day14 d = new Day14();
		String mask = "000000000000000000000000000000X1001X";
		assertEquals("000000000000000000000000000000X1101X", d.applyMask2(42, mask));
		mask = "00000000000000000000000000000000X0XX";
		assertEquals("00000000000000000000000000000001X0XX", d.applyMask2(26, mask));
	}
	
	@Test
	public void testComputeAddresses() {
		Day14 d = new Day14();
		String mask = "000000000000000000000000000000X1001X";
		List<Long> result = new ArrayList<Long>();
		result.add(26L);
		result.add(58L);
		result.add(27L);
		result.add(59L);
		List<Long> actual = d.computeAddresses(42, mask);
		for (Long elem : actual) {
			assertTrue(result.contains(elem));
		}
		mask = "00000000000000000000000000000000X0XX";
		result = new ArrayList<Long>();
		result.add(16L);
		result.add(17L);
		result.add(18L);
		result.add(19L);
		result.add(24L);
		result.add(25L);
		result.add(26L);
		result.add(27L);
		actual = d.computeAddresses(26, mask);
		for (Long elem : actual) {
			assertTrue(result.contains(elem));
		}
	}

}
