package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {

	@Before("execution(* demo.Checkout.checkoutOrder(..))")
	void beforeLogger(JoinPoint obj)
	{
		System.out.println(obj.getArgs()[0].toString());
	
		System.out.println("Logs are tracked before execution of checkout!!");
	}
	
	@After("execution(* *.*.checkoutOrder(..))")
	void afterLogger()
	{
		System.out.println("Logs are tracked after execution of checkout!!");
	}
	
	@AfterThrowing(pointcut="execution(* *.*.calculation(..))",throwing="error")
	void afterthrowExce()
	{
		System.out.println(" exception oocured");
	}
	
	/*@AfterThrowing − Mark a function as an advice to be executed before method(s) covered by Pointcut, if the method throws an exception.

Pointcut − Provides an expression to select a function.

execution( expression ) − Expression covering methods on which advice is to be applied.

throwing − Name of the exception to be returned.
https://www.tutorialspoint.com/springaop/springaop_after_returning1.htm*/
	
}
