package com.trinary.ui.layout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositionValue {
	protected Integer number;
	protected String unit;
	
	protected static Pattern regex = Pattern.compile("([0-9]+)(px|%)");
	
	public PositionValue(String s) {
		Matcher m = regex.matcher(s);
		
		if (m.find()) {
			this.number = Integer.parseInt(m.group(1));
			this.unit = m.group(2);
		}
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
