package com.smartnerd.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.EmployeeModel;
import com.smartnerd.service.Service;

@Controller
public class OnboardEmployeeController {
	@Autowired
	private Service OnboardService;

	@RequestMapping(value = "/onboardemployee", method = RequestMethod.GET)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("onboardemployee");
		return model;
	}

	@RequestMapping(value = "/onboardemployee", method = RequestMethod.POST)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("onboardemp") EmployeeModel onboardemployeemodel) throws InvalidFormatException, IOException {
		ModelAndView model = null;
		EmployeeModel oemodel1 = OnboardService.oemodel(onboardemployeemodel.getEmployeeName());
		if (oemodel1 != null) {
			
			model = new ModelAndView("onboardemployee");
			model.addObject("msg", "Employee Found!");

			model.addObject("eid", oemodel1.getEmployeeID());
			model.addObject("ename", oemodel1.getEmployeeName());
			model.addObject("eemail", oemodel1.getEmployeeEmail());
			model.addObject("edeptid", oemodel1.getDeptID());
			model.addObject("edoj", oemodel1.getDoj());
			model.addObject("epanno", oemodel1.getPanNumber());
			model.addObject("eaadno", oemodel1.getAadharNumber());
			model.addObject("eworkexp", oemodel1.getWorkExperience());
			model.addObject("eprevorg", oemodel1.getPreviousOrganisation());
			model.addObject("erelevdate", oemodel1.getRelevDate());
			model.addObject("erepid", oemodel1.getReportingID());
			model.addObject("emanid", oemodel1.getManagerID());
			model.addObject("ehighqual", oemodel1.getHighestQualification());
			model.addObject("esyscredate", oemodel1.getSystemCreatedDate());
			model.addObject("esyslastdate", oemodel1.getSystemLastModifiedDate());
			byte[] encodeBase64 = Base64.encode(oemodel1.getQr());
			String base64Encoded = new String(encodeBase64, "UTF-8");
			model.addObject("blob", base64Encoded);
			return model;
		} 
			model = new ModelAndView("onboardemployee");
			model.addObject("msg", "Employee Not Found!");
			return model;
		

	}
}
