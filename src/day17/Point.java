package day17;

import java.util.ArrayList;
import java.util.List;

public class Point {
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public boolean equals(Object other) {
		Point p = (Point)other;
		return this.x == p.x && this.y == p.y
				&& this.z == p.z;
	}
	
	@Override
	public int hashCode() {
		return (x*100 + y*10 + z);
	}
	
	public List<Point> getNeighbours() {
		List<Point> result = new ArrayList<Point>();
		result.add(new Point(x-1, y-1, z-1));
		result.add(new Point(x-1, y-1, z));
		result.add(new Point(x-1, y-1, z+1));
		result.add(new Point(x-1, y, z-1));
		result.add(new Point(x-1, y, z));
		result.add(new Point(x-1, y, z+1));
		result.add(new Point(x-1, y+1, z-1));
		result.add(new Point(x-1, y+1, z));
		result.add(new Point(x-1, y+1, z+1));
		result.add(new Point(x, y-1, z-1));
		result.add(new Point(x, y-1, z));
		result.add(new Point(x, y-1, z+1));
		result.add(new Point(x, y, z-1));
		result.add(new Point(x, y, z+1));
		result.add(new Point(x, y+1, z-1));
		result.add(new Point(x, y+1, z));
		result.add(new Point(x, y+1, z+1));
		result.add(new Point(x+1, y-1, z-1));
		result.add(new Point(x+1, y-1, z));
		result.add(new Point(x+1, y-1, z+1));
		result.add(new Point(x+1, y, z-1));
		result.add(new Point(x+1, y, z));
		result.add(new Point(x+1, y, z+1));
		result.add(new Point(x+1, y+1, z-1));
		result.add(new Point(x+1, y+1, z));
		result.add(new Point(x+1, y+1, z+1));
		
		return result;
	}
	

}
