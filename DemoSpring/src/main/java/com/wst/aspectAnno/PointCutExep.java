package com.wst.aspectAnno;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExep {
    @Pointcut("execution(* com.wst.controller.SysController.*(..))")
    public static void sysControllerGetStrStr(){

    }
    @Pointcut
    public static void sysControllerGetStrStr2(){

    }
}
