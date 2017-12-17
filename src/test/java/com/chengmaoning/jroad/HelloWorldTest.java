/**
 * 
 */
package com.chengmaoning.jroad;

import static org.junit.Assert.*;

import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
	public void test_functoin() {
		List<Integer> array = Arrays.asList(3, 25, 5, 2, 8, 9, 6, 10);

		Predicate<Integer> predicate = n -> n % 2 == 0;

		for (int i = 0; i < array.size(); i++) {
			if (predicate.test(array.get(i))) {
				logger.info(array.get(i) + ": even.");
			} else {
				logger.info(array.get(i) + ": odd.");
			}
		}
	}

	@Test
	public void testDateTime() {
		final ZonedDateTime zonedDateTime = ZonedDateTime.now();
		final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

		System.out.println(zonedDateTime);
		System.out.println(zonedDateTimeFromZone);
	}

}
