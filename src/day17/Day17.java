package day17;

import java.util.HashSet;
import java.util.List;

import main.ReadFromFile;

public class Day17 {
	private static String file = "inputs/day17/input.txt";
	
	private HashSet<Point> activePoints = new HashSet<Point>();
	
	public void parseInput(String file) {
		List<String> input = ReadFromFile.readLines(file);
		for (int i = 0; i < input.size(); i++) {
			String line = input.get(i);
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				Point p = new Point(i, j, 0, 0);
				if (c == '#') {
					activePoints.add(p);
				}
			}
		}
	}
	
	public int solution() {
		return solution(file);
	}
	
	public int solution(String file) {
		parseInput(file);
		for (int i = 0; i < 6; i++) {
			HashSet<Point> newPoints = new HashSet<Point>();
			HashSet<Point> neighbours = new HashSet<Point>();
			for (Point p : activePoints) {
				if (keepActive(p, neighbours)) {
					newPoints.add(p);
				}
			}
			for (Point p : neighbours) {
				if (becomeActive(p)) {
					newPoints.add(p);
				}
			}
			activePoints = newPoints;
		}
		return activePoints.size();
	}
	
	public boolean becomeActive(Point p) {
		List<Point> ns = p.getNeighbours();
		int count = 0;
		for (Point n : ns) {
			if(getActive(n)) {
				count++;
			}
		}
		return (count == 3);
	}
	
	public boolean keepActive(Point p, HashSet<Point> neighbours) {
		List<Point> ns = p.getNeighbours();
		int count = 0;
		for (Point n : ns) {
			if (getActive(n)) {
				count++;
			} else {
				neighbours.add(n);
			}
		}
		return ((count == 2) || (count == 3));
	}
	
	public boolean getActive(Point p) {
		return activePoints.contains(p);
	}
	
}
