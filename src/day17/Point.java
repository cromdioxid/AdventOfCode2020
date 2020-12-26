package day17;

import java.util.ArrayList;
import java.util.List;

public class Point {
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private int w = 0;
	
	public Point(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	@Override
	public boolean equals(Object other) {
		Point p = (Point)other;
		return this.x == p.x && this.y == p.y
				&& this.z == p.z && this.w == p.w;
	}
	
	@Override
	public int hashCode() {
		return (x*1000 + y*100 + z*10 + w);
	}
	
	public List<Point> getNeighbours() {
		List<Point> result = new ArrayList<Point>();
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				for (int k = z-1; k <= z+1; k++) {
					for (int l = w-1; l <= w+1; l++) {
						result.add(new Point(i, j, k, l));
					}
				}
			}
		}
		result.remove(new Point(x, y, z, w));
		return result;
	}
	

}
