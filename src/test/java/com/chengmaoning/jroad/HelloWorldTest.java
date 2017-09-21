/**
 * 
 */
package com.chengmaoning.jroad;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * HelloWorldTest.java
 * 
 * @author chengmaoning
 *
 *         2017年7月13日下午4:38:16
 */
public class HelloWorldTest {

	private static final Log logger = LogFactory.getLog(HelloWorldTest.class);

	@Test
	public void test() {
		System.out.println("inside a test.");
		List<String> expOrderIds = Arrays.asList("1");

		StringBuffer sb = new StringBuffer("(");
		for (String order : expOrderIds) {
			sb.append("'").append(order).append("',");
		}
		sb.deleteCharAt(sb.length() - 1).append(")");

		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
	}

}
