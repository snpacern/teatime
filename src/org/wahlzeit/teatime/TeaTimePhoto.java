package org.wahlzeit.teatime;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.ModelConfig;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;



public class TeaTimePhoto extends Photo 
{
	public static final String QUALITY = "quality";
	protected ITeaQualityPhoto teaQuality;
	
	public TeaTimePhoto(){
		super();
	}
	public TeaTimePhoto(PhotoId id){
		super(id);		
	}
	public TeaTimePhoto(ResultSet rs) throws SQLException{
		super(rs);
	}
	
	public void setTeaQuality(ITeaQualityPhoto teaTime)
	{
		teaQuality = teaTime;
		incWriteCount();
	}
	public String getTeaQuality(ModelConfig cfg)
	{
		return cfg.getTeaQuality(teaQuality.asString());
	}
	
	public void readFrom(ResultSet rset) throws SQLException 
	{
		super.readFrom(rset);
		teaQuality = new TeaCategories(creationLocation.asString());
	}
	
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		rset.updateString("quality", teaQuality.asString());
	}
	
}
