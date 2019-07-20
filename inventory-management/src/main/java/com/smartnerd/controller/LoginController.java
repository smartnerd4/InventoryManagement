package com.smartnerd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.LoginPageModel;
import com.smartnerd.service.Service;

@Controller
public class LoginController {
	@Autowired
	private Service LoginService;
	

	@RequestMapping(value = "/")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("welcomepage");
		return model;
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView loginpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("loginpage");
		return model;

	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public ModelAndView loginpage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginPageModel lpmodel) {
		ModelAndView model = null;
		try {
			boolean isValidUser = LoginService.isValidUser(lpmodel.getName(), lpmodel.getPassword());
			if (isValidUser) {
				System.out.println("User Login Successful");
				model = new ModelAndView("homepage");
				model.addObject("name", lpmodel.getName());
			} else {

				model = new ModelAndView("loginpage");
				model.addObject("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
}
	
	