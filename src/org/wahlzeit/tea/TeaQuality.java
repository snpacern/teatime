package org.wahlzeit.tea;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;



public class TeaQuality implements ITeaQuality {

	public TeaQuality(Tea tea) {
		this.tea_ = tea;
	}

	public static TeaQuality getInstance(Tea tea) {		
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
	
	public String getQuality() {
		System.out.println("Getting TeaQuality.");
		return asString();
	}

	private String asString() {
		QualityValue qv = QualityValue.get(this.tea_.getLocation());
		return qv.getQuality();
	}
		
	static Map<Tea, WeakReference<TeaQuality>> cache = new LinkedHashMap<Tea, WeakReference<TeaQuality>>();	
	private Tea tea_;

}
