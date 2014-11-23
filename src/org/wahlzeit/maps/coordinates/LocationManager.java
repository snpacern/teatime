package org.wahlzeit.maps.coordinates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;
import org.wahlzeit.services.SysLog;

public class LocationManager extends ObjectManager
{

	/**
	 * 
	 */
	protected static final LocationManager instance = new LocationManager();
	
	@Override
	protected Persistent createObject(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 */
	public static final LocationManager getInstance() {
		return instance;
	}
	
	public void addLocation(AbstractLocation location) {
		
		try {
			PreparedStatement stmt = getReadingStatement("INSERT INTO photos(id) VALUES(?)");
			createObject(location, stmt, 1);
			ServiceMain.getInstance().saveGlobals();
		} catch (SQLException sex) {
			SysLog.logThrowable(sex);
		}      
        
		}
}
