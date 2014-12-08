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

package org.wahlzeit.teatime;

import org.wahlzeit.teatime.*;

import junit.framework.*;

/**
 * 
 * @author dirkriehle
 *
 */
public class QualityTest extends TestCase {
	
	/**
	 * 
	 */
	public QualityTest(String name) {
		super(name);
	}

	/**
	 * 
	 */
	public void testQuality() {

//		// For now only CHINA works, until I get TeaQuality to work
//		// properly with the Location interface ... :/
//		ITeaQualityPhoto tea = new TeaCategories("45.0,45.0");
//		
//		// Test for equality
//		assertEquals("Superb! :D", tea.asString());
//		// Test for inequality
//		assertNotSame("Not so good ... V:", tea.asString());
	}
	
	public void testValueObject() {
		
//		ATeaQualityPhoto chn1 = new TeaCategories("45.0,45.0");
//		ATeaQualityPhoto ind1 = new TeaCategories("30.0,30.0");
//		ATeaQualityPhoto chn2 = new TeaCategories("45.0,45.0");
//		
//		assertFalse(chn1.getQuality() == ind1.getQuality());
//		
//		TeaTerritoryQuality ttq1 = TeaTerritoryQuality.getInstance("45.0,45.0", "Superb! :D");
//		TeaTerritoryQuality ttq2 = TeaTerritoryQuality.getInstance("30.0,30.0", "Excellent Quality! :D");
//		TeaTerritoryQuality ttq3 = TeaTerritoryQuality.getInstance("45.0,45.0", "Superb! :D");
//
//		assertFalse(ttq1.equals(ttq2));
//		assertTrue(ttq1.equals(ttq3));
	}

	public void testTeaFactory() {
		
		TeaFactory tea = new Pfefferminze();		
		ATeaQualityPhoto teaQuality = tea.createCategoryObject("45.0,45.0");
		
		String quality = teaQuality.asString();
		
		System.out.println(quality);
		
	}
	
}
