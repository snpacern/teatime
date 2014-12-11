package org.wahlzeit.tea;



public class Tea {
	
	public Tea(TeaType teaType) {
		System.out.println("Tea created.");
		
		this.teaTypeRef_ = teaType;
	}
		
	public String getQuality() {
		quality_ = TeaQuality.getInstance(this);
		return quality_.getQuality();
	}
	
	public String getLocation() {
		return teaTypeRef_.getLocation();
	}
	
	public String getTeaType() {
		return teaTypeRef_.getTeaType();
	}
	
	private TeaType teaTypeRef_;
	private ITeaQuality quality_;
	
}
