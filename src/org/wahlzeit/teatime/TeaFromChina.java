package org.wahlzeit.teatime;

public class TeaFromChina extends ATeaFromCountry 
{
	
	final static String CHNterritory = "CHINA";
	private String quality = "Excellent Quality! :D";
	
	private static TeaFromChina instance = null;
	
	/*
	 * @methodtype Singleton
	 * @methodproperties primitive
	 */
	public static TeaFromChina getInstance()
	{
		if (instance == null)
		{
			return new TeaFromChina();
		}
		else
		{
			return instance;
		}
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

