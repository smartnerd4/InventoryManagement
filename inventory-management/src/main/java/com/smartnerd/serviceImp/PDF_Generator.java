package com.smartnerd.serviceImp;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

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
			float basicsalary, float hra, float pf, float standarddeduction, float lta)
			throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		String ctcc = String.valueOf(ctc);
		float mbasicsalarycal = basicsalary * ctc;
		float mhracal = hra * ctc;
		float mpfcal = pf * ctc;
		float mstandarddeductioncal = standarddeduction * ctc;
		float mltacal = lta * ctc;
		float mspecialallowancescal = ctc - (mbasicsalarycal + mhracal + mpfcal + mltacal) + mstandarddeductioncal;
		float mtotalcal = (mbasicsalarycal + mhracal + mpfcal + mltacal + mspecialallowancescal) - mstandarddeductioncal;
		int integermtotal = (int) mtotalcal;
		float ybasicsalarycal = mbasicsalarycal * 12;
		float yhracal = mhracal * 12;
		float ypfcal = mpfcal * 12;
		float ystandarddeductioncal = mstandarddeductioncal * 12;
		float yltacal = mltacal * 12;
		float yspecialallowancescal = mspecialallowancescal * 12;
		float ytotalcal = mtotalcal * 12;
		int integerytotal = (int) ytotalcal;
		String mbasicsalary = String.valueOf(mbasicsalarycal);
		String mhra = String.valueOf(mhracal);
		String mpf = String.valueOf(mpfcal);
		String mstandarddeduction = String.valueOf(mstandarddeductioncal);
		String mlta = String.valueOf(mltacal);
		String mspecialallowances = String.valueOf(mspecialallowancescal);
		String mtotal = String.valueOf(integermtotal);
		String ybasicsalary = String.valueOf(ybasicsalarycal);
		String yhra = String.valueOf(yhracal);
		String ypf = String.valueOf(ypfcal);
		String ystandarddeduction = String.valueOf(ystandarddeductioncal);
		String ylta = String.valueOf(yltacal);
		String yspecialallowances = String.valueOf(yspecialallowancescal);
		String ytotal = String.valueOf(integerytotal);

		try {
			Resource resource = new ClassPathResource("Input.docx");
			InputStream resourceInputStream = resource.getInputStream();
			XWPFDocument doc = new XWPFDocument(OPCPackage.open(resourceInputStream));
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
							text = text.replace("<varnctc>", nctc);
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
		} 
		finally {
		}
	}
}
