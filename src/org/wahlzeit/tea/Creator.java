package org.wahlzeit.tea;

import java.util.HashMap;
import java.util.Map;



public class Creator {
	
	public Creator(String spec) {
		spec_ = spec;
	}
	
	public TeaRole create() {
		return null;
	}
	
	public TeaRole get() {
		return m_roles_.get(spec_);	
	}
	
	private static Map<String, TeaRole> m_roles_ = new HashMap<String, TeaRole>();
	
	static {
		m_roles_.put("geschuettelt", new RoleGeschuettelt());
		m_roles_.put("geruehrt", new RoleGeruehrt());
	}
	
	private String spec_;

}
