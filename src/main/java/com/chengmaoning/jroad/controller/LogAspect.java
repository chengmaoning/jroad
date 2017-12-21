/**
 * 
 */
package com.chengmaoning.jroad.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * HelloWorldLogAspect.java
 * 
 * @author chengmaoning
 *
 *         2017年12月21日下午4:39:30
 */
@Component
@Aspect
public class LogAspect {
	private static final Log logger = LogFactory.getLog(LogAspect.class);

	@Pointcut("execution(* com.chengmaoning.jroad.controller.HelloService.*(..))")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("before");
		logger.info(joinPoint.getSignature().toShortString());
		logger.info((Boolean) (joinPoint.getArgs()[0]));
	}

	@AfterReturning(pointcut = "pointcut()", returning = "retVal")
	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		logger.info("after returning");
		logger.info(joinPoint.getSignature().toShortString());
		logger.info((Boolean) (joinPoint.getArgs()[0]));
		logger.info((Integer) retVal);
	}

	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
		logger.info("after throwing");
		logger.info(joinPoint.getSignature().toShortString());
		logger.info(throwable.getMessage());
	}

	@After("pointcut()")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("after");
		logger.info(joinPoint.getSignature().toShortString());
	}

	@Around("pointcut()")
	public void logAround(ProceedingJoinPoint joinPoint) {
		logger.info("around start");
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("around end");
	}
}
