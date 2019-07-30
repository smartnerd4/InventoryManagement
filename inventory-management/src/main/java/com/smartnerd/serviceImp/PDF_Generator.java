package com.smartnerd.serviceImp;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PDF_Generator {
	@Autowired
	static ServletContext context;

	public static void ConvertToPDF(String ename, String doj, int ctc, String nctc, String role, String file,
			float basicsalary, float hra, float pf, float standarddeduction, float lta, float specialallowance)
			throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		Locale indiaLocale = new Locale("en", "IN");
		NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
		String temp = india.format(ctc);
		String temp1 = temp.replace("Rs.", "");
		String ctcc = String.valueOf(temp1);
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy");
		Date dateofissue = new Date();
		String doi = dateFormat.format(dateofissue);
		float fybasicsalarycal = basicsalary * ctc;
		int ybasicsalarycal = Math.round(fybasicsalarycal);
		float fyhracal = hra * ctc;
		int yhracal = Math.round(fyhracal);
		float fypfcal = pf * ctc;
		int ypfcal = Math.round(fypfcal);
		float fystandarddeductioncal = standarddeduction * ctc;
		int ystandarddeductioncal = Math.round(fystandarddeductioncal);
		float fyltacal = lta * ctc;
		int yltacal = Math.round(fyltacal);
		float fyspecialallowancescal = specialallowance * ctc;
		int yspecialallowancescal = Math.round(fyspecialallowancescal);
		float ytotalcal = fybasicsalarycal + fyhracal + fypfcal + fyltacal + fyspecialallowancescal + fystandarddeductioncal;
		int integerytotal = (int)ytotalcal;
		String ybasicsalary = String.valueOf(ybasicsalarycal);
		String yhra = String.valueOf(yhracal);
		String ypf = String.valueOf(ypfcal);
		String ystandarddeduction = String.valueOf(ystandarddeductioncal);
		String ylta = String.valueOf(yltacal);
		String yspecialallowances = String.valueOf(yspecialallowancescal);
		String ytotal = String.valueOf(integerytotal);
		int mbasicsalarycal = ybasicsalarycal / 12;
		int mhracal = yhracal / 12;
		int mpfcal = ypfcal / 12;
		int mstandarddeductioncal = ystandarddeductioncal / 12;
		int mltacal = yltacal / 12;
		int mspecialallowancescal = yspecialallowancescal / 12;
		float mtotalcal = ytotalcal / 12;
		float integermtotal = mtotalcal;
		String mbasicsalary = String.valueOf(mbasicsalarycal);
		String mhra = String.valueOf(mhracal);
		String mpf = String.valueOf(mpfcal);
		String mstandarddeduction = String.valueOf(mstandarddeductioncal);
		String mlta = String.valueOf(mltacal);
		String mspecialallowances = String.valueOf(mspecialallowancescal);
		String mtotal = String.valueOf(String.format("%.2f", integermtotal));
		try {
			Resource resource = new ClassPathResource("Input.docx");
			InputStream resourceInputStream = resource.getInputStream();
			XWPFDocument doc = new XWPFDocument(OPCPackage.open(resourceInputStream));
			for (XWPFParagraph p : doc.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("<vardate>")) {
							text = text.replace("<vardate>",doi);
							r.setText(text, 0);
						}
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
						if (text != null && text.contains("<varnctc")) {
							text = text.replace("<varnctc>", ctcc);
							r.setText(text, 0);

						}
						if (text != null && text.contains("<varctc")) {
							text = text.replace("<varctc>", nctc);
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
								if (text != null && text.contains("<mbs>")) {
									text = text.replace("<mbs>", mbasicsalary);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<mhra>")) {
									text = text.replace("<mhra>", mhra);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<mpf>")) {
									text = text.replace("<mpf>", mpf);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<msd>")) {
									text = text.replace("<msd>", mstandarddeduction);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<mlta>")) {
									text = text.replace("<mlta>", mlta);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<msa>")) {
									text = text.replace("<msa>", mspecialallowances);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<mtctc>")) {
									text = text.replace("<mtctc>", mtotal);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<abs>")) {
									text = text.replace("<abs>", ybasicsalary);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<ahra>")) {
									text = text.replace("<ahra>", yhra);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<apf>")) {
									text = text.replace("<apf>", ypf);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<asd>")) {
									text = text.replace("<asd>", ystandarddeduction);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<alta>")) {
									text = text.replace("<alta>", ylta);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<asa>")) {
									text = text.replace("<asa>", yspecialallowances);
									r.setText(text, 0);
								}
								if (text != null && text.contains("<atctc>")) {
									text = text.replace("<atctc>", ytotal);
									r.setText(text, 0);
								}

							}
						}
					}
				}
			}
			PdfOptions options = PdfOptions.create();
			String rootPath = System.getProperty("java.io.tmpdir");
			File output = new File(rootPath + File.separator + ename + doj + ".pdf");
			OutputStream out = new FileOutputStream(output);
			PdfConverter.getInstance().convert(doc, out, options);
		} finally {
		}
	}
}
