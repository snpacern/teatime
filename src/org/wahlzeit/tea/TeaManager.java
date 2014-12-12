package org.wahlzeit.tea;

import java.util.HashMap;
import java.util.Map;

/*
 * TeaManager searches it's HashMap (not implemented yet) for
 * occurences of the parameter passed by the search method. If
 * successfull, a new Tea instance is created along with its
 * corresponding teaType. 
 */



public class TeaManager {

	/*
	 * @methodtype constructor
	 */
	private TeaManager(String location) {
		this.location_ = location;
	}
	
	static private TeaManager instance = null;
	
	/*
	 * @methodtype factory
	 * @methodproperties class
	 */
	static public TeaManager getInstance(String location) {
		if (instance == null) {
			System.out.println("TeaManager created.");
			return new TeaManager(location);
		}
		
		System.out.println("TeaManager created.");
		
		return instance;
	}
	
	/*
	 * @methodtype factory
	 * @methodproperties class
	 */
	public Tea search(String typeName) {
		System.out.println("typeName: " + typeName + ", location: " + this.location_);		
		return new TeaType(typeName, this.location_).newInstance();
	}
	
	private String location_;
	Map<String, Tea> loadedTeas_ = new HashMap<String, Tea>();
	
}
