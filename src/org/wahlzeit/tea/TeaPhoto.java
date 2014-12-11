package org.wahlzeit.tea;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.ModelConfig;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;



public class TeaPhoto extends Photo 
{
	
	public static final String QUALITY = "quality";
	public static final String TEATYPE = "peppermint";
	
	protected Tea teaQuality = null;

	public TeaPhoto(){
		super();
	}
	public TeaPhoto(PhotoId id){
		super(id);		
	}
	public TeaPhoto(ResultSet rs) throws SQLException{
		super(rs);
	}
	
	public void setTeaQuality(Tea teaTime)
	{
		teaQuality = teaTime;
		incWriteCount();
	}
	public String getTeaQuality(ModelConfig cfg)
	{
		return cfg.getTeaQuality(teaQuality.getQuality());
	}
	
	public void readFrom(ResultSet rset) throws SQLException 
	{
		super.readFrom(rset);
		teaQuality = TeaManager.getInstance(creationLocation.asString()).search(TEATYPE);
	}
	
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		rset.updateString("quality", teaQuality.getQuality());
	}
	
}
