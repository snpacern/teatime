package org.wahlzeit.tea;

/*
 * TeaBehaviour is a Role Pattern. It is the interface
 * for TeaRole and TeaCore.
 */



public interface TeaBehaviour {

	public TeaRole getRole(String spec);
	
	public void addRole(String spec);
	
	public String getName();
	
}
