package org.wahlzeit.tea;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * TeaQuality is a Value Object. It uses a WeakReference HashMap that 
 * enables TeaQuality to be a shared Value Object. It uses location
 * information to get information about tea quality values.
 * 
 * TeaQuality has a collaboration with QualityValue.
 */



public class TeaQuality implements ITeaQuality {

	/*
	 * @methodtype constructor
	 */
	public TeaQuality(Tea tea) {
		this.tea_ = tea;
	}

	/*
	 * @methodtype factory
	 * @methodproperties class
	 */
	public static TeaQuality getInstance(Tea tea) {		
		assert(tea != null);
		
		WeakReference<TeaQuality> cached = cache.get(tea);
		if (cached == null)
		{
			cached = new WeakReference<TeaQuality>(new TeaQuality(tea));
			cache.put(tea, new WeakReference<TeaQuality>(cached.get()));
		}
		
		assert(!cached.equals(null));
		
		System.out.println("Getting respective TeaQuality instance.");
		
		return cached.get();
	}
	
	/*
	 * @methodtype get
	 * @methodproperties primitive, hook
	 */
	public String getQuality() {
		System.out.println("Getting TeaQuality.");
		return asString();
	}

	/*
	 * @methodtype helper
	 * @methodproperties convenience, composed
	 */
	private String asString() {
		QualityValue qv = QualityValue.get(this.tea_.getLocation());
		assert(qv != null);
		return qv.getQuality();
	}
		
	static Map<Tea, WeakReference<TeaQuality>> cache = new LinkedHashMap<Tea, WeakReference<TeaQuality>>();	
	private Tea tea_;

}
