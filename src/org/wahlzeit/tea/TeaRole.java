package org.wahlzeit.tea;

/*
 * TeaRole has a collaboration with TeaCore.
 */



public class TeaRole implements TeaBehaviour {
	
	@Override
	public TeaRole getRole(String spec) {
		if (spec.isEmpty() || spec == null) {
			throw new IllegalArgumentException();
		}
		
		return teaCore_.getRole(spec);
	}

	@Override
	public void addRole(String spec) {
		if (spec.isEmpty() || spec == null) {
			throw new IllegalArgumentException();
		}
		
		teaCore_.addRole(spec);
	}

	@Override
	public String getName() {
		return null;
	} 
	
	static TeaRole createFor(String spec, TeaCore teaCore) {
		if (spec.isEmpty() || spec == null) {
			throw new IllegalArgumentException();
		}
		if (teaCore == null) {
			throw new IllegalArgumentException();
		}
		
		Creator roleCreator = lookUp(spec);
		if (roleCreator == null)	
			return null;
		
		TeaRole newRole = roleCreator.create();
		if (newRole != null)
			newRole.teaCore_ = teaCore;
		
		return newRole;
	}
	
	private static Creator lookUp(String spec) {
		//  Error handling delegated to Creator.java
		return new Creator(spec);
	}
	
	private TeaCore teaCore_;
	
}
