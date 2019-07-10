package com.smartnerd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.Login;
import com.smartnerd.service.Service;

@Controller
public class LoginController {
	@Autowired
	private Service LoginService;

	@RequestMapping(value = "/")
	public ModelAndView displayLogin() {
		ModelAndView model = new ModelAndView("welcome");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginviewresponse(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView model = null;
		try {
			boolean isValidUser = LoginService.isValidUser(login.getName(), login.getPassword());
			if (isValidUser) {
				System.out.println("User Login Successful");
				model = new ModelAndView("home");
				model.addObject("name", login.getName());
			} else {

				model = new ModelAndView("login");
				model.addObject("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
}
