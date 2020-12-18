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
		int i = 0;
		ship.move(input.get(i));
		assertEquals(100, ship.getX());
		assertEquals(10, ship.getY());
		i++;
		ship.move(input.get(i));
		assertEquals(100, ship.getX());
		assertEquals(10, ship.getY());
		i++;
		ship.move(input.get(i));
		assertEquals(170, ship.getX());
		assertEquals(38, ship.getY());
		i++;
		ship.move(input.get(i));
		assertEquals(170, ship.getX());
		assertEquals(38, ship.getY());
		i++;
		ship.move(input.get(i));
		assertEquals(214, ship.getX());
		assertEquals(-72, ship.getY());
	}
	
	@Test
	public void test() {
		Day12 d = new Day12();
		assertEquals(286, d.solution(file));
	}

}
