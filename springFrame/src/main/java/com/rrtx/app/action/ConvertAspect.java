package com.rrtx.app.action; 
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
@Aspect
@Component
public class ConvertAspect { 
    

	@Pointcut(value="execution(public * com.rrtx.app.action..*.create(..))")
	public void a(){}  
	
	@Pointcut(value="execution(public * com.rrtx.app.action..*.show(..))")
	public void show(){}  
	
	//@Before(value="org.springframework.web.servlet.View.render(model, request, response)")
	//@Before("render(Map<String,?> model, HttpServletRequest request, HttpServletResponse response)")
	//@Before("com.rrtx.app.action.UserManageController.create()")
	 
	//@Before("execution(* com.rrtx.app.action..*.*(..))")
	//@Before("execution(* com.rrtx.app.aspectTarget..*.*(..))")
	//@After("show()")
	public void convert(){
		System.out.println("in aspect");
	}
	
	//@After("show()")
	@AfterReturning(pointcut="show()", returning="result")
	public void addHome(Object result) throws Throwable{
		((ModelAndView)result).getModel().put("home", "beijing");
		System.out.println("in aspect:addHome");
		//return (ModelAndView)returnValue;
	}
			

}
