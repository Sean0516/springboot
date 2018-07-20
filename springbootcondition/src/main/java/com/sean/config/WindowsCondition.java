package com.sean.config;


import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
public class WindowsCondition implements org.springframework.context.annotation.Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
