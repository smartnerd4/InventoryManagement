package com.smartnerd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.service.Service;

@Controller
public class AddNewEmployeeController {
	@Autowired
	private Service NewEmpService;

	@RequestMapping(value = "/addnewemployee", method = RequestMethod.GET)
	public ModelAndView addnewemployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("addnewemployee");
		return model;
	}

	@RequestMapping(value = "/addnewemployee", method = RequestMethod.POST)
	public ModelAndView addnewemployee(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("addnewemp") OnboardEmployeeModel oemodel) {
		ModelAndView model = null;

		boolean result = NewEmpService.addnewemployee(oemodel.getEmployee_Name(), oemodel.getEmployee_Email(),
				oemodel.getDept_Id(), oemodel.getDoj(), oemodel.getPan_Number(), oemodel.getAadhar_Number(),
				oemodel.getWork_Experience(), oemodel.getPrevious_Organisation(), oemodel.getRelev_Date(),
				oemodel.getReporting_Id(), oemodel.getManager_Id(), oemodel.getEducation_Qualification());
		if(result)
		{
			model= new ModelAndView("addnewemployee");
			model.addObject("msg","Successful");
		}
		else
		{
			model=new ModelAndView("addnewemployee");
			model.addObject("msg","Unsuccessful");
		}
		return model;
	}
}
