/**
 * 
 */
package com.chengmaoning.jroad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HelloWorldTest {

	private static final Log logger = LogFactory.getLog(HelloWorldTest.class);

	@Test
	public void test() {

		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
	}

}
