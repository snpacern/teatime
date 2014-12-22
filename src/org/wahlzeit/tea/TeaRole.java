package org.wahlzeit.tea;

/*
 * TeaRole has a collaboration with TeaCore.
 */



public class TeaRole implements TeaBehaviour {
	
	@Override
	public TeaRole getRole(String spec) {
		return teaCore_.getRole(spec);
	}

	@Override
	public void addRole(String spec) {
		teaCore_.addRole(spec);
	}

	@Override
	public String getName() {
		return null;
	} 
	
	static TeaRole createFor(String spec, TeaCore teaCore) {
		Creator roleCreator = lookUp(spec);
		if (roleCreator == null)	
			return null;
		
		TeaRole newRole = roleCreator.create();
		if (newRole != null)
			newRole.teaCore_ = teaCore;
		
		return newRole;
	}
	
	private static Creator lookUp(String spec) {
		return new Creator(spec);
	}
	
	private TeaCore teaCore_;
	
}
