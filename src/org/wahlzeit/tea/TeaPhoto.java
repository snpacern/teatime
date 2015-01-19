package org.wahlzeit.tea;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.ModelConfig;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;



public class TeaPhoto extends Photo {
	
	public static final String QUALITY = "quality";
	
	// TEATYPE is a constant here, but it can easily be
	// used as a variable that can be set e.g. via the
	// UI
	public static final String TEATYPE = "peppermint";
	
	protected Tea tea = null;

	/*
	 * @methodtype constructor
	 */
	public TeaPhoto(){
		super();
	}
	
	/*
	 * @methodtype constructor 
	 */
	public TeaPhoto(PhotoId id){
		super(id);		
	}
	
	/*
	 * @methodtype constructor
	 */
	public TeaPhoto(ResultSet rs) throws SQLException{
		super(rs);
	}
	
	/*
	 * @methodtype set
	 * @methodproperties composed
	 */
	public void setTeaQuality(Tea teaTime)
	{
		if (teaTime == null) {
			throw new IllegalArgumentException();
		}
		
		tea = teaTime;
		incWriteCount();
	}
	
	/*
	 * @methodtype get
	 * @methodproperties primitive
	 */
	public String getTeaQuality(ModelConfig cfg)
	{
		if (cfg == null) {
			throw new IllegalArgumentException();
		}
		
		return cfg.getTeaQuality(tea.getQuality());
	}
	
	/*
	 * @methodtype get
	 * @methodproperties composed
	 */
	public void readFrom(ResultSet rset) throws SQLException 
	{
		super.readFrom(rset);
		tea = TeaManager.getInstance(creationLocation.asString()).search(TEATYPE);
	}
	
	/*
	 * @methodtype set
	 * @methodproperties composed
	 */
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		rset.updateString("quality", tea.getQuality());
	}
	
}
