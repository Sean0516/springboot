package com.voicecyber.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Sean on 2018/9/10
 *
 * @author Sean
 */
@Aspect
@Component
public class AroundAspect {
    @Pointcut(" execution(public * com.voicecyber.controller.AroundController..*(..))")
    public void around(){
    }
    @Around("around()" )
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        Object proceed=null;
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        System.out.println("访问的方法"+method.getName());
        Object[] args = joinPoint.getArgs();
        System.out.println("访问的参数"+args[0]);
        if ("test".equals(args[0].toString())){
            args[0]="sean";
        }
        System.out.println("访问controller 的前置通知结束  ，进入后置通知");
        try {
            proceed = joinPoint.proceed(args);
            System.out.println("controller 返回"+proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
