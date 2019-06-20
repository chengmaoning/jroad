/**
 * 
 */
package com.chengmaoning.jroad.springframework;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chengmaoning.jroad.controller.HelloService;

/**
 * SpringframeworkTest.java
 * 
 * @author chengmaoning
 *
 *         2018年1月5日下午5:26:45
 */

// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:application-context.xml")
public class SpringframeworkTest {

	@Test
	public void test() {
		System.out.println("hello world");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		System.out.println(beanFactory.getBeanDefinitionCount());
	}
}
