package com.chengmaoning.jroad.aviator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
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
		String exp = "1_88c56276d6a5ffa101f2567b4adec11d and 1_d61f14f8982d0b855917f0b8c2655c96 and 1_7ce5135c2e5ca3704dfe457d18eed205";
		String expression = exp.replace("and", "&&").replace("or", "||");
		Map<String, Object> env = new HashMap<>();
		env.put("payeeUserId", "2088331593939528");
		env.put("bizProductCheck", "CITY_TRFC_QRCODE_PAY");
		env.put("useCountLimit", "3");

		Map<String, String> map = new HashMap<>();
		map.put("1_88c56276d6a5ffa101f2567b4adec11d", StringUtils.EMPTY);
		map.put("1_d61f14f8982d0b855917f0b8c2655c96", "string.contains(bizProductCheck,'CITY_TRFC_QRCODE_PAY')");
		map.put("1_7ce5135c2e5ca3704dfe457d18eed205", "string.contains(payeeUserId,'2088331593939528')");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			String ret = StringUtils.isBlank(value) ? "true"
					: ((Boolean) AviatorEvaluator.execute(value, env)).toString();
			expression = expression.replace(key, ret);
		}
		System.out.println("expression = " + expression);
		boolean outcome = (boolean) AviatorEvaluator.execute(expression);
		System.out.println("outcome = " + outcome);
	}

	@Test
	public void test5() {
		// String expression = "(true && true && true && true && true) || (true
		// && true && true && true && true) || (false && true && true && true &&
		// true && true) || (true && true && false && true && true && true) ||
		// (true && false && true && true && true && true) || (true && true &&
		// true && true && false && true) || (true && false && true && true &&
		// true && true) || (true && true && true && false && true && true) ||
		// (true && true && false && true && true && true) || (false && true &&
		// true && true && true && true) || (false && true && true && true &&
		// true && true) || (true && true && 1true && true && true && true) ||
		// (true && true && true && false && true && true)";
		// Boolean ret = (Boolean) AviatorEvaluator.execute(expression);
		// System.out.println("ret = " + ret);
	}

	@Test
	public void test6() {
		Map<String, String> map = new HashMap<>();
		map.put("8_e8ce7f738c8d97790b1ddd09da505d39", "444");
		map.put("8_dbf2bf3eb73bd1ae48672d91a1759656", "333");
		map.put("8_e8ce7f738c8d", "93493");

		List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o2.getKey().length() - o1.getKey().length();
			}
		});

		for (Map.Entry<String, String> entry : list) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}
}
