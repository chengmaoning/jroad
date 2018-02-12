/**
 * 
 */
package com.chengmaoning.jroad.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UrlPathHelper;

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

	UrlPathHelper urlPathHelper = new UrlPathHelper();

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = { "/" }, method = { RequestMethod.HEAD })
	public String head() {
		return "hello.jsp";
	}

	@RequestMapping(value = { "/index", "/" }, method = { RequestMethod.GET })
	public String hello(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("Into HelloWorldController-hello...");
		logger.info("path within application: " + urlPathHelper.getPathWithinApplication(request));

		logger.info("path witin servlet mapping: " + urlPathHelper.getPathWithinServletMapping(request));

		model.addAttribute("msg", "Go Go Go!");

		return "hello.jsp";
	}
}
