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

import com.smartnerd.model.ExcelUpload;
import com.smartnerd.model.OfferLetterModel;
import com.smartnerd.service.Service;
@Controller
public class ExcelUploadController {
	@Autowired
	private Service OfferService;
	
	@RequestMapping(value = "/excelupload", method = RequestMethod.GET)
	public ModelAndView generateofferletter(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("excelupload");
		return model;
		}
	@RequestMapping(value = "/excelupload", method = RequestMethod.POST)
	public ModelAndView generateofferletterresponse(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("excel") ExcelUpload excelmodel) throws InvalidFormatException, IOException {
		ModelAndView model = new ModelAndView("excelupload");
		return model;
		
}
}
