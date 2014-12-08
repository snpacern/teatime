package org.wahlzeit.teatime;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class TeaFromChina extends ATeaFromCountry
{
	public final static String CHNterritory = "45.0,45.0";
	private final String quality = "Excellent Quality! :D";

	public TeaFromChina(String location)
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

