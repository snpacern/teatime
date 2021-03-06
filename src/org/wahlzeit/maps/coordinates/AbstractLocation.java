/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.maps.coordinates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.DataObject;

import com.mapcode.Mapcode;

public abstract class AbstractLocation extends DataObject implements Location 
{	
	private static Map<PhotoId, AbstractLocation> locationMap = new HashMap<PhotoId, AbstractLocation>();

	abstract protected String convertToInternationalMapCodeCoordinates();
	abstract protected GPSCoordinates convertToGPSCoordinates();
	
	public void addLocationToPhoto(PhotoId id, String mapCode)
	{	
		AbstractLocation location = new InternationalMapCodeLocation(mapCode);
		locationMap.put(id, location);
	}

	public void addLocationToPhoto(PhotoId id, double latitude, double longitude) throws IllegalArgumentException
	{
		if (latitude > 90 || latitude < -90)
		{
			throw new IllegalArgumentException();
		}
		if (longitude > 180 || longitude < -180)
		{
			throw new IllegalArgumentException();
		}
		
		AbstractLocation location = new GPSLocation(latitude, longitude);
		locationMap.put(id, location);
	}
	
	public GPSCoordinates getGPSLocationFromPhoto(PhotoId id)
	{
		GPSCoordinates gps = locationMap.get(id).convertToGPSCoordinates();		
		return gps;
	}
	
	public String getInternationalMapCodeLocationFromPhoto(PhotoId id)
	{
		return locationMap.get(id).convertToInternationalMapCodeCoordinates();	
	}
	
	public String covertToMapCodeLocationFromString(String location)
	{
		String[] coordinates = location.split(",");
		GPSLocation gps = new GPSLocation(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
		return gps.convertToInternationalMapCodeCoordinates();
	}
	
	public List<String> getTerritoryFromGPS(String gpsLocation)
	{
		GPSLocation gps = GPSLocation.getInstance();
		return gps.getTerritoryFromGPS(gpsLocation);		
	}
}


