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
import java.util.List;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

public class InternationalMapCodeLocation extends AbstractLocation
{	
	private String mapCode;
	
	public InternationalMapCodeLocation(String mapCode)
	{
		this.mapCode = mapCode;
	}

	@Override
	protected String convertToInternationalMapCodeCoordinates() 
	{
		return mapCode;
	}

	@Override
	protected GPSCoordinates convertToGPSCoordinates() 
	{
		Point p = null;
		
		try 
		{
			p = MapcodeCodec.decode(this.mapCode);
		} 
		catch (UnknownMapcodeException e) 
		{
			e.printStackTrace();
		}
		
		return new GPSCoordinates(p.getLatDeg(), p.getLonDeg());
	}

	public String asString()
	{
		return mapCode;
	}

	public List<String> getTerritoryFromGPS(String gpsLocation)
	{
		String[] coordinates = gpsLocation.split(",");		
		List<Mapcode> results = MapcodeCodec.encode(Double.parseDouble(coordinates[0]),Double.parseDouble(coordinates[1]));
		
		List<String> convertedResults = null;
		
		for (Mapcode code : results)
		{
			convertedResults.add(code.getTerritory().getFullName());
		}
		
		return convertedResults;
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