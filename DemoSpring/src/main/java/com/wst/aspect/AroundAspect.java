package com.wst.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class AroundAspect {
    @Around("execution(* com.wst.controller.SysController.*(..))")
    public Object around(ProceedingJoinPoint point){
        getInfo(point);
        Object result = null;
        try{
            System.out.println("AroundAspect.before");
            if ("getU".equals(point.getSignature().getName())){
                return null;
            }
            result = point.proceed();
            System.out.println("AroundAspect.after");

        } catch (Throwable e) {
            System.out.println("AroundAspect.exception");
        }
        System.out.println("AroundAspect.afterReturning");
        return result;
    }
    private void getInfo(JoinPoint point){
        Object[] params = point.getArgs();
        String methodName = point.getSignature().getName();
        Class cls = point.getTarget().getClass();
        System.out.println("拦截--------------------------" + cls.getPackage()+ "." + cls.getSimpleName() + "." + methodName);
        System.out.println("该方法的参数列表");
        for (Object p: params) {
            System.out.println(p);
        }
    }
}
