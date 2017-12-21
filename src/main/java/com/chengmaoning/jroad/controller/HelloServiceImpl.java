/**
 * 
 */
package com.chengmaoning.jroad.controller;

import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl.java
 * 
 * @author chengmaoning
 *
 *         2017年12月21日下午5:41:45
 */
@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public Integer testThrow(boolean exception) {
		if (exception) {
			throw new RuntimeException("this is exception.");
		}
		return 1;
	}

}
