package day2;

import static org.junit.Assert.*;

import org.junit.Test;


public class Day2Test {

	@Test
	public void testPasswordCreation() {
		PasswordPolicy pass = new PasswordPolicy("1-3 a: abcde");
		assertEquals(1, pass.getMin());
		assertEquals(3, pass.getMax());
		assertEquals('a', pass.getLetter());
		assertEquals("abcde", pass.getPassword());
	}
	
	@Test
	public void testIsValid() {
		PasswordPolicy pass = new PasswordPolicy("1-3 a: abcde");
		assertEquals(true, pass.isValid());
		pass = new PasswordPolicy("1-3 b: cdefg");
		assertEquals(false, pass.isValid());
		pass = new PasswordPolicy("2-9 c: ccccccccc");
		assertEquals(false, pass.isValid());
	}
	
	@Test
	public void testSolution() {
		Day2 day2 = new Day2();
		assertEquals(1, day2.solution("inputs/day2/Test1.txt"));
	}

}
