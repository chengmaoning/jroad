/**
 * 
 */
package com.chengmaoning.jroad.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	private static final Logger LOGGER = Logger.getLogger("com.chengmaoning.jroad.controller.HelloWorldController");

	@RequestMapping(path = "/hello", method = { RequestMethod.GET, RequestMethod.PUT })
	public void hello(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("hello world from a controller.");
	}
}
