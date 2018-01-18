/**
 * 
 */
package com.chengmaoning.jroad.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TestServlet.java
 *
 * @author chengmaoning
 *
 *         Jan 6, 201810:56:50 PM
 */
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7860420537346000266L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("entering TestServlet");
		ServletConfig config = getServletConfig();
		Enumeration<String> paramEnumeration = config.getInitParameterNames();
		while (paramEnumeration.hasMoreElements()) {
			String name = (String) paramEnumeration.nextElement();
			System.out.println("init params: " + name + " - " + config.getInitParameter(name));
		}
		System.out.println(config.getServletName());

		ServletContext context = config.getServletContext();
		Enumeration<String> attributeEnumeration = context.getAttributeNames();
		while (attributeEnumeration.hasMoreElements()) {
			String attributeName = (String) attributeEnumeration.nextElement();
			System.out.println("attrbite: " + attributeName);
		}

		Enumeration<String> enumeration = context.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String param = (String) enumeration.nextElement();
			System.out.println(param);
		}

		System.out.println(
				"major version: " + context.getMajorVersion() + ", minor version: " + context.getMinorVersion());
		System.out.println("effective majar version: " + context.getEffectiveMajorVersion()
				+ ", effective minor version: " + context.getEffectiveMinorVersion());
		System.out.println(context.getResourcePaths("/META-INF/"));
		System.out.println(context.getResource("/META-INF/MANIFEST.MF").toString());
		System.out.println("server info: " + context.getServerInfo());
		System.out.println("servlet context name: " + context.getServletContextName());
		
		ServletRegistration registration =  context.getServletRegistration("testServlet");
		System.out.println(registration.getClassName());
		System.out.println(registration.getInitParameter("msg"));
		System.out.println(registration.getName());
		System.out.println(registration.getRunAsRole());
		System.out.println(registration.getMappings().toString());
		System.out.println("context path: " + context.getContextPath());
		System.out.println("real path: " + context.getRealPath("/index.jsp"));
		
		RequestDispatcher requestDispatcher =  context.getRequestDispatcher("/test");
		
		System.out.println();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
