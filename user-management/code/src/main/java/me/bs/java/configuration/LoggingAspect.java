package me.bs.java.configuration;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import me.bs.java.common.UtilityClass;

@Aspect
@Configuration
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private long startTime;
	private String className;
	private String methodName;

	@Pointcut("within(@me.bs.java.aop.annotation.Loggable *)")
	public void loggableMethods() {

	}

	@Around("@annotation(me.bs.java.aop.annotation.Loggable) || loggableMethods()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		startTime = System.currentTimeMillis();
		className = UtilityClass.replaceUnderScoreCasing(joinPoint.getTarget().getClass().getSimpleName());
		methodName = UtilityClass.replaceUnderScoreCasing(joinPoint.getSignature().getName());
		logger.info("LoggingAspect=aroundAdvice STATUS=STARTED CLASS_NAME={} METHOD_NAME={}  TIME_TAKEN=NA ",  className, methodName);

		Object proceed = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		//logger.info("JOIN_POINT=\"{}\"", joinPoint);

		logger.info("LoggingAspect=aroundAdvice STATUS=COMPLETED CLASS_NAME={} METHOD_NAME={}  TIME_TAKEN={}",  className, methodName, timeTaken);
		return proceed;
	}

	 @After("@annotation(me.bs.java.aop.annotation.Loggable) || loggableMethods()")
	   public void afterAdvice(){
	      //System.out.println("LoggingAspect afterAdvice has been setup.");
	   }
	
	 @AfterThrowing(pointcut = "@annotation(me.bs.java.aop.annotation.Loggable) || loggableMethods()"
			 , throwing = "exception")
	   public void afterThrowingAdvice(Exception exception){
		logger.error("LoggingAspect=afterThrowingAdvice EXCEPTION EXCEPTION_MSG=\"{}\" EXCEPTION_CAUSE=\"{}\" EXCCEPTION_CLASS={}", exception.getMessage(),exception.getCause(),exception.getClass().getSimpleName());
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("LoggingAspect=afterThrowingAdvice STATUS=FAILED CLASS_NAME={} METHOD_NAME={}  TIME_TAKEN={}",  className, methodName, timeTaken);
	   }
	
}
