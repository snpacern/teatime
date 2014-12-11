package org.wahlzeit.tea;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;



public enum QualityValue {
	
	CHINA("45.0,45.0", "Superb! :D"),
	INDIA("30.0,30.0", "Excellent quality! ;)");
			
	public String getLocation() {
		return this.location_;
	}
	
	public String getQuality() {
		return this.quality_;
	}
	
	public static QualityValue get(String location) {
		System.out.println("Getting QualityValue from location: " + location);
		String lookUpString = isValid(location);
		return lookUp.get(lookUpString);
	}
	
	private QualityValue(String location, String quality) {
		this.location_ = location;
		this.quality_ = quality;
	}
	
	private static String isValid(String location) {
		String validLocation = null;
		String[] coordinates = location.split(",");
		if (!coordinates[0].contains(".")) {
			validLocation = coordinates[0];
			validLocation += ".0,";
		}
		if (!coordinates[1].contains(".")) {
			validLocation += coordinates[1] + ".0";
		}
	
		return validLocation;
	}
	
	private final String location_;
	private final String quality_;
	
	private static final Map<String, QualityValue> lookUp = 
			new HashMap<String, QualityValue>();
	
	static {
		for (QualityValue qv : EnumSet.allOf(QualityValue.class))
			lookUp.put(qv.getLocation(), qv);
		
		System.out.println("Populated Map.");
	}
	

	
}
