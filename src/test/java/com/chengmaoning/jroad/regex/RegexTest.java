/**
 * 
 */
package com.chengmaoning.jroad.regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.Soundbank;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * RegexTest.java
 * 
 * @author chengmaoning
 *
 *         2017年12月27日上午11:04:12
 */
public class RegexTest {

	private transient static final Pattern pattern = Pattern.compile("(\\S+)\\s+AS\\s+(\\S+)",
			Pattern.CASE_INSENSITIVE);

	private static final Pattern pattern2 = Pattern.compile("@\\w+");

	@Test
	public void test() {
		String column = " Amount ";
		Matcher matcher = pattern.matcher(column.trim());
		if (matcher.matches() && matcher.groupCount() == 2) {
			String col = matcher.group(1);
			String alias = matcher.group(2);
			System.out.println(col + "\n" + alias);
		} else {
			System.out.println(column.trim());
		}

	}

	@Test
	public void test2() {
		String original = "{'copywriter':'活动（@camp_id）的券预算不足，请及时补充。','expression':'long(promo_budget) > long(vcc_budget)','notifyParty':'@promo_owner'}";
		String out = original;
		Map<String, String> context = new HashMap<>();
		context.put("camp_id", "新春红包");
		context.put("promo_owner", "义方, 逐清");
		Matcher matcher = pattern2.matcher(original);
		while (matcher.find()) {
			String group = matcher.group();
			String value = context.get(group.substring(1));
			out = out.replace(group, value);
			System.out.println(out);
		}
	}

	@Test
	public void test3() {
		String[] receivers = new String[] { "77588", "义方" };
		for (int i = 0; i < receivers.length; i++) {
			if (receivers[i].matches("[0-9]+")) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}
		String aString = "11";
		String bString = "11";
		System.out.println(aString == bString);
	}
	
	@Test
	public void test4(){
		Object json = JSON.parse("[]");
		System.out.println(json instanceof Map);
		
		System.out.println(json instanceof List);
	}

}
