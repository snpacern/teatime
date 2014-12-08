package org.wahlzeit.teatime;

import java.util.Collections;
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
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	public abstract String getQuality(String location);
	
	protected final static Map<String, TeaTerritoryQuality> m_territory;
	static
	{
		Map<String, TeaTerritoryQuality> t_Map = new HashMap<String, TeaTerritoryQuality>();		
		t_Map.put(TeaFromChina.CHNterritory, TeaTerritoryQuality.getInstance(TeaFromChina.CHNterritory, "Superb! :D"));
		t_Map.put(TeaFromIndia.INDterritory, TeaTerritoryQuality.getInstance(TeaFromIndia.INDterritory, "Excellent Quality! :D"));
		
		m_territory = Collections.unmodifiableMap(t_Map);
	}
	
	
}
