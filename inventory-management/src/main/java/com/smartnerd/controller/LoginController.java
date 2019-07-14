package com.smartnerd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.Login;
import com.smartnerd.model.Offer;
import com.smartnerd.model.employee;
import com.smartnerd.service.Service;

@Controller
public class LoginController {
	@Autowired
	private Service LoginService;
	

	@RequestMapping(value = "/")
	public ModelAndView displayLogin() {
		ModelAndView model = new ModelAndView("welcomepage");
		return model;
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView loginview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("loginpage");
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
				model = new ModelAndView("homepage");
				model.addObject("name", login.getName());
			} else {

				model = new ModelAndView("loginpage");
				model.addObject("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
	@RequestMapping(value = "/generateofferletter", method = RequestMethod.GET)
	public ModelAndView generateofferletter(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("generateofferletter");
		return model;
		}
	@RequestMapping(value = "/generateofferletter", method = RequestMethod.POST)
	public ModelAndView generateofferletterresponse(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("Offer") Offer offer) throws InvalidFormatException, IOException {
		ModelAndView model = null;
		model = new ModelAndView("generateofferletter");
		if(LoginService.generateofferletter(offer.getEname(), offer.getDoj(),offer.getCtc(),offer.getRole(),offer.getFile()))
		{
			model.addObject("m","Successfull");
			return model;
		}
		model.addObject("m","UnSuccessfull");
		return model;
	}
	@RequestMapping(value = "/onboardemp", method = RequestMethod.GET)
	public ModelAndView onboar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("onboardemp");
		return model;
		}
	@RequestMapping(value = "/onboardemp", method = RequestMethod.POST)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("emp") employee emp) throws InvalidFormatException, IOException {
		ModelAndView model = null;
		
	
	if(LoginService.valid(emp.getEMP_NAME()))
				{
		model = new ModelAndView("onboardemp");
		employee empl=LoginService.EmployeeUsers(emp.getEMP_NAME());
		model.addObject("eid", empl.getEMP_ID());
		model.addObject("ename", empl.getEMP_NAME());
		model.addObject("eemail", empl.getEMAIL_ID());
		model.addObject("edid", empl.getDEPT_ID());
		model.addObject("edoj", empl.getDOJ());
		model.addObject("epan", empl.getPAN_NUMBER());
		model.addObject("eadar", empl.getAADHAR_NUMBER());
		model.addObject("ewexp", empl.getWORK_EXP());
		model.addObject("epro", empl.getPREV_ORG());
		model.addObject("ereda", empl.getRELEV_DATE());
		model.addObject("erid", empl.getREPORTING_ID());
		model.addObject("emid", empl.getMANAGER_ID());
		model.addObject("esysDate", empl.getSYS_CRE_DATE());
		model.addObject("esysLastDate", empl.getSYS_LST_MOD_DATE());
		
		
			return model;
				}
		
		model = new ModelAndView("onboardemp");
			model.addObject("dname", "UnSuccessfull");
	
		return model;
	
		
	}
}