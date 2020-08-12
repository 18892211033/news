package com.wst.aspect;

import com.wst.aspectAnno.PointCutExep;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TimerAspect {
    @Before("execution(* com.wst.controller.SysController.*(..))")
    public void before(JoinPoint point){
        //写入日志或db
        long start = System.currentTimeMillis();
        System.out.println("TimerAspect.before");
        getInfo(point);
    }
    @After("execution(* com.wst.controller.SysController.*(..))")
    public void after(JoinPoint point){
        System.out.println("TimerAspect.after");
    }
    @AfterReturning(value = "execution(* com.wst.controller.SysController.*(..))" ,returning = "returnObj")
    public void afterReturnint(JoinPoint point , Object returnObj){
        System.out.println("TimerAspect.afterReturnint"+ returnObj);
    }
    @AfterThrowing(value = "execution(* com.wst.controller.SysController.*(..))" , throwing = "t")
    public void exception(JoinPoint point , Throwable t){
        System.out.println("TimerAspect.exception" + t);
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
