package day11;

import java.util.List;

import main.ReadFromFile;

public class Day11 {
	private static char L = 'L';
	private static String file = "inputs/day11/input.txt";
	
	public int solution() {
		return solution(file);
	}
	
	public int solution(String fileName) {
		int[][] m = processInput(fileName);
		boolean isDirty = true;
		while(isDirty) {
			int[][] r = new int[m.length][m[0].length];
			isDirty = computeSeatsStatus(m, r);
			m = r.clone();
		}
		int result = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (checkOccupiedSeat(m[i][j])) {
					result++;
				}
			}
		}
		return result;
	}

	public int[][] processInput(String fileName) {
		List<String> input = ReadFromFile.readLines(fileName);
		int[][] m = new int[input.size()][input.get(0).length()];
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).length(); j++) {
				if (input.get(i).charAt(j) == L) {
					m[i][j] = 0;
				} else {
					m[i][j] = -1;
				}
			}
		}
		return m;
	}
	
	public boolean computeSeatsStatus(int[][] m, int[][] r) {
		boolean isDirty = false;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				isDirty = computeSeatStatus(m, i, j, r) || isDirty;
			}
		}
		return isDirty;
	} 
	
	public boolean computeSeatStatus(int[][] m, int i, int j, int[][] r) {
		boolean isDirty = false;
		int seat = m[i][j];
		if (seat == -1) {
			r[i][j] = -1;
			return false;
		}
		Integer[] adjSeats = new Integer[8];
		adjSeats[0] = (j > 0) ? m[i][j-1] : null;
		adjSeats[1] = (j < m[0].length - 1) ? m[i][j+1] : null;
		adjSeats[2] = (i > 0) ? m[i-1][j] : null;
		adjSeats[3] = (i < m.length - 1) ? m[i+1][j]: null;
		adjSeats[4] = (i > 0 && j > 0) ? m[i-1][j-1] : null;
		adjSeats[5] = (i > 0 && j < m[0].length -1) ? m[i-1][j+1] : null;
		adjSeats[6] = (i < m.length-1 && j > 0) ? m[i+1][j-1] : null;
		adjSeats[7] = (i < m.length-1 && j < m[0].length-1) ? m[i+1][j+1] : null;
		
		//seat is free
		if (seat == 0) {
			if(checkAdjFreeSeats(adjSeats)) {
				//occupy seat
				r[i][j] = 1;
				isDirty = true;
			} else {
				r[i][j] = 0;
			}
		} else if (seat == 1) {
			//seat is occupied
			if (checkAdjOccupiedSeats(adjSeats)) {
				//free seat
				r[i][j] = 0;
				isDirty = true;
			} else {
				r[i][j] = 1;
			}
		} 
		return isDirty;
	}
	
	public boolean checkOccupiedSeat(int val) {
		return val == 1;
	}
	
	public boolean checkAdjFreeSeats(Integer[] adjSeats) {
		for (int i = 0; i < 8; i++) {
			if (adjSeats[i] != null && checkOccupiedSeat(adjSeats[i])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkAdjOccupiedSeats(Integer[] adjSeats) {
		int counter = 0;
		for (int i = 0; i < 8; i++) {
			if(adjSeats[i] != null && checkOccupiedSeat(adjSeats[i])) {
				counter++;
			}
		}
		return (counter >= 4);
	}
}
