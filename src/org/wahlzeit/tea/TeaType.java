package org.wahlzeit.tea;

/*
 * TeaType is a Type Object for Tea. It holds information 
 * on the location and quality of respective tea.
 */



public class TeaType {
		
	/*
	 * @methodtype constructor
	 */
	public TeaType(String typeName, String location) {
		assert(!typeName.isEmpty() && !location.isEmpty());
		this.typeName_ = typeName;
		this.location_ = location;
	}
	
	/*
	 * @methodtype factory
	 * @methodproperties class 
	 */
	public Tea newInstance() {
		return new Tea(this);
	}
	
	/*
	 * @methodtype get
	 * @methodproperties primitive
	 */
	public String getLocation() {
		return this.location_;
	}
	
	/*
	 * @methodtype get
	 * @methodproperties primitive
	 */
	public String getTeaType() {
		return this.typeName_;
	}
		
	private String typeName_;
	private String location_;
	
}
