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
	
	protected String locationString;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	public Location(String locString) {
		this.locationString = locString;
		
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
	
	public Integer getTopPx() {
		return Integer.parseInt(top.substring(0, top.indexOf("px")).trim());
	}
	
	public Integer getLeftPx() {
		return Integer.parseInt(left.substring(0, left.indexOf("px")).trim());
	}

	public Integer getBottomPx() {
		return Integer.parseInt(bottom.substring(0, bottom.indexOf("px")).trim());
	}

	public Integer getRightPx() {
		return Integer.parseInt(right.substring(0, right.indexOf("px")).trim());
	}

	public String getLocationString() {
		StringBuilder sb = new StringBuilder();
		String separator = "";
		
		if (top != null) {
			sb.append(separator + String.format("top: %s", top));
			separator = ", ";
		}
		if (left != null) {
			sb.append(separator + String.format("left: %s", left));
			separator = ", ";
		}
		if (bottom != null) {
			sb.append(separator + String.format("bottom: %s", bottom));
			separator = ", ";
		}
		if (right != null) {
			sb.append(separator + String.format("right: %s", right));
			separator = ", ";
		}
		
		return sb.toString();
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	@Override
	public String toString() {
		return "Location [top=" + top + ", left=" + left + ", bottom=" + bottom
				+ ", right=" + right + "]";
	}
}
