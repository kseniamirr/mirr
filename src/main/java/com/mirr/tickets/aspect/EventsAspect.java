package com.mirr.tickets.aspect;

import com.mirr.tickets.events.Event;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EventsAspect {
    /** Following is the definition for a PointCut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    @Pointcut("execution(* com.mirr.tickets.dao.GenericDao.getName(..))")
    private void logBeforeV1(Event event){
        System.out.println("EventsAspect.logBeforeV1(): " + event.getName());
    }

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("execution(* com.mirr.tickets.dao.GenericDao.getName(..))")
    public void logBeforeV2(Event event){
        System.out.println("EventsAspect.logBeforeV2() : " + event.getName());
    }
}

