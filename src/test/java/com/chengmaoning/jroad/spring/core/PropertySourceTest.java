/**
 * 
 */
package com.chengmaoning.jroad.spring.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * PropertySourceTest.java
 * 
 * @author chengmaoning
 *
 *         2018年2月12日下午2:11:02
 */
public class PropertySourceTest {

	private static final Log logger = LogFactory.getLog(PropertySourceTest.class);

	@Test
	public void test() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("encoding", "gbk");

		PropertySource<Map<String, Object>> maPropertySource = new MapPropertySource("map", map);
		logger.info("encoding: " + maPropertySource.getProperty("encoding"));

		PropertySource<?> propertySource = new ResourcePropertySource("resouce", "classpath:jdbc.properties");
		logger.info("jdbc.url: " + propertySource.getProperty("jdbc.url"));

		CompositePropertySource compositePropertySource = new CompositePropertySource("composite");
		compositePropertySource.addPropertySource(maPropertySource);
		compositePropertySource.addPropertySource(propertySource);

		logger.info("jdbc.username: " + compositePropertySource.getProperty("jdbc.username"));

		List<PropertySource> sources = new ArrayList<PropertySource>();
		sources.add(new MapPropertySource("sourceA", map));
		sources.add(new MapPropertySource("sourceB", map));
		assert sources.contains(PropertySource.named("sourceA"));
		assert sources.contains(PropertySource.named("sourceB"));
		assert !sources.contains(PropertySource.named("sourceC"));

		MutablePropertySources propertySources = new MutablePropertySources();
		propertySources.addFirst(maPropertySource);
		propertySources.addLast(propertySource);
		logger.info("encoding: " + propertySources.get("map").getProperty("encoding"));

		PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);
		logger.info(propertyResolver.getProperty("encoding"));
		logger.info(propertyResolver.getProperty("no", "default"));
		logger.info(propertyResolver.resolvePlaceholders("must be encoding in ${encoding}"));

		Environment environment = new StandardEnvironment();
		logger.info(environment
				.resolvePlaceholders("current user home dir: ${user.home}, file encoding: ${file.encoding}."));

	}
}
