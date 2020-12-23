package day16;

public class Interval {
	
	private int start;
	private int end;
	private String name;
	
	public Interval(String name, int start, int end) {
		this.start = start;
		this.end = end;
		this.name = name;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object other) {
		Interval i = (Interval) other;
		return this.start == i.start && this.end == i.end
				&& this.name.equals(i.name);
	}
}
