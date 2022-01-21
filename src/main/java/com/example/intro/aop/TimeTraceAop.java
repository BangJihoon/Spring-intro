package com.example.intro.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
	@Around("execution(* com.example.intro..*(..))")
	public Object execute(ProceedingJoinPoint joinpoint) throws Throwable{
		long start = System.currentTimeMillis();
		System.out.println("START : " + joinpoint.toString());
		try {
			return joinpoint.proceed();
		}finally {
			long fin = System.currentTimeMillis();
			long timeMs = fin -start;
			System.out.println("END : " + joinpoint.toString() +" " + timeMs+"ms");
		}
	}
}
