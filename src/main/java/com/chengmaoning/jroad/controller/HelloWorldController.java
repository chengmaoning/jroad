/**
 * 
 */
package com.chengmaoning.jroad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HelloWorldController.java
 * 
 * @author chengmaoning
 *
 *         2017年7月13日下午5:15:52
 */

@Controller
public class HelloWorldController {

	private static final Log logger = LogFactory.getLog(HelloWorldController.class);

	@RequestMapping(path = "/hello", method = { RequestMethod.GET, RequestMethod.PUT })
	public void hello(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().println("<p>in side hello world controller!</p>");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("hello world from a controller.");
		logger.error("error ...");
	}
}
