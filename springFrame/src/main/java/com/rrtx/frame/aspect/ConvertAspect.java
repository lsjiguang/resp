package com.rrtx.frame.aspect;
import java.util.Map;

import org.springframework.aop.BeforeAdvice;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ConvertAspect implements BeforeAdvice { 
    

	//@Pointcut("this(org.springframework.web.servlet.View)")
	//@Before(value="org.springframework.web.servlet.View.render(model, request, response)")
	//@Before("render(Map<String,?> model, HttpServletRequest request, HttpServletResponse response)")
	@Before("com.rrtx.app.action.UserManageController.create()")
	public void convert(Map<String,?> model){
		System.out.println("in aspect");
	}
			

}
