package springhibernate.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* springhibernate.app.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* springhibernate.app.services.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* springhibernate.app.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || " +
            "forServicePackage() || " +
            "forDaoPackage()")
    private void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        // display the method we are calling
        String method = joinPoint.getSignature().toString();
        logger.info("==> in @Before: calling method: " + method);

        // display the arguments to the method
        Object[] methodArgs = joinPoint.getArgs();

        for(Object arg: methodArgs){
            logger.info("==> argument: " + arg);
        }
    }

    // add @AfterReturning advice

}
