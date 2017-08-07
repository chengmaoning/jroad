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
		
		
		List<String> expOrderIds = Arrays.asList("1");
		
		StringBuffer sb = new StringBuffer("(");
        for(String order: expOrderIds){
            sb.append("'").append(order).append("',");
        }
        sb.deleteCharAt(sb.length()-1).append(")");
        
        System.out.println(sb.toString());
	}

}
