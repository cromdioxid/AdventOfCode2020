package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day4Test {

	@Test
	public void test() {
		Day4 day4 = new Day4();
		assertEquals(4, day4.solution("inputs/day4/Test2.txt"));
	}
	
	@Test
	public void testByrValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isByrValid());
		p1.addField("byr", "2002");
		assertEquals(true, p1.isByrValid());
		Passport p2 = new Passport();
		p2.addField("byr", "2003");
		assertEquals(false, p2.isByrValid());
	}
	
	@Test
	public void testIyrValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isIyrValid());
		p1.addField("iyr", "2013");
		assertEquals(true, p1.isIyrValid());
		Passport p2 = new Passport();
		p2.addField("iyr", "20");
		assertEquals(false, p2.isIyrValid());
	}
	
	@Test
	public void testEyrValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isEyrValid());
		p1.addField("eyr", "2025");
		assertEquals(true, p1.isEyrValid());
		Passport p2 = new Passport();
		p2.addField("eyr", "20");
		assertEquals(false, p2.isEyrValid());
	}
	
	@Test
	public void testHgtValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isHgtValid());
		p1.addField("hgt", "60in");
		assertEquals(true, p1.isHgtValid());
		Passport p2 = new Passport();
		p2.addField("hgt", "190cm");
		assertEquals(true, p2.isHgtValid());
		Passport p3 = new Passport();
		p3.addField("hgt", "190in");
		assertEquals(false, p3.isHgtValid());
		Passport p4 = new Passport();
		p4.addField("hgt", "190");
		assertEquals(false, p4.isHgtValid());
	}
	
	@Test
	public void testHclValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isHclValid());
		p1.addField("hcl", "#123abc");
		assertEquals(true, p1.isHclValid());
		Passport p2 = new Passport();
		p2.addField("hcl", "#123abz");
		assertEquals(false, p2.isHclValid());
		Passport p3 = new Passport();
		p3.addField("hcl", "123abc");
		assertEquals(false, p3.isHclValid());
	}
	
	@Test
	public void testEclValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isEclValid());
		p1.addField("ecl", "brn");
		assertEquals(true, p1.isEclValid());
		Passport p2 = new Passport();
		p2.addField("ecl", "wat");
		assertEquals(false, p2.isEclValid());
	}
	
	@Test
	public void testPidValid() {
		Passport p1 = new Passport();
		assertEquals(false, p1.isPidValid());
		p1.addField("pid", "000000001");
		assertEquals(true, p1.isPidValid());
		Passport p2 = new Passport();
		p2.addField("pid", "0123456789");
		assertEquals(false, p2.isPidValid());
	}
 
}
