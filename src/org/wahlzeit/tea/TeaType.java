package org.wahlzeit.tea;



public class TeaType {
		
	public TeaType(String typeName, String location) {
		this.typeName_ = typeName;
		this.location_ = location;
	}
	
	public Tea newInstance() {
		return new Tea(this);
	}
	
	public String getLocation() {
		return this.location_;
	}
	
	public String getTeaType() {
		return this.typeName_;
	}
		
	private String typeName_;
	private String location_;
	
}
