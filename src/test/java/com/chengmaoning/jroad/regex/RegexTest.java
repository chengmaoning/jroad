/**
 * 
 */
package com.chengmaoning.jroad.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

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

}
