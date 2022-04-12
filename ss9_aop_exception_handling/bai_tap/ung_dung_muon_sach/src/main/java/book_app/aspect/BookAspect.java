package book_app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class BookAspect {
    private static Integer numberOfPerSon = 0;

    @After("execution(* book_app.service.impl.BookService.borrowBook(..))")
    public void logBorrowBook(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("method : " + methodName);
        System.out.println(" args : " + args);
    }

    @After("execution(* book_app.service.impl.BookService.returnBook(..))")
    public void logReturnBook(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("method : " + method);
        System.out.println("args : " + args);
    }

    @AfterReturning(pointcut = "execution(public * book_app.controller.BookController.*(..))")
    public void logViewers(JoinPoint joinPoint) {
        numberOfPerSon += 1;
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("method : " + method);
        System.out.println("args : " + args);
        System.out.println("views : " + numberOfPerSon);

    }
}
