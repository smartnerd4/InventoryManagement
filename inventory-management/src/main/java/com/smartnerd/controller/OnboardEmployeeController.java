package com.smartnerd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.Employee;
import com.smartnerd.service.Service;
@Controller
public class OnboardEmployeeController {
	@Autowired
	private Service OnbordService;
	@RequestMapping(value = "/onboardemp", method = RequestMethod.GET)
	public ModelAndView onboar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("onboardemp");
		return model;
		}
	@RequestMapping(value = "/onboardemp", method = RequestMethod.POST)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("emp") Employee emp) throws InvalidFormatException, IOException {
		ModelAndView model = null;
		
	
	if(OnbordService.valid(emp.getEmployee_Name()))
				{
		model = new ModelAndView("onboardemp");
		
		Employee empl=OnbordService.EmployeeUsers(emp.getEmployee_Name());
		model.addObject("eid", empl.getEmployee_Id());
		model.addObject("ename", empl.getEmployee_Name());
		model.addObject("eemail", empl.getEmployee_Id());
		model.addObject("edid", empl.getDept_Id());
		model.addObject("edoj", empl.getDoj());
		model.addObject("epan", empl.getPan_Number());
		model.addObject("eadar", empl.getAadar_Number());
		model.addObject("ewexp", empl.getWork_Experience());
		model.addObject("epro", empl.getPrevious_Organisation());
		model.addObject("ereda", empl.getReleve_Date());
		model.addObject("erid", empl.getReporting_Id());
		model.addObject("emid", empl.getManager_Id());
		model.addObject("esysDate", empl.getSystem_Created_Date());
		model.addObject("esysLastDate", empl.getSystem_Last_Modified_Date());
		
		
			return model;
				}
		
		model = new ModelAndView("onboardemp");
			model.addObject("eid", emp.getEmployee_Name());
	
		return model;
	
		
	}
}

