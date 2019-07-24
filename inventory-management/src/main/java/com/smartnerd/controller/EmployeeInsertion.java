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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;
import com.smartnerd.model.Employee;
	import com.smartnerd.service.Service;
	@Controller
	public class EmployeeInsertion {
		@Autowired
		private Service OnbordService;
		@RequestMapping(value = "/EmployeeInsertion", method = RequestMethod.GET)
		public ModelAndView onboar(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView model = new ModelAndView("EmployeeInsertion");
			return model;
			}
//		@RequestMapping(value = "/EmployeeInsertion", method = RequestMethod.POST)
//		public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("emp") Employee emp) throws InvalidFormatException, IOException, WriterException {
//			ModelAndView model = null;
//			
//			
//			
//		if(OnbordService.insertion(emp.getEmployee_Name(),emp.getEmployee_Email(),emp.getDept_Id(),emp.getDoj(),emp.getPan_Number(),emp.getAadar_Number(),emp.getWork_Experience(),emp.getPrevious_Organisation(),emp.getReleve_Date(),emp.getReporting_Id(),emp.getManager_Id(),emp.getEducation_Qualification()))
//					{
//			model = new ModelAndView("EmployeeInsertion");
//			
//			model.addObject("emessage", "successfull");
//			
//			
//			
//				return model;
//					}
//			
//			model = new ModelAndView("EmployeeInsertion");
//				model.addObject("emessage", "unsuccessfull");
//		
//			return model;
//		
//			
//		}
		@RequestMapping(value = "/EmployeeInsertion", method = RequestMethod.POST)
		public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("emp") Employee emp, @RequestParam CommonsMultipartFile[] fileUpload) throws InvalidFormatException, IOException, WriterException {
			ModelAndView model = null;
		
			
		if(OnbordService.insertion(emp.getEmployee_Name(),emp.getEmployee_Email(),emp.getDept_Id(),emp.getDoj(),emp.getPan_Number(),emp.getAadar_Number(),emp.getWork_Experience(),emp.getPrevious_Organisation(),emp.getReleve_Date(),emp.getReporting_Id(),emp.getManager_Id(),emp.getEducation_Qualification(),fileUpload,emp.getBloodgroup(),emp.getTshirtsize(),emp.getEmergencyaddr(),emp.getPermaaddr(),emp.getPlaceofreporting(),emp.getGender(),emp.getPhno()))
					{
			model = new ModelAndView("EmployeeInsertion");
			
			model.addObject("emessage", "successfull");
			
			
			
				return model;
					}
			
			model = new ModelAndView("EmployeeInsertion");
				model.addObject("emessage", "unsuccessfull");
		
			return model;
		
			
		}
	}



