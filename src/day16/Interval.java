package day16;

public class Interval {
	
	private int start;
	private int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	@Override
	public boolean equals(Object other) {
		Interval i = (Interval) other;
		return this.start == i.start && this.end == i.end;
	}
}
