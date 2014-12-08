package org.wahlzeit.teatime;



public class Pfefferminze implements TeaFactory {

	/*
	 * @methodtype create
	 */
	@Override
	public TeaCategories createCategoryObject(String location) {
		assert(!location.isEmpty());
		return new TeaCategories(location);
	}

}