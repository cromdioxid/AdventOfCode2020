package day4;

import java.util.HashMap;

public class Passport {
	
	HashMap<String, String> fields = new HashMap<String, String>();
	
	public void addField(String key, String value) {
		fields.put(key, value);
	}
	
	public boolean isValid() {
//		for (int i = 0; i < keys.length - 1; i++) {
//			if (!fields.containsKey(keys[i])) {
//				return false;
//			}
//		}
//		
//		return true;
		
		return isByrValid() && isIyrValid() && isEyrValid() && isHgtValid()
				&& isHclValid() && isEclValid() && isPidValid();
	}
	
	public boolean isByrValid() {
		String byr = fields.get("byr");
		if (byr == null) {
			return false;
		}
		int byrInt = Integer.valueOf(byr);
		if (byrInt >= 1920 && byrInt <= 2002) {
			return true;
		}
		return false;
	}
	
	public boolean isIyrValid() {
		String iyr = fields.get("iyr");
		if (iyr == null) {
			return false;
		}
		int iyrInt = Integer.valueOf(iyr);
		if (iyrInt >= 2010 && iyrInt <= 2020) {
			return true;
		}
		
		return false;
	}
	
	public boolean isEyrValid() {
		String eyr = fields.get("eyr");
		if (eyr == null) {
			return false;
		}
		int eyrInt = Integer.valueOf(eyr);
		if (eyrInt >= 2020 && eyrInt <= 2030) {
			return true;
		}
		return false;
	}
	
	public boolean isHgtValid() {
		String hgt = fields.get("hgt");
		if (hgt == null) {
			return false;
		}
		if (hgt.length() == 5) {
			String sufix = hgt.substring(3);
			String value = hgt.substring(0, 3);
			if (!sufix.equals("cm")) {
				return false;
			} else {
				int val = Integer.valueOf(value);
				if (val >= 150 && val <= 193) {
					return true;
				} else {
					return false;
				}
			}
		} else if (hgt.length() == 4){
			String sufix = hgt.substring(2);
			String value = hgt.substring(0, 2);
			if (!sufix.equals("in")) {
				return false;
			} else {
				int val = Integer.valueOf(value);
				if (val >= 59 && val <= 76) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	public boolean isHclValid() {
		String hcl = fields.get("hcl");
		if (hcl == null) {
			return false;
		}
		if (hcl.length() != 7) {
			return false;
		} else if (hcl.charAt(0) != '#') {
			return false;
		} else {
			for (int i = 1; i < 7; i++) {
				char c = hcl.charAt(i);
				if (!((c >= '0' && c <= '9')
						|| (c >= 'a' && c <= 'f'))) {
					return false;
				}
			}
			return true;
		}
	}
	
	public boolean isEclValid() {
		String ecl = fields.get("ecl");
		if (ecl == null) {
			return false;
		} 
		
		return (ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn")
				|| ecl.equals("gry") || ecl.equals("grn") || ecl.equals("hzl") 
				|| ecl.equals("oth"));
	}
	
	public boolean isPidValid() {
		String pid = fields.get("pid");
		if (pid == null) {
			return false;
		}
		
		if (pid.length() == 9) {
			for (int i = 0; i < pid.length(); i++) {
				if (!Character.isDigit(pid.charAt(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
