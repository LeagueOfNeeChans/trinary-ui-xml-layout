package com.trinary.ui.layout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {
	@XmlElement
	protected String 
				top = null, 
				left = null, 
				bottom = null, 
				right = null;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	public Location(String locString) {
		Pattern p = Pattern.compile("([0-9]+)(%|px)");
		String[] pairs = locString.split(",");
		
		for (String pair : pairs) {
			pair = pair.trim();
			String[] kv = pair.split(":");
			
			if (kv.length < 2) {
				continue;
			}
			
			kv[0] = kv[0].trim();
			kv[1] = kv[1].trim();
			
			Integer number = 0;
			String type = "px";
			Matcher match = p.matcher(kv[1]);
			
			if (match.find()) {
				if (match.group(1) != null) {
					number = Integer.parseInt(match.group(1));
				}
				
				if (match.group(2) != null) {
					type = match.group(2);
				}
			} else {
				return;
			}
			
			String position = number + type;
			
			switch(kv[0]) {
			case "top":
				top = position;
				break;
			case "left":
				left = position;
				break;
			case "bottom":
				bottom = position;
				break;
			case "right":
				right = position;
				break;
			}
		}
	}
	
	public String getTop() {
		return top;
	}

	public String getLeft() {
		return left;
	}

	public String getBottom() {
		return bottom;
	}

	public String getRight() {
		return right;
	}

	@Override
	public String toString() {
		return String.format(""
				+ "left:    %s\n"
				+ "top:     %s\n"
				+ "right:   %s\n"
				+ "bottom:  %s",
				left, top, right, bottom);
	}
}
