/**
 * 
 */
package com.chengmaoning.jroad;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * HelloWorld.java
 * 
 * @author chengmaoning
 *
 *         2017年7月13日下午3:01:36
 */
public class HelloWorld {

	private static final Log logger = LogFactory.getLog(HelloWorld.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("hello world!");

		test(Arrays.asList("hello", "world"));

		System.out.println(System.getProperty("java.home"));

		logger.error("this is log text.");
	}

	public static void test(List<String> strings) {
		System.out.println(strings.toString());
	}

}
