package krelve.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by krelve on 2015/11/30.
 */
/*先将该类放入IOC容器中，再声明为一个切面*/

@Aspect
@Component
public class LoggingAspect {

    /*定义一个方法，用于声明切入点表达式*/
    @Pointcut("execution(public int krelve.ssm.aop.Calculator.*(..))")
    public void declareJointPointExpression() {
    }

    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins :" + methodName + "   args: " + args);
    }

    @After("execution(public int krelve.ssm.aop.Calculator.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends :" + methodName + "   args: " + args);
    }

    @AfterReturning(value = "execution(public int krelve.ssm.aop.Calculator.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method returns :" + methodName + "   args: " + args + "   result:" + result);
    }

    @AfterThrowing(value = "execution(public int krelve.ssm.aop.Calculator.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method throws exception :" + methodName + "   args: " + args + "   ex:" + ex);
    }

    /*需要ProceedingJoinPoint类型的参数
    * 必有返回值，且为目标方法的返回值
    * */
    @Around(value = "execution(public int krelve.ssm.aop.Calculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("The method " + methodName + ",   args: " + args);
            result = joinPoint.proceed();
            System.out.println("The method ends " + methodName + ",   args: " + args);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
