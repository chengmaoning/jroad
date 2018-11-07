/**
 * 
 */
package com.chengmaoning.jroad.aop;

/**
 * AspectClass.java
 * 
 * @author chengmaoning
 *
 *         2018年7月5日下午7:01:50
 */
public class AspectClass {

	public void afterReturn(String first, String second) {
		System.out.println("add user: " + first + "." + second + " success.");
	}
}
