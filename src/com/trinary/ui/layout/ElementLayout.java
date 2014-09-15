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
	protected Alignment alignment;
	
	@XmlElement
	protected String resource;
	
	@XmlElement
	protected Integer zIndex;
	
	@XmlElement
	protected String transparency;
	
	@XmlElementWrapper(name="children")
	@XmlElement(name="layout")
	protected ArrayList<ElementLayout> children;
	
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
		if (this.children == null) {
			 this.children = new ArrayList<ElementLayout>();
		}
		this.children.add(child);
	}

	public Integer getzIndex() {
		return zIndex;
	}

	public void setzIndex(Integer zIndex) {
		this.zIndex = zIndex;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public String getTransparency() {
		return transparency;
	}

	public void setTransparency(String transparency) {
		this.transparency = transparency;
	}

	@Override
	public String toString() {
		return "ElementLayout [id=" + id + ", type=" + type + ", location="
				+ location + ", dimensions=" + dimensions + ", margins="
				+ margins + /*", alignment=" + alignment +*/ ", resource="
				+ resource + ", zIndex=" + zIndex + ", transparency="
				+ transparency + ", children=" + children + "]";
	}
}
