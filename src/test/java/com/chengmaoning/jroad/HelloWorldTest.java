/**
 * 
 */
package com.chengmaoning.jroad;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * HelloWorldTest.java
 * 
 * @author chengmaoning
 *
 * 2017年7月13日下午4:38:16
 */
public class HelloWorldTest {

	@Test
	public void test() {
		System.out.println("inside a test.");
		assertTrue(true);
		
		
		List<String> list = Arrays.asList("1","2");
		
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i <list.size(); i++) {
            sb.append(list.get(i)).append(",");
        }
        String expOrderIdStr =  sb.deleteCharAt(sb.length()-1).toString();
		System.out.println(expOrderIdStr);
	}

}
