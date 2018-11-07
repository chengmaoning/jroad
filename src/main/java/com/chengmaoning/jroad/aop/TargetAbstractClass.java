/**
 * 
 */
package com.chengmaoning.jroad.aop;

/**
 * TargetAbstractClass.java
 * 
 * @author chengmaoning
 *
 *         2018年9月17日上午10:20:33
 */
public abstract class TargetAbstractClass implements TargetInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chengmaoning.jroad.aop.TargetInterface#addUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int addUser(String first, String second) {
		return _addUser(first, second);
	}

	protected abstract int _addUser(String first, String second);

}
