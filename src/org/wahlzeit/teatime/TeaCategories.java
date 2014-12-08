package org.wahlzeit.teatime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.wahlzeit.maps.coordinates.*;

public class TeaCategories extends ATeaQualityPhoto 
{	
	/*
	 * @methodtype constructor
	 */
	public TeaCategories()
	{
		this.gpsLocation = "";
	}
	
	/*
	 * Constructor and initializer for territory map 
	 * @methodtype constructor
	 */
	public TeaCategories(String location)
	{
		System.out.println("Creating TeaCategory");
		// I cannot check for the validity of loc because 
		// I'm unable to use my Location interface, this is
		// why I'm omitting the precondition check here
		//RegisterTerritory(TeaFromChina.CHNterritory, TeaFromChina.getInstance());
		// Check postcondition
		assert(m_territory.size() >= 0);
		
		this.gpsLocation = location;
	}
	
	/*
	 * Finds territories via Location Interface,
	 * converts those into Strings and returns them
	 * @bug Produces StackOverflow for some reason V:
	 * @methodtype get
	 * @methodproperties composed
	 */
	protected String findTerritories(String territory)
	{
		assert(!territory.isEmpty());
		String[] coordinates = territory.split(",");
		Location gps = GPSLocation.getInstance();
		List<String> possibleTerritories = gps.getTerritoryFromGPS(territory);
		
		for (String t : possibleTerritories)
		{
			System.out.println(t);
		}
		
		return territory;
	}
	
	/*
	 * Returns the quality of a tea (depending on it's origin)
	 * @methodtype get
	 * @methodproperties primitive
	 */
	public String getQuality(String location) {
		gpsLocation = location;
		System.out.println("Looking for Territory " + gpsLocation);
		// Precondition: territory not null or empty
		// territory is usually valid, as it is checked by MapCode
		// (which I am currently not able to use, as my Location interface
		// seems to be incorrectly implemented)
		assert(gpsLocation != null);
		assert(gpsLocation != "");
			
		
		// just a little failsafe
		if (!location.contains(".")) 
			location = "45.0,45.0";
		
		// For now: set territory manually to China
		//gpsLocation = TeaFromChina.CHNterritory;
		TeaTerritoryQuality quality = m_territory.get(location);
		
		// Postcondition: quality not null or empty
		assert(quality.getQuality() != null);
		assert(quality.getQuality() != "");
		
		return quality.getQuality();		
	}
	
	/*
	 * Returns a human readable description of the tea quality 
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	@Override
	public String asString() {
		String ret_quality = getQuality(gpsLocation);
		assert(ret_quality != null);
		assert(ret_quality != "");
		
		return ret_quality;
	}
	
	private String gpsLocation;

}
