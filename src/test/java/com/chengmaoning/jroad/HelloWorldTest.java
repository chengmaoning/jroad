/**
 * 
 */
package com.chengmaoning.jroad;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		System.out.println(errMsg.indexOf("\n"));

		System.out.println(errMsg.substring(0, errMsg.indexOf("\n")));

		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");

		System.out.println(System.getProperty("java.class.path"));

		System.out.println(System.getProperty("java.ext.dirs"));

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

	@Test
	public void testLambda() {
		List<String> names = new ArrayList<>();
		names.add("Taobao");
		names.add("ZhiFuBao");

		List<String> lowerCaseNames = names.stream().map(name -> {
			return name.toLowerCase();
		}).collect(Collectors.toList());

		logger.info("lowerCaseNames: " + lowerCaseNames);
	}

	@Test
	public void testLambda2() {
		MathOperation mathOperation = (a, b) -> a + b;
		logger.info("mathOperation: " + mathOperation.operation(4, 5));
	}

	interface MathOperation {
		int operation(int a, int b);
	}

}
