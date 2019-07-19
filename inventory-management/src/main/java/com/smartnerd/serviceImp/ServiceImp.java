package com.smartnerd.serviceImp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;

import com.itextpdf.text.pdf.parser.Path;
import com.itextpdf.text.pdf.parser.clipper.Paths;
import com.smartnerd.dao.Dao;
import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.model.UserModel;
import com.smartnerd.service.Service;

@Repository
public class ServiceImp implements Service {
	@Autowired
	private Dao dao;

	public boolean isValidUser(String username, String password) {
		UserModel umodel = dao.isValidUser(username, password);
		if (umodel != null) {
			return true;
		}
		return false;
	}

	public boolean generateofferletter(String ename, String doj, int ctc, String role, String file)
			throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		String ctcc = String.valueOf(ctc);
		try {
			XWPFDocument doc = new XWPFDocument(OPCPackage.open("d:\\Input.docx"));
			for (XWPFParagraph p : doc.getParagraphs()) {

				List<XWPFRun> runs = p.getRuns();

				if (runs != null) {
					for (XWPFRun r : runs) {

						String text = r.getText(0);

						if (text != null && text.contains("<varname>")) {
							text = text.replace("<varname>", ename);
							r.setText(text, 0);
						}
						if (text != null && text.contains("<varrole>")) {
							text = text.replace("<varrole>", role);
							r.setText(text, 0);
						}
						if (text != null && text.contains("<vardoj>")) {
							text = text.replace("<vardoj>", doj);
							r.setText(text, 0);
						}
						if (text != null && text.contains("<varctc")) {
							text = text.replace("<varctc>", ctcc);
							r.setText(text, 0);

						}

					}
				}
			}

			for (XWPFTable tbl : doc.getTables()) {
				for (XWPFTableRow row : tbl.getRows()) {
					for (XWPFTableCell cell : row.getTableCells()) {
						for (XWPFParagraph p : cell.getParagraphs()) {
							for (XWPFRun r : p.getRuns()) {
								String text = r.getText(0);
								if (text != null && text.contains("a1")) {
									text = text.replace("a1", "abcd");
									r.setText(text, 0);
								}
							}
						}
					}
				}
			}
			doc.write(new FileOutputStream("d:\\output.docx"));

		} finally {
			// InputStream doc = new FileInputStream(new File("d:\\output.docx"));
			// XWPFDocument document = new XWPFDocument(doc);
			// PdfOptions options = PdfOptions.create();
			// OutputStream out = new FileOutputStream(new File(file));
			//
			// PdfConverter.getInstance().convert(document, out, options);

		}
		return true;
	}

	public OnboardEmployeeModel onboardemployeemodel(String emp_NAME) {
		OnboardEmployeeModel oemodel = dao.onboardemployeemodel(emp_NAME);
		return oemodel;
	}

	public boolean addnewemployee(String employee_Name, String employee_Email, String dept_Id, Date doj,
			String pan_Number, String aadhar_Number, Integer work_Experience, String previous_Organisation,
			Date relev_Date, String reporting_Id, String manager_Id, String education_Qualification) {
		
		dao.addnewemployee(employee_Name, employee_Email, dept_Id, doj, pan_Number, aadhar_Number, work_Experience,
				previous_Organisation, relev_Date, reporting_Id, manager_Id, education_Qualification);
		return true;
	}

}
