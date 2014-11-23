package org.wahlzeit.teatime;

import java.util.HashMap;
import java.util.Map;

public abstract class ATeaQualityPhoto implements ITeaQualityPhoto 
{

	/*
	 * Returns a human readable description of the tea quality 
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	public abstract String asString();	
	
	/*
	 * Registers a territory to the territory map
	 * @methodtype set
	 * @methodproperties primitive
	 */
	protected void RegisterTerritory(String territory, ATeaFromCountry tCat)
	{
		assert(territory != null);
		assert(territory != "");
		
		// 
		int assertSize = m_territory.size();
		assert(assertSize >= 0);
		
		m_territory.put(territory, tCat);
		
		// This postcondition ONLY works as I have not
		// implemented a duplicate check yet!
		assert(m_territory.size() > assertSize);
		
//		for (String key : m_territory.keySet())
//		{
//			if (!m_territory.containsKey(key))
//			{
//				
//				m_territory.put(territory, tCat);
//			}
//		}
	}
	
	protected static Map<String, ATeaFromCountry> m_territory = new HashMap<String, ATeaFromCountry>();
	
}
