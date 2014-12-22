package org.wahlzeit.tea;

/*
 * Tea has a TeaType and has a compositional relationship
 * with TeaQuality. It uses the ITeaQuality interface to
 * get information about the quality of the tea.
 * 
 * Tea has a Collaboration with TeaType and TeaManager.
 */



public class Tea {
	
	/*
	 * @methodtype constructor
	 */
	public Tea(TeaType teaType) {
		System.out.println("Tea created.");		
		this.teaTypeRef_ = teaType;
		teaBehaviour_ = new TeaCore();
	}
		
	/*
	 * @methodtype get
	 * @methodproperties composed
	 */
	public String getQuality() {
		quality_ = TeaQuality.getInstance(this);
		assert(quality_ != null);
		return quality_.getQuality();
	}
	
	/*
	 * @methodtype get
	 * @methodproperties primitive
	 */
	public String getLocation() {
		return teaTypeRef_.getLocation();
	}

	/*
	 * @methodtype get
	 * @methodproperties primitive
	 */
	public String getTeaType() {
		System.out.println("getTeaType()");
		return teaTypeRef_.getTeaType();
	}
	
	public TeaBehaviour getTeaBehaviour(String behaviourType) {
		return teaBehaviour_.getRole(behaviourType);
	}
	
	private TeaBehaviour teaBehaviour_;
	private TeaType teaTypeRef_;
	private ITeaQuality quality_;
	
}
