package org.wahlzeit.teatime;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;



public class TeaTerritoryQuality implements Serializable
{
	private static final long serialVersionUID = 1068538253233559877L;
	
	
	/*
	 * @methodtype ctor
	 */
	public TeaTerritoryQuality(String location, String quality)
	{
		this.location = location;
		this.quality = quality;
	}
	
	/*
	 * @methodtype get
	 */
	public static TeaTerritoryQuality getInstance(String location, String quality)
	{		
		assert(!location.isEmpty() && !quality.isEmpty());
		WeakReference<TeaTerritoryQuality> cached = cache.get(location);
		if (cached == null)
		{
			cached = new WeakReference<TeaTerritoryQuality>(new TeaTerritoryQuality(location, quality));
			cache.put(location, new WeakReference<TeaTerritoryQuality>(cached.get()));
		}
		
		assert(!cached.equals(null));
		
		return cached.get();
	}
	
	/*
	 * @methodtype get
	 */
	public String getQuality()
	{
		return this.quality;
	}
	
	static Map<String, WeakReference<TeaTerritoryQuality>> cache = new LinkedHashMap<String, WeakReference<TeaTerritoryQuality>>();
	
	private String location;
	private String quality;
	
}
