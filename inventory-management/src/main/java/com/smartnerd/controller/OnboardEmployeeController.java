package com.smartnerd.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.IOUtils;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.Employee;
import com.smartnerd.service.Service;
import com.smartnerd.dao.Dao;
@Controller
public class OnboardEmployeeController {
	@Autowired
	private Service OnboardService;
	@Autowired
	private Dao dao;
	@RequestMapping(value = "/onboardemp", method = RequestMethod.GET)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("onboardemp");
		return model;
		}
	@RequestMapping(value = "/onboardemp", method = RequestMethod.POST)
	public ModelAndView onboard(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("emp") Employee emp) throws InvalidFormatException, IOException {
		ModelAndView model = null;
		Employee empl=OnboardService.EmployeeUsers(emp.getEmployee_Name());
		if(empl!=null)
		{
			model = new ModelAndView("onboardemp");
		model.addObject("eid", empl.getEmployee_Id());
		model.addObject("ename", empl.getEmployee_Name());
		model.addObject("eemail", empl.getEmployee_Email());
		model.addObject("edid", empl.getDept_Id());
		model.addObject("edoj", empl.getDoj());
		model.addObject("epan", empl.getPan_Number());
		model.addObject("eadar", empl.getAadar_Number());
		model.addObject("ewexp", empl.getWork_Experience());
		model.addObject("epro", empl.getPrevious_Organisation());
		model.addObject("ereda", empl.getReleve_Date());
		model.addObject("erid", empl.getReporting_Id());
		model.addObject("emid", empl.getManager_Id());
		model.addObject("emid", empl.getEducation_Qualification());
		model.addObject("esysDate", empl.getSystem_Created_Date());
		model.addObject("esysLastDate", empl.getSystem_Last_Modified_Date());
		 byte[] encodeBase64 = Base64.encode(empl.getQr());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    model.addObject("blob", base64Encoded );
//		model.addObject("blob", empl.getQr());
		return model;
				}
		
		model = new ModelAndView("onboardemp");
			model.addObject("eid", "Not Found");
	
		return model;
	
		
	}
//	@RequestMapping(value = "/getStudentPhoto/{id}")
//	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
//		response.setContentType("image/jpeg");
//
//		Blob ph = dao.getPhotoById(id);
//
//		byte[] bytes = ph.getBytes(1, (int) ph.length());
//		InputStream inputStream = new ByteArrayInputStream(bytes);
//		IOUtils.copy(inputStream, response.getOutputStream());
//	}
}

