package org.wahlzeit.tea;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/*
 * QualityValue is an enum class that holds the location
 * and associated quality of different teatypes. Note that
 * for demonstration purposed, the number of enum entries
 * are kept to a minimum. For larger classes we would use 
 * several enum classes, each of which would represent in-
 * formation about one particular type of tea.
 */



public enum QualityValue {
	
	CHINA("45.0,45.0", "Superb! :D"),
	INDIA("30.0,30.0", "Excellent quality! ;)");
			
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
	public String getQuality() {
		return this.quality_;
	}
	
	/*
	 * @methodtype get
	 * @methodproperties composed
	 */
	public static QualityValue get(String location) {
		assert(!location.isEmpty());
		assert(location.contains(","));
		System.out.println("Getting QualityValue from location: " + location);
		String lookUpString = isValid(location);
		return lookUp.get(lookUpString);
	}
	
	/*
	 * @methodtype constructor
	 */
	private QualityValue(String location, String quality) {
		this.location_ = location;
		this.quality_ = quality;
	}
	
	/*
	 * @methodtype helper
	 * @methodproperties convenience
	 */
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
	
		assert(!validLocation.isEmpty() && validLocation != null);
		
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
