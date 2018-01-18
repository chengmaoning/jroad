/**
 * 
 */
package com.chengmaoning.jroad.aviator;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * AcceptFunction.java
 * 
 * @author chengmaoning
 *
 *         2017年12月26日上午11:01:49
 */
public class AcceptFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "accept";
	}

	@Override
	public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
		String value = FunctionUtils.getStringValue(arg1, env);

		return StringUtils.isBlank(value) ? AviatorBoolean.FALSE : AviatorBoolean.TRUE;
	}

}
