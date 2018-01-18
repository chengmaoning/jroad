package com.chengmaoning.jroad.aviator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.googlecode.aviator.AviatorEvaluator;

/**
 * 
 * AviatorTest.java
 * 
 * @author chengmaoning
 *
 *         2017年12月26日上午10:44:52
 */
public class AviatorTest {

	private Map<String, Object> env = new HashMap<>();

	@Before
	public void setUp() {
		env.put("amount", "22.3");
		env.put("amount2", null);

		AviatorEvaluator.addFunction(new AcceptFunction());
	}

	@Test
	public void test() {
		Boolean accept = (Boolean) AviatorEvaluator.execute("amount==nil", env);

		String aString = (String) AviatorEvaluator.execute("'amount'", env);
		String bString = (String) AviatorEvaluator.execute("amount", env);
		System.out.println(aString + "\n" + bString);
	}
}
