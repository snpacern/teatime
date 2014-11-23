package org.wahlzeit.maps.coordinates;

import org.wahlzeit.model.PhotoId;

public interface Location {

	public void addLocationToPhoto(PhotoId id, String mapCode);
	public void addLocationToPhoto(PhotoId id, double latitude, double longitude) throws IllegalArgumentException;
	
	public GPSCoordinates getGPSLocationFromPhoto(PhotoId id);	
	public String getInternationalMapCodeLocationFromPhoto(PhotoId id);
	
	public String asString();
	public String getString();
}
