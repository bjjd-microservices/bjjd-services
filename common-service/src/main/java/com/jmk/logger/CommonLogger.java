package com.jmk.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class CommonLogger {

	@Pointcut("within(com.jmk..*)")
	public void logAllMethodsStartAndEnd() {
		
	}
	
	@Around("logAllMethodsStartAndEnd()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
    {
        log.info(pjp.getTarget().getClass().getSimpleName() + "-" + pjp.getSignature().getName() + "() start");
        Object returnValue = pjp.proceed();
        log.info(pjp.getTarget().getClass().getSimpleName() + "-" + pjp.getSignature().getName() + "() end");
  
        return returnValue;
    }
}

