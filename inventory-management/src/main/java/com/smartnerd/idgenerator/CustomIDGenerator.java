package com.smartnerd.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.smartnerd.model.EmployeeInterface;

public class CustomIDGenerator implements IdentifierGenerator {

	private String DEFAULT_SEQUENCE_NAME = "ID";

	public Serializable generate(SharedSessionContractImplementor sessionImpl, Object data) throws HibernateException {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
//		ResultSet reset=null;
//		ResultSet subset=null;

		EmployeeInterface identifiable = (EmployeeInterface) data;
        Serializable id = identifiable.getCity();
		try {
			
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String strDate = dateFormat.format(date);

			String userid = "";
			String citycode = String.valueOf(id);
			userid = userid.concat(citycode);

			userid = userid.concat(strDate.substring(2, 6));

			String prefix = userid;
			connection = sessionImpl.connection();
			statement = connection.createStatement();
//   		reset = statement.executeQuery("SELECT * FROM EMPLOYEE_DETAILS WHERE SYS_CRE_DATE = (SELECT MAX(SYS_CRE_DATE) FROM EMPLOYEE_DETAILS)");
//   		String arr = null;
//		while (reset.next()) {
//		    String em = reset.getString("EMP_ID");
//		    arr = em.replace("\n", ",");
//		}
////		System.out.println(arr);
//		if(arr!=null)
//		{
//		String subsetold=arr.substring(1,5);
//		String subsetnew=strDate.substring(2, 6);
//		String value=arr.substring(6);
//		int setold=Integer.valueOf(subsetold);
//		int setnew=Integer.valueOf(subsetnew);
//		int valuetotal=Integer.valueOf(value);
//		System.out.println(setold+","+setnew+","+valuetotal);
//		int valuetobesub=valuetotal-1;
//		if(setnew>setold)
//		{
//			subset = statement.executeQuery("ALTER SEQUENCE ID INCREMENT BY -"+valuetobesub);
//			
//			String suffix = String.format("%03d", valuetotal-valuetobesub);
//			result = prefix.concat(suffix);
//			System.out.println("Custom generated Sequence value : " + result);
//
//			return result;
//
////			subset = statement.executeQuery("ALTER SEQUENCE hibernate_sequence  RESTART");
//		}
//		}
//		
//			ResultSet count=statement.executeQuery("COUNT(*)");
//			reset = statement.executeQuery("SELECT MAX(EMP_ID) FROM EMPLOYEE_DETAILS ORDER BY EMP_ID DESC;");
//			System.out.println(reset.toString());
			try {
//				reset = statement.executeQuery("SELECT LAST (EMP_ID) FROM EMPLOYEE_DETAILS" );
//				String arr = null;
//				while (reset.next()) {
//				    String em = reset.getString("EMP_ID");
//				    arr = em.replace("\n", ",");
//				    System.out.println(arr);
//				}
//				resultSet = statement.executeQuery("ALTER SEQUENCE ID INCREMENT BY +1");

				resultSet = statement.executeQuery("SELECT " + DEFAULT_SEQUENCE_NAME + ".NEXTVAL FROM DUAL");
			} catch (Exception ex) {
				// if sequence is not found then creating the sequence
				statement = connection.createStatement();
				statement.execute("CREATE SEQUENCE " + DEFAULT_SEQUENCE_NAME);
				System.out.println("Sequece Created successfully. ");
				resultSet = statement.executeQuery("call next value for " + DEFAULT_SEQUENCE_NAME);
			}

			if (resultSet.next()) {
				int nextValue = resultSet.getInt(1);
				String suffix = String.format("%03d", nextValue + 1);
				result = prefix.concat(suffix);
				System.out.println("Custom generated Sequence value : " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}