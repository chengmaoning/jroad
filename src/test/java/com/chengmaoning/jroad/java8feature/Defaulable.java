/**
 * 
 */
package com.chengmaoning.jroad.java8feature;

/**
 * @author chengmaoning
 *
 */
public interface Defaulable {

	/**
	 * notRequired
	 * @return
	 */
	default String notRequired() {
		return "Defualt implementation";
	}

	static class DefaultableImpl implements Defaulable {
	}

	static class OverridableImpl implements Defaulable {
		@Override
		public String notRequired() {
			return "Override implementation";
		}
	}

}
