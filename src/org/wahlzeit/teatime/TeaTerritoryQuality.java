package org.wahlzeit.teatime;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;



public class TeaTerritoryQuality implements Serializable
{
	private static final long serialVersionUID = 1068538253233559877L;
	
	public TeaTerritoryQuality(String location, String quality)
	{
		this.location = location;
		this.quality = quality;
	}
	
	public static TeaTerritoryQuality getInstance(String location, String quality)
	{		
		System.out.println(":D");
		WeakReference<TeaTerritoryQuality> cached = cache.get(location);
		if (cached == null)
		{
			cached = new WeakReference<TeaTerritoryQuality>(new TeaTerritoryQuality(location, quality));
			cache.put(location, new WeakReference<TeaTerritoryQuality>(cached.get()));
		}
		
		return cached.get();
	}
	
	public String getQuality()
	{
		return this.quality;
	}
	
	static Map<String, WeakReference<TeaTerritoryQuality>> cache = new LinkedHashMap<String, WeakReference<TeaTerritoryQuality>>();
	
	private String location;
	private String quality;
	
}
