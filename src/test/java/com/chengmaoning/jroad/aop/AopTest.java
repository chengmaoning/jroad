/**
 * 
 */
package com.chengmaoning.jroad.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AopTest.java
 * @author chengmaoning
 *
 * 2018年7月5日下午7:17:19
 */
public class AopTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		TargetClass targetClass =  (TargetClass) context.getBean("targetClass");
		targetClass.addUser("cheng", "maoning");
	}

}
