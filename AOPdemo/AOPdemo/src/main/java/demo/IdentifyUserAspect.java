package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class IdentifyUserAspect {

	@Pointcut("within(demo..*)")
	public void authenticatePointcuts()
	{
	}
	
	@Pointcut("within(demo..*)")
	public void authoriePointcut()
	{	
	}
	
	@Before("authenticatePointcuts() || authoriePointcut()")
	public void authenticate()
	{
System.out.println("authenicating request......");		
	}
	
	
}
