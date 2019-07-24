package com.smartnerd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartnerd.model.Employee;
import com.smartnerd.service.Service;
@Controller
@RequestMapping("/download")
public class DownloadController {
	@Autowired
	ServletContext context;
	@Autowired
	Service Qrcode;
	
	@RequestMapping(value = "/img/{file_name}", method = RequestMethod.GET)
	public void getImage(@PathVariable("file_name") String fileName,HttpServletResponse response) {
	    try {

	    	Employee empl=Qrcode.get(fileName);
	    	File sourceImageFile = new ClassPathResource("ID.jpg").getFile(); 
			byte[]ImageFile=empl.getImage();
			String rootPath = System.getProperty("java.io.tmpdir");

		    String filePath = rootPath + File.separator+empl.getEmployee_Name()+".jpg";
			File destImageFile = new File(filePath);
			
			String text=empl.getEmployee_Name();
			String type="png";
			byte[]qrimg=empl.getQr();
			String id=empl.getEmployee_Id();
			String blood=empl.getPhno();
			Qrcode.IDcreation(sourceImageFile,ImageFile,destImageFile,qrimg,text,type,id,blood);
	      InputStream is = new FileInputStream(new File(filePath));
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
}
