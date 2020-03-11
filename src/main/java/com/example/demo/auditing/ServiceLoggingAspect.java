package com.example.demo.auditing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
* Only logging service layer calls because Spring already does that for controller calls when logging DEBUG level.
*/

@Aspect
@Component
public class ServiceLoggingAspect {

    private final Logger LOGGER = LogManager.getLogger(ServiceLoggingAspect.class);

    @Pointcut("@annotation(com.example.demo.auditing.Auditable)")
    private void auditablePointcut() {}

    @Before("auditablePointcut()")
    public void logFormBeforeServiceCall(JoinPoint joinPoint) {
        LOGGER.debug("Calling method: " + joinPoint.getSignature());
        LOGGER.debug("Processing Form data: '{}'", joinPoint.getArgs()[0]);
    }

    @AfterReturning(pointcut = "auditablePointcut()", returning = "result")
    public void logResultAfterServiceCall(JoinPoint joinPoint, String result) {
        LOGGER.debug("Called method: " + joinPoint.getSignature());
        LOGGER.debug("Processed result from Form data: '{}'", result);
    }
}