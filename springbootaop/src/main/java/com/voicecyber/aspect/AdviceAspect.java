package com.voicecyber.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LOGGER.info("method name:"+name);
        LOGGER.info("参数："+args.toString());
        LOGGER.info("before enter controller");
    }
    @AfterReturning(pointcut = "advice()" ,returning = "obj")
    public void afterAdvice(Object obj){
        LOGGER.info("controller return msg" + obj);
    }
    @AfterThrowing(pointcut = "advice()",throwing = "t")
    public void afterThrowing(JoinPoint joinPoint,Throwable t){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        LOGGER.info("method name:"+signature.getName());
        LOGGER.info("参数："+args.toString());
        LOGGER.error("error message:"+t.getMessage());
    }

}
