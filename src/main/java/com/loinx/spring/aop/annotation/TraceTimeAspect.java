package com.loinx.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Aspect
@Slf4j
public class TraceTimeAspect {

	@Around("@annotation(com.loinx.spring.aop.annotation.TraceTime)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();

		long end = System.currentTimeMillis() - startTime;

		log.info("Time taken by {} is {}", joinPoint.getSignature(), end);
		
		return result;
	}

}
