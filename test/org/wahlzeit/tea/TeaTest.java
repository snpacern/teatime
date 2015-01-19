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

package org.wahlzeit.tea;

import junit.framework.*;

/**
 * 
 * @author dirkriehle
 *
 */
public class TeaTest extends TestCase {
	
	public TeaTest(String name) {
		super(name);
	}

	public void testTeaManager() {
		Tea chinaPeppermint = TeaManager.getInstance("45,45").search("Peppermint");
		
		String quality = chinaPeppermint.getQuality();
		
		System.out.println(quality);
		assertEquals("Superb! :D", quality);
	}
	
	public void testTeaBehaviour() {
		Tea chinaPeppermint = TeaManager.getInstance("45,45").search("Peppermint");
		
		RoleGeschuettelt behaviour = (RoleGeschuettelt)chinaPeppermint.getTeaBehaviour("geschuettelt");
		
		System.out.println(behaviour.getContent());
		assertEquals("Geschuettelt, nicht geruehrt! ;)", behaviour.getContent());
	}
	
	public void testTeaError() {
		Tea chinaPeppermint = TeaManager.getInstance("45,45").search("");
		
		RoleGeschuettelt behaviour = (RoleGeschuettelt)chinaPeppermint.getTeaBehaviour("geschuettelt");
		
		System.out.println(behaviour.getContent());
		assertEquals("Geschuettelt, nicht geruehrt! ;)", behaviour.getContent());
	}
	
}
