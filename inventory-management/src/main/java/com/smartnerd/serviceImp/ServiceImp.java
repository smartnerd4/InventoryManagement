package com.smartnerd.serviceImp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.smartnerd.dao.Dao;
import com.smartnerd.model.User;
import com.smartnerd.service.Service;
@Repository
public class ServiceImp implements Service{
	@Autowired
	private Dao dao;
	
	
	public boolean isValidUser(String username, String password)throws SQLException
	{
		SessionFactory sf=dao.getSessionFactory();
		Session s=sf.openSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.eq("USER_NAME",username));
		cr.add(Restrictions.eq("PASSWORD",password));
		List results = cr.list();
		if(results.size()>0)
		{
			return true;
		}
return false;
    }
	public boolean generatepdf(String name,Date date,int ctc,String role)
	{
		  Document document = new Document();
		  	Font normal = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL);
		  	Font bold = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD);
		      try
		      {
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
		       
		         
		        
		         document.open();
		         document.add(new Paragraph("April 26, 2019",normal));
		         document.add(new Paragraph("\n"));
		     
		         document.add(new Paragraph("Subject: Employment Offer Letter - Confidential ",normal));
		         document.add(new Paragraph("\n"));

		         document.add(new Paragraph("Dear "+name,normal));
		         document.add(new Paragraph("\n"));

		         Chunk c1=new Chunk("Congratulations! On behalf of ",normal);
		         Chunk c2=new Chunk("Smartnerd ",bold);
		         Chunk c3=new Chunk("(“Company”), it is my pleasure to extend our offer of employment to you. This offer and the opportunity it represents is extended with great confidence in your abilities. You made a favourable impression with everyone you met, and we are excited with the prospect of you joining the Company.\r\n\n",normal);
		         Chunk c4=new Chunk("If you accept this offer of employment, you will be appointed as a "+role+" in Hyderabad. Your appointment date is effective from your date of joining i.e.",normal);
		         Chunk c5=new Chunk(""+date,bold);
		         Chunk c6=new Chunk(". You should report for joining no later than 9:30 A.M. on your joining date. \r\n\n",normal); 
		         Chunk c7=new Chunk("Your all-inclusive compensation, on a cost to the company basis, is ",normal);
		         Chunk c8=new Chunk("Rs."+ctc,bold);
		         Chunk c9=new Chunk(", payable as a monthly salary less applicable taxes and deductions. Your compensation details are confidential, and you may discuss it only with the undersigned individual in case of any clarification.",normal);
		         Chunk c10=new Chunk("Annexure 1 – Compensation CTC ",bold);
		         Chunk c11=new Chunk("provides a breakup and explanation of the components of your compensation.\r\n\n",normal);
		         Chunk c12=new Chunk("Your employment at Smartnerd will be governed by the terms and conditions in ",normal);
		         Chunk c13=new Chunk("Annexure 2 - Employment Agreement ",bold);
		         Chunk c14=new Chunk("as well as all rules, regulations, guidelines, policies and practices of the Company, which may be amended from time to time. Please read the Employment Agreement carefully as it becomes binding on you on your date of joining. \r\n\n",normal);  
		         Chunk c15=new Chunk("On your date of joining, you are required to submit the documents listed in the attached ",normal);
		         Chunk c16=new Chunk("Joining Documents Checklist.",bold); 
		         Chunk c17=new Chunk("Please notify us immediately if there are any issues with your documentation. \r\n\n",normal);
		         Chunk c18=new Chunk("We look forward to having you join the Company’s team of outstanding professionals. If you wish to discuss any detail of this offer, please feel free to contact me. \r\n\n",normal); 
		         Chunk c19=new Chunk("To accept this offer and the appointment terms and conditions, please sign and date below. \r\n\n",normal);
		         Chunk c20=new Chunk("\t                                                               For Scientella Electronics & Electricals Ltd,\r\n",bold); 
		         Chunk c21=new Chunk("Manager – Talent Acquisition  ",normal);
		        												

		        												 Paragraph p1 = new Paragraph();

					p1.add(c1);
					p1.add(c2);
					p1.add(c3);
					p1.add(c4);
					p1.add(c5);
					p1.add(c6);
					p1.add(c7);
					p1.add(c8);
					p1.add(c9);
					p1.add(c10);
					p1.add(c11);
					p1.add(c12);
					p1.add(c13);
					p1.add(c14);
					p1.add(c15);
					p1.add(c16);
					p1.add(c17);
					p1.add(c18);
					p1.add(c19);
					p1.add(c20);
					p1.add(c21);
					
		        												 
		        												 

		document.add(p1);
		         
		         document.close();
		         writer.close();
		      } catch (DocumentException e)
		      {
		         e.printStackTrace();
		      } catch (FileNotFoundException e)
		      {
		         e.printStackTrace();
		      }
		   
		
		return true;
	}

}
