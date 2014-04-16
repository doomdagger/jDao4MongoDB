package com.fan1tuan.business.support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * wrap the method, using aop, plus log4j2 support
 */
public class ServiceAround {

	static Logger logger = LogManager.getLogger("com.fan1tuan.business.ServiceLogger");


    /**
     * catching boolean returned-value method
     * @param point catching point of service method
     * @return boolean value
     */
	public boolean booleanAroundMethod(ProceedingJoinPoint point){
		try{
			logger.entry(point.getArgs());
			logger.info("In "+point.getTarget().getClass().getName()+" "+point.getSignature().getName());
			return logger.exit((Boolean)point.proceed(point.getArgs()));
		}catch(Throwable exception){
			logger.catching(exception);
			return logger.exit(false);
		}
	}

    /**
     * catching void returned-value method
     * @param point catching point of service method
     */
    public void voidAroundMethod(ProceedingJoinPoint point){
        try{
            logger.entry(point.getArgs());
            logger.info("In "+point.getTarget().getClass().getName()+" "+point.getSignature().getName());
            logger.exit(point.proceed(point.getArgs()));
        }catch(Throwable exception){
            logger.catching(exception);
            logger.exit(null);
        }
    }

    /**
     * catching void returned-value method
     * @param point catching point of service method
     * @return long primitive value type long
     */
    public long longAroundMethod(ProceedingJoinPoint point){
        try{
            logger.entry(point.getArgs());
            logger.info("In "+point.getTarget().getClass().getName()+" "+point.getSignature().getName());
            return logger.exit((Long)point.proceed(point.getArgs()));
        }catch(Throwable exception){
            logger.catching(exception);
            return logger.exit(-1);
        }
    }

    /**
     * catching object returned-value method
     * @param point catching point of service method
     * @return Object that extend EntityObject(might be) or Collection
     */
	public Object objectAroundMethod(ProceedingJoinPoint point){
		try{
			logger.entry(point.getArgs());
			logger.info("In "+point.getTarget().getClass().getName()+" "+point.getSignature().getName());
			return logger.exit(point.proceed(point.getArgs()));
		}catch(Throwable exception){
			logger.catching(exception);
			return logger.exit(null);
		}
	}
	
}
