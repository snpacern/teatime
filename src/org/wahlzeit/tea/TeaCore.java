package org.wahlzeit.tea;

import java.util.HashMap;
import java.util.Map;

/*
 * TeaCore has a collaboration with TeaRole.
 */



public class TeaCore implements TeaBehaviour {
	
	public TeaRole getRole(String spec) {
		if (spec.isEmpty() || spec == null) {
			throw new IllegalArgumentException();
		}
		
		Creator c = new Creator(spec);
		return c.get();
	}
	
	@Override
	public String getName() {
		return null;
	}
	
	public void addRole(String spec) {
		TeaRole teaRole = getRole(spec);
		if (teaRole == null) {
			teaRole = TeaRole.createFor(spec, this);
			
//			if (teaRole != null) 
//				m_roles_.put(spec, teaRole);
		}
	}
	
	//private Map<String, TeaRole> m_roles_ = new HashMap<String, TeaRole>();

}
