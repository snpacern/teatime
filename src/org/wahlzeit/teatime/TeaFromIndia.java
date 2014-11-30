package org.wahlzeit.teatime;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class TeaFromIndia extends ATeaFromCountry
{	
	public final static String INDterritory = "30.0,30.0";
	private final String quality = "Excellent Quality! :D";

	public TeaFromIndia(String location)
	{
		TeaTerritoryQuality.getInstance(location, this.quality);
	}	
	
	/*
	 * Returns the quality of a tea
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	public String getQuality() {
		assert(quality != null);
		assert(quality != "");
		return quality;
	}
}

