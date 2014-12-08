package org.wahlzeit.teaflowers;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.model.*;



public class FlowerPhotoManager extends PhotoManager {

	private Map<String, Flower> loadedFlowers = new HashMap<String, Flower>();
	
	/*
	 * @methodtype ctor
	 */
	public FlowerPhotoManager() {
	}
	
	protected static final FlowerPhotoManager instance = new FlowerPhotoManager();
	public static final FlowerPhotoManager getInstance() {
		return instance;
	}
	
	public Flower search(String flowerType) {
		return loadedFlowers.get(flowerType);		
	}	
}
