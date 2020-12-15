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
			m = r;
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
		Integer[] adjSeats = getAdjSeats(m, i, j);
		
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
	
	public Integer[] getAdjSeats(int[][] m, int i, int j) {
		Integer[] seats = new Integer[8];
		//left
		int k = j;
		while(k > 0 && m[i][k-1] == -1) {
			k--;
		}
		seats[0] = (k > 0) ? m[i][k-1] : null;
		//right
		k = j;
		while(k < m[0].length-1 && m[i][k+1] == -1) {
			k++;
		}
		seats[1] = (k < m[0].length - 1) ? m[i][k+1] : null;
		//up
		k = i;
		while(k > 0 && m[k-1][j] == -1) {
			k--;
		}
		seats[2] = (k > 0) ? m[k-1][j] : null;
		//down
		k = i;
		while(k < m.length-1 && m[k+1][j] == -1) {
			k++;
		}
		seats[3] = (k < m.length - 1) ? m[k+1][j]: null;
		//top left
		k = i;
		int l = j;
		while(k > 0 && l > 0 && m[k-1][l-1] == -1) {
			k--;
			l--;
		}
		seats[4] = (k > 0 && l > 0) ? m[k-1][l-1] : null;
		//top right
		k = i;
		l = j;
		while(k > 0 && l < m[0].length-1 && m[k-1][l+1] == -1) {
			k--;
			l++;
		}
		seats[5] = (k > 0 && l < m[0].length -1) ? m[k-1][l+1] : null;
		//bottom left
		k = i;
		l = j;
		while(k < m.length-1 && l > 0 && m[k+1][l-1] == -1) {
			k++;
			l--;
		}
		seats[6] = (k < m.length-1 && l > 0) ? m[k+1][l-1] : null;
		//bottom right
		k = i;
		l = j;
		while(k < m.length-1 && l < m[0].length-1 && m[k+1][l+1] == -1) {
			k++;
			l++;
		}
		seats[7] = (k < m.length-1 && l < m[0].length-1) ? m[k+1][l+1] : null;
		
		return seats;
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
		return (counter >= 5);
	}
}
