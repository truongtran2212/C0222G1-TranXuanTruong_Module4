package com.codegym.demo.util.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.codegym.demo.controller.StudentController.*(..))")
    public void logAfterMethodController(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
//        System.out.println(nameMethod);
        logger.info("Tên phương thức được sử dụng: "+ nameMethod);
    }

}
