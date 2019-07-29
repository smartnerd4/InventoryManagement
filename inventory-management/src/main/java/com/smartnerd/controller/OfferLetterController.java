package com.smartnerd.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartnerd.model.OfferLetterModel;
import com.smartnerd.service.Service;
@Controller
public class OfferLetterController {
	@Autowired
	private Service OfferService;
	
	@RequestMapping(value = "/generateofferletter", method = RequestMethod.GET)
	public ModelAndView generateofferletter(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("generateofferletter");
		return model;
		}
	@RequestMapping(value = "/generateofferletter", method = RequestMethod.POST)
	public ModelAndView generateofferletterresponse(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("Offer") OfferLetterModel offer) throws InvalidFormatException, IOException {
		ModelAndView model = null;
		model = new ModelAndView("generateofferletter");
	
		if(OfferService.generateofferletter(offer.getEname(), offer.getDoj(),offer.getCtc(),offer.getRole(),offer.getFile(),offer.getBasicsalary(),offer.getHra(),offer.getPf(),offer.getStandarddeduction(),offer.getLta(),offer.getSpecialallowance()))
		{
			String Downloadfilename=offer.getEname()+ offer.getDoj()+".pdf";
			model.addObject("m","Ready to download");
			model.addObject("name",Downloadfilename);
			return model;
		}
		model.addObject("m","UnSuccessfull");
		return model;
	}
}
