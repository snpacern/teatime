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

package org.wahlzeit.coordinates;

import org.wahlzeit.maps.coordinates.AbstractLocation;
import org.wahlzeit.maps.coordinates.GPSCoordinates;
import org.wahlzeit.maps.coordinates.GPSLocation;
import org.wahlzeit.maps.coordinates.InternationalMapCodeLocation;
import org.wahlzeit.model.PhotoId;

import junit.framework.*;

/**
 * 
 * @author dirkriehle
 *
 */
public class ConversionTest extends TestCase {
	
	/**
	 * 
	 */
	public ConversionTest(String name) {
		super(name);
	}

	/**
	 * NOTE: I had to disable the test due to redesign of the interface!
	 */
	public void testConversion() {
		double latitude = 45;
		double longitude = 50;
		
//		PhotoId id = PhotoId.getNextId(); 
//		
//		AbstractLocation location = new GPSLocation(latitude, longitude);
//		location.addLocationToPhoto(id, latitude, longitude);
//		
//		String mapCode = AbstractLocation.getInternationalMapCodeLocationFromPhoto(id);
//		
//		location = new InternationalMapCodeLocation(mapCode);
//		location.addLocationToPhoto(id, mapCode);
//		
//		GPSCoordinates gps = AbstractLocation.getGPSLocationFromPhoto(id);
//
//		assertTrue( (latitude == Math.floor(gps.getLat())) || (latitude == Math.ceil(gps.getLat())) );
//		assertTrue( (longitude == Math.floor(gps.getLong())) || (longitude == Math.ceil(gps.getLong())) );
	}

}
