package com.chengmaoning.jroad.aviator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.chengmaoning.jroad.model.TestBean;
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

	private Map<String, String> comparators = new HashMap<>();

	private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Before
	public void setUp() {
		env.put("amount", "22.3");
		env.put("amount2", null);
		env.put("bizProductCheck", "face_to_face_payment");

		AviatorEvaluator.addFunction(new AcceptFunction());

		comparators.put("strEqual", "==");
	}

	@Test
	public void test() {
		Boolean accept = (Boolean) AviatorEvaluator.execute("amount==nil", env);
		System.out.println("accept = " + accept);

		String aString = (String) AviatorEvaluator.execute("'amount'", env);
		String bString = (String) AviatorEvaluator.execute("amount", env);
		System.out.println(aString + "\n" + bString);

		double r = new Random().nextDouble();
		if (r < 100 / 100.0) {
			System.out.println("passed, r = " + r);
		} else {
			System.out.println("failed, r = " + r);
		}

	}

	@Test
	public void test2() {
		String exp = "bizProductCheck " + comparators.get("strEqual") + " 'face_to_face_payment'";
		Boolean ret = (Boolean) AviatorEvaluator.execute(exp, env);
		System.out.println("ret = " + ret);

		String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("class name: " + clazz + ", Method Name " + method);
	}

	@Test
	public void test3() {
		long current = System.currentTimeMillis();
		Date before = new Date(current - current % (24 * 3600));
		Date enDate = new Date(before.getTime() + 24 * 3600);
		System.out.println("before = " + format.format(before));
		System.out.println("end = " + format.format(enDate));
	}

	@Test
	public void test4() {
		TestBean testBean = new TestBean();
		testBean.setKey("hello");
		testBean.setValue("world");

		String name = "dennis";
		AviatorEvaluator.execute("#testBean.value = '666'", new HashMap() {
			{
				put("testBean", testBean);
			}
		});
		System.out.println(JSON.toJSONString(testBean, true));
	}
}
