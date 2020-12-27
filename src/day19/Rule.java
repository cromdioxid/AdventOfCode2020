package day19;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	
	private List<String> rule1 = null;
	private List<String> rule2 = null;
	
	public Rule(List<String> r1, List<String> r2) {
		this.rule1 = r1;
		this.rule2 = r2;
	}
	
	public Rule(List<String> r1) {
		this.rule1 = r1;
	}
	
	public List<String> getRule1() {
		return rule1;
	}
	
	public List<String> getRule2() {
		return rule2;
	}
	
	public List<String> getAllRules() {
		List<String> rules = new ArrayList<String>();
		rules.addAll(this.rule1);
		if (this.rule2 !=null) {
			rules.addAll(this.rule2);
		}
		return rules;
	}
	
	public List<List<String>> getRulesAsLists() {
		List<List<String>> rules = new ArrayList<List<String>>();
		if (rule1 != null) {
			rules.add(rule1);
		}
		if (rule2 != null) {
			rules.add(rule2);
		}
		return rules;
	}
 
}
