package furama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ControllerAspect {

    @AfterReturning(pointcut = "execution(public * furama.controller.*.*(..))")
    public void logHistory(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("Class Name : " + className);
        System.out.println("Method Name  : " + methodName);
        System.out.println("args : " + args);
    }

    @AfterThrowing(pointcut = "execution(public * furama.controller.*.*(..))", throwing = "ex")
    public void logHistoryThrowing(JoinPoint joinPoint, Exception ex) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("Class Name : " + className);
        System.out.println("Method Name  : " + methodName);
        System.out.println("args : " + args);
        System.out.println("Err : " + ex.getMessage());
    }
}
