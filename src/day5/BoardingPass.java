package day5;

public class BoardingPass {
	
	private int row;
	private int seat;
	private int id;
	
	public BoardingPass(String number) {
		row = getRow(number.substring(0, 7));
		seat = getSeat(number.substring(7));
		id = row * 8 + seat;
	}
	
	private int getRow(String number) {
		return compute(number, 'F', 0, 127);
	}
	
	private int getSeat(String number) {
		return compute(number, 'L', 0, 7);
	}
	private int compute(String number, char c, int start, int end) {
		for (int i = 0; i < number.length(); i++) {
			int m = (start + end) / 2;
			if (number.charAt(i) == c) {
				end = m;
			} else {
				start = m;
			}
		}
		return end;
	}
	
	
	
	public int getRow() {
		return row;
	}
	
	public int getSeat() {
		return seat;
	}
	
	public int getId() {
		return id;
	}

}
