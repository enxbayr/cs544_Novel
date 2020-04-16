package edu.mum.aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @After("execution(* edu.mum.controller.*.*(..))")
    public void log(JoinPoint joinpoint) {
        Date date = new Date();
        String logRow = date+" Func Name ="+joinpoint.getSignature().getName()+" Class Name= "+joinpoint
                .getSignature().getClass().getName();
        LOGGER.info(logRow);
        System.out.println(logRow);
    }
}
