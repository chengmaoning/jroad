/**
 * 
 */
package com.chengmaoning.jroad;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HelloWorldTest {

	private static final Log logger = LogFactory.getLog(HelloWorldTest.class);

	@Test
	public void test() {
		System.out.println("inside a test.");
		assertTrue(true);
		
		String errMsg = "hello\nworld.";
		
		System.out.println( errMsg.indexOf("\n"));
		
		System.out.println(errMsg.substring(0, errMsg.indexOf("\n")));

		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
	}

}
