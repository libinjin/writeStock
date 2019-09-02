package com.youguu.intelligent.aspect;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.intelligent.util.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by CosWind on 2014/9/30.
 */
@Component
public class RpcExecuteTimeAspect {
    private static final Log log = LogFactory.getLog("time");

    @Around("execution(* com.youguu.intelligent.dao.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long costTime = System.currentTimeMillis() - startTime;

        log.debug("[{}] {}", DateUtil.simpleFormatMS(costTime), joinPoint.toShortString());

        return result;
    }
}
