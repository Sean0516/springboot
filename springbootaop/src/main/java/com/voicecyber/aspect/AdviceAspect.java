package com.voicecyber.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/9/10
 *
 * @author Sean
 */
@Component
@Aspect
public class AdviceAspect {
    protected final static Logger LOGGER = LoggerFactory.getLogger(AdviceAspect.class);

    @Pointcut("execution(public * com.voicecyber.controller.AdviceController..*(..))")
    public void advice(){
    }
    @Before("advice()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        LOGGER.info(args.toString());
        LOGGER.info("before enter controller");
    }
    @AfterReturning(pointcut = "advice()" ,returning = "obj")
    public void afterAdvice(Object obj){
        LOGGER.info("controller return msg" + obj);
    }

}
