package org.wahlzeit.tea;

import java.util.HashMap;
import java.util.Map;



public class TeaManager {

	private TeaManager(String location) {
		this.location_ = location;
	}
	
	static private TeaManager instance = null;
	
	static public TeaManager getInstance(String location) {
		if (instance == null) {
			System.out.println("TeaManager created.");
			return new TeaManager(location);
		}
		
		System.out.println("TeaManager created.");
		
		return instance;
	}
	
	public Tea search(String typeName) {
		System.out.println("typeName: " + typeName + ", location: " + this.location_);		
		return new TeaType(typeName, this.location_).newInstance();
	}
	
	private String location_;
	Map<String, Tea> loadedTeas_ = new HashMap<String, Tea>();
	
}
