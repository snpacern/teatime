package org.wahlzeit.teatime;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.ModelConfig;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;



public class TeaPhoto extends Photo 
{
	
	TeaFactory tea = new Pfefferminze();
	
	public static final String QUALITY = "quality";
	
	protected ITeaQualityPhoto teaQuality = null;

	public TeaPhoto(){
		super();
	}
	public TeaPhoto(PhotoId id){
		super(id);		
	}
	public TeaPhoto(ResultSet rs) throws SQLException{
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
