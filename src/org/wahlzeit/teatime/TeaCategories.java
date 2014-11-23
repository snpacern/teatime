package org.wahlzeit.teatime;
import java.util.List;
import org.wahlzeit.maps.coordinates.*;

public class TeaCategories extends ATeaQualityPhoto 
{
	/*
	 * #methodtype constructor
	 */
	public TeaCategories()
	{
		this.gpsLocation = "";
	}
	
	/*
	 * Constructor and initializer for territory map 
	 * #methodtype constructor
	 */
	public TeaCategories(String loc)
	{
		RegisterTerritory(TeaFromChina.CHNterritory, TeaFromChina.getInstance());
		this.gpsLocation = loc;
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
	public String getQuality(String territory) {
		assert(territory != null);
		assert(territory != "");
		
		territory = TeaFromChina.CHNterritory;
		String quality = m_territory.get(territory).getQuality();
		
		assert(quality != null);
		assert(quality != "");
		
		return quality;		
	}
	
	/*
	 * Returns a human readable description of the tea quality 
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	@Override
	public String asString() {
		return getQuality(gpsLocation);
	}
	
	private String gpsLocation;

}
