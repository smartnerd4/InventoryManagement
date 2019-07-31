package com.smartnerd.controller;

import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;
import com.smartnerd.model.BusinessCardModel;
import com.smartnerd.service.Service;

@Controller
public class BusinessCardController {
	@Autowired
	private Service BusinessCard;

	@RequestMapping(value = "/generatebusinesscard", method = RequestMethod.GET)
	public ModelAndView businesscard(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("generatebusinesscard");
		return model;
	}

	@RequestMapping(value = "/generatebusinesscard", method = RequestMethod.POST)
	public ModelAndView businesscard(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("BusinessCardModel") BusinessCardModel bcmodel)
			throws InvalidFormatException, IOException, WriterException, FontFormatException {
		ModelAndView model = null;
		model = new ModelAndView("generatebusinesscard");
		
    	File sourceImageFile = new ClassPathResource("bsf.jpg").getFile(); 
		
		String rootPath = System.getProperty("java.io.tmpdir");

	    String filePath = rootPath + File.separator+"front"+".jpg";
		File destImageFilefront = new File(filePath);
		String name=bcmodel.getName();
		String email=bcmodel.getEmail();
		String phno=bcmodel.getPhoneNumber();
		
		File qrimg = new ClassPathResource("QR.png").getFile(); 
		String designation=bcmodel.getDesignation();
		String filePathend = rootPath + File.separator+"end"+".jpg";
		File destImageFileend = new File(filePathend);
		 String actufilePath = rootPath + File.separator+bcmodel.getName();
			File actudestImageFilefront = new File(actufilePath);
	    	File sourceBackImageFile = new ClassPathResource("bsb.png").getFile(); 
		if (BusinessCard.BCcreation(sourceImageFile,destImageFilefront,sourceBackImageFile,destImageFileend,actudestImageFilefront,name,email,phno,designation,qrimg) ){
			model.addObject("msg", "Business Card Generated Successfully");
			model.addObject("view", "Click here to View");
			model.addObject("name", bcmodel.getName());
			return model;
		}
		model.addObject("msg", "Unsuccessful");
		return model;
	}
}