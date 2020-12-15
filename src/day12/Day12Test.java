package day12;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Day12Test {
	public static String file = "inputs/day12/Test1.txt";

	@Test
	public void testMoveShip() {
		Day12 d = new Day12();
		List<Instruction> input = d.processInput(file);
		Ship ship = new Ship();
		input.stream().forEach(i -> ship.move(i));
		assertEquals(-8, ship.getX());
		assertEquals(17, ship.getY());
	}
	
	@Test
	public void test() {
		Day12 d = new Day12();
		assertEquals(25, d.solution(file));
	}

}
