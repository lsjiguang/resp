package com.rrtx.app.action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

import com.rrtx.app.aspectTarget.ControllerImpl;
import com.rrtx.app.aspectTarget.IController;

@Controller
public class UserManageActonn  {
	
	@RequestMapping("/user")  
    public String create() {
        System.out.println("in create"); 
        ControllerImpl controller = new ControllerImpl();
        controller.create("name") ;
        return "show";
    } 
	 
	@RequestMapping("/addUser")  
	public ModelAndView handleRequest(){
		System.out.println("in handleRequest"); 
		Map result = new HashMap();
		result.put("name", "qijia");
		result.put("age", "23");
		return new ModelAndView("show",result);
		
	}
	@RequestMapping("/show")  
	public ModelAndView show(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		System.out.println("in show"); 
		 
		model.put("name", "qijia");
		model.addAttribute("age", "23");
		return new ModelAndView("show",model);
	}
}
