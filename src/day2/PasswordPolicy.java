package day2;

public class PasswordPolicy {
	
	private String password;
	private char letter;
	private int min;
	private int max;
	
	public PasswordPolicy(int min, int max, char letter, String password) {
		this.min = min;
		this.max = max;
		this.letter = letter;
		this.password = password;
	}
	
	public PasswordPolicy (String s) {
		String[] parts = s.split(" ");
		
		password = parts[2];
		letter = parts[1].charAt(0);
		
		String[] interval = parts[0].split("-");
		min = Integer.valueOf(interval[0]);
		max = Integer.valueOf(interval[1]);
		
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isValid() {
		char c1 = password.charAt(min - 1);
		char c2 = password.charAt(max - 1);
		return ((c1 == letter && c2 != letter) || (c1 != letter && c2 == letter));
	}
	

}
