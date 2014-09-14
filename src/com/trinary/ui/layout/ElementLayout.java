package com.trinary.ui.layout;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="layout")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementLayout {
	@XmlAttribute
	protected String id;
	
	@XmlElement
	protected String type;
	
	@XmlElement
	protected Location location;
	
	@XmlElement
	protected Dimensions dimensions;
	
	@XmlElement
	protected Margins margins;
	
	@XmlElement
	protected String resource;
	
	@XmlElement
	protected Integer zIndex;
	
	@XmlElementWrapper(name="children")
	@XmlElement(name="layout")
	protected ArrayList<ElementLayout> children = new ArrayList<ElementLayout>();
	
	public ElementLayout() {
		super();
	}

	public ElementLayout(String type, String location, String width, String height, Integer zIndex, String resource) {
		super();
		this.type = type;
		this.location = new Location(location);
		this.dimensions = new Dimensions(width, height);
		this.zIndex = zIndex;
		this.resource = resource;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Margins getMargins() {
		return margins;
	}

	public void setMargins(Margins margins) {
		this.margins = margins;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public ArrayList<ElementLayout> getChildren() {
		return children;
	}

	public void addChild(ElementLayout child) {
		this.children.add(child);
	}

	public Integer getzIndex() {
		return zIndex;
	}

	public void setzIndex(Integer zIndex) {
		this.zIndex = zIndex;
	}
}
