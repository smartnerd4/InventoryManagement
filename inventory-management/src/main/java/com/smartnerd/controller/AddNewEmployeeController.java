package com.smartnerd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;
import com.smartnerd.model.AddNewEmployeeModel;
import com.smartnerd.service.Service;

@Controller
public class AddNewEmployeeController {
	@Autowired
	private Service NewEmpService;

	@RequestMapping(value = "/addnewemployee", method = RequestMethod.GET)
	public ModelAndView onboar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("addnewemployee");
		return model;
	}

	@RequestMapping(value = "/addnewemployee", method = RequestMethod.POST)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("addnewemp") AddNewEmployeeModel anemodel,BindingResult br, @RequestParam CommonsMultipartFile[] fileUpload)
			throws InvalidFormatException, IOException, WriterException {
		ModelAndView model = null;

		boolean result = NewEmpService.addnewemployee(anemodel.getEmployeeName(), anemodel.getEmployeeEmail(), anemodel.getDeptID(),
				anemodel.getDoj(), anemodel.getPanNumber(), anemodel.getAadharNumber(), anemodel.getWorkExperience(),
				anemodel.getPreviousOrganisation(), anemodel.getRelevDate(), anemodel.getReportingID(), anemodel.getManagerID(),
				anemodel.getHighestQualification(), fileUpload, anemodel.getBloodGroup(), anemodel.getTshirtSize(),
				anemodel.getEmergencyAddress(), anemodel.getPermanentAddress(), anemodel.getPlaceofReporting(), anemodel.getGender(),
				anemodel.getPhoneNumber());

		if (result) {
			model = new ModelAndView("addnewemployee");
			model.addObject("emessage", "New Employee Details added to the Database!");
			return model;
		} else {
			model = new ModelAndView("addnewemployee");
			model.addObject("emessage", "Error adding details to the Database!");
			return model;
		}
	}
}
