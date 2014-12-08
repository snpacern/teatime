/*
 * Interface for determining the tea quality.
 * Originally I wanted to make it possible to get the 
 * locations via MapCode, but for some reason
 * all I get is an StackOverflow error, probably
 * because I implemented my Location classes wrong at 
 * some point. I'll revisit those some other time.
 */

package org.wahlzeit.teatime;



public interface ITeaQualityPhoto {

	/*
	 * Returns a human readable description of the tea quality 
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	public String asString();
	
	/*
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	public String getQuality(String location);
	
	
}
