package org.wahlzeit.maps.coordinates;

import java.util.List;

import org.wahlzeit.model.PhotoId;

import com.mapcode.Mapcode;

public interface Location {

	public void addLocationToPhoto(PhotoId id, String mapCode);
	public void addLocationToPhoto(PhotoId id, double latitude, double longitude) throws IllegalArgumentException;
	
	public GPSCoordinates getGPSLocationFromPhoto(PhotoId id);	
	public String getInternationalMapCodeLocationFromPhoto(PhotoId id);
	public String covertToMapCodeLocationFromString(String location);
	
	public List<String> getTerritoryFromGPS(String gpsLocation);
	
	public String asString();
	public String getString();
}
