package my_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ControllerAspect {

    @AfterReturning(pointcut = "execution( public * my_project.controller.*.*(..))")
    public void logHistory(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("--------------------------ASPECT START----------------------------");
        System.out.println("Controller : " + className);
        System.out.println("Method : " + methodName);
        System.out.println("args : " + args);
        System.out.println("--------------------------ASPECT END-----------------------------");
    }
}
