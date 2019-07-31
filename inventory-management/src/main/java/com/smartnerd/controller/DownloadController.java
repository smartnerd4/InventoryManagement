package com.smartnerd.controller;

import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartnerd.model.EmployeeModel;

import com.smartnerd.service.Service;
@Controller
@RequestMapping("/download")
public class DownloadController {
	@Autowired
	ServletContext context;
	@Autowired
	Service Qrcode;
	
	@RequestMapping(value = "/img/{file_name}", method = RequestMethod.GET)
	public void getImage(@PathVariable("file_name") String fileName,HttpServletResponse response) throws FontFormatException {
	    try {

	    	EmployeeModel empl=Qrcode.get(fileName);
	    	File sourceImageFile = new ClassPathResource("ID.jpg").getFile(); 
			byte[]ImageFile=empl.getImage();
			String rootPath = System.getProperty("java.io.tmpdir");

		    String filePath = rootPath + File.separator+"front"+".jpg";
			File destImageFilefront = new File(filePath);
			String text=empl.getEmployeeName();
			String type="png";
			byte[]qrimg=empl.getQr();
			String id=empl.getEmployeeID();
			String blood=empl.getBloodGroup();
			String filePathend = rootPath + File.separator+"end"+".jpg";
			File destImageFileend = new File(filePathend);
			String pattern = "dd-MMM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String doj=simpleDateFormat.format(empl.getDoj());
			 String actufilePath = rootPath + File.separator+fileName;
				File actudestImageFilefront = new File(actufilePath);
		    	File sourceBackImageFile = new ClassPathResource("BID.jpg").getFile(); 

			Qrcode.IDcreation(sourceImageFile,ImageFile,destImageFilefront,qrimg,text,type,id,blood,destImageFileend,doj,actudestImageFilefront,sourceBackImageFile);
	      InputStream is = new FileInputStream(new File(actufilePath));
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (IOException ex) {
	      
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}
	@RequestMapping(value = "/pdf/{file_name}", method = RequestMethod.GET)
	public void getFile(
	    @PathVariable("file_name") String fileName, 
	    HttpServletResponse response) {
	    try {
	        String rootPath = System.getProperty("java.io.tmpdir");
	        String path=rootPath+ File.separator+fileName+".pdf";

	      InputStream is = new FileInputStream(new File(path));
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (IOException ex) {
	      
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}
	@RequestMapping(value = "/card/{file_name}", method = RequestMethod.GET)
	public void getBusinessCard(@PathVariable("file_name") String fileName,HttpServletResponse response) throws FontFormatException {

		try {
	        String rootPath = System.getProperty("java.io.tmpdir");
	        String path=rootPath+ File.separator+fileName;

	      InputStream is = new FileInputStream(new File(path));
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (IOException ex) {
	      
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}
}