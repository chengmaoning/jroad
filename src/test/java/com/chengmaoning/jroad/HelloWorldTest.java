/**
 * 
 */
package com.chengmaoning.jroad;

import static org.junit.Assert.*;

import java.net.URL;

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
		
		ClassLoader c = getClass().getClassLoader();
		logger.info(c);
		ClassLoader c1 = c.getParent();
		logger.info(c1);
		ClassLoader c2 = c1.getParent();
		logger.info(c2);
		
		@SuppressWarnings("restriction")
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			logger.info(urls[i].toExternalForm());
		}
		
		logger.info(System.getProperty("sun.boot.class.path"));
		
	}

}
