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

import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.service.Service;

@Controller
public class OnboardEmployeeController {
	@Autowired
	private Service OnboardService;
	
	@RequestMapping(value = "/onboardemployee", method = RequestMethod.GET)
	public ModelAndView onboardemployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("onboardemployee");
		return model;
	}

	@RequestMapping(value = "/onboardemployee", method = RequestMethod.POST)
	public ModelAndView onboardemployee(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("onboardemp") OnboardEmployeeModel oemodel) throws InvalidFormatException, IOException {
		ModelAndView model = null;

		OnboardEmployeeModel oemodel1 = OnboardService.onboardemployeemodel(oemodel.getEmployee_Name());
		if (oemodel1 != null) {
			model = new ModelAndView("onboardemployee");
			model.addObject("msg","Employee Found!");
			model.addObject("eid", oemodel1.getEmployee_Id());
			model.addObject("ename", oemodel1.getEmployee_Name());
			model.addObject("eemail", oemodel1.getEmployee_Email());
			model.addObject("edeptid", oemodel1.getDept_Id());
			model.addObject("edoj", oemodel1.getDoj());
			model.addObject("epanno", oemodel1.getPan_Number());
			model.addObject("eaadno", oemodel1.getAadhar_Number());
			model.addObject("eworkexp", oemodel1.getWork_Experience());
			model.addObject("eprevorg", oemodel1.getPrevious_Organisation());
			model.addObject("erelevdate", oemodel1.getRelev_Date());
			model.addObject("erepid", oemodel1.getReporting_Id());
			model.addObject("emanid", oemodel1.getManager_Id());
			model.addObject("ehighqual",oemodel1.getEducation_Qualification());
			model.addObject("esyscredate", oemodel1.getSystem_Created_Date());
			model.addObject("esyslastdate", oemodel1.getSystem_Last_Modified_Date());

			return model;
		}

		model = new ModelAndView("onboardemployee");
		model.addObject("msg", "Employee not Found!");

		return model;

	}
}
