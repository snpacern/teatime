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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;

public class GPSLocation extends AbstractLocation
{
	private double latitude;
	private double longitude;
	
	public GPSLocation()
	{
		this.latitude = 0.0;
		this.longitude = 0.0;
	}
	
	public GPSLocation(double latitude, double longitude)
	{		
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	protected String convertToInternationalMapCodeCoordinates() 
	{
		final Mapcode p = MapcodeCodec.encodeToInternational(this.latitude, this.longitude);		
		return p.getMapcode();
	}

	@Override
	protected GPSCoordinates convertToGPSCoordinates() 
	{
		return new GPSCoordinates(latitude, longitude);
	}
	
	public String asString()
	{
		System.out.println("Latitude: " + latitude + ", Longitude: " + longitude);
		return Double.toString(latitude) + "," + Double.toString(longitude);
	}

	public Double getLatitude()
	{
		return latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
	
	@Override
	public String getIdAsString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readFrom(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOn(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeId(PreparedStatement stmt, int pos) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getString() {
		return "test";
	}
}