package com.mirr.tickets.aspect;

import com.mirr.tickets.dao.EventDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Aspect
public class EventsAspect {

    private static Map<Class, Integer> counterMap = new HashMap<>();

    /** Following is the definition for a PointCut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    @Pointcut("execution(* com.mirr.tickets.dao.EventDao.getEventByName(..))")
    public void eventByNameCounterAspectPointcut(){}

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("execution(* com.mirr.tickets.dao.EventDao.getEventByName(..))")
    public void eventByNameCounterAspect(JoinPoint joinPoint){
        Integer currentNumber = counterMap.get(EventDao.class);
        counterMap.put(EventDao.class, currentNumber != null? currentNumber + 1 : 1);
        System.out.println("AspectsCounter : ");
    }

    public Optional<Integer> getCounterByClass(Class clazz) {
        return Optional.ofNullable(counterMap.get(clazz));
    }
}

