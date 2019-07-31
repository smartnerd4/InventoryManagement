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
	private String DEFAULT_SEQUENCE_NAME = "IDSEQ";

	public Serializable generate(SharedSessionContractImplementor sessionImpl, Object data) throws HibernateException {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet reset = null;
		
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

			try {
				reset = statement.executeQuery(
						"SELECT EMP_ID FROM EMPLOYEE_DETAILS WHERE SYS_CRE_DATE = (SELECT MAX(SYS_CRE_DATE) FROM EMPLOYEE_DETAILS)");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (reset.next()) {
				String lastEMPID = reset.getString("EMP_ID");

				String sprevValue = "";
				sprevValue = sprevValue.concat(lastEMPID.substring(5));
				int prevValue = Integer.valueOf(sprevValue);
				System.out.println(prevValue);

				String slastMonth = "";
				slastMonth = slastMonth.concat(lastEMPID.substring(3, 5));
				int lastMonth = Integer.valueOf(slastMonth);
				System.out.println(lastMonth);

				String spresentMonth = "";
				spresentMonth = spresentMonth.concat(strDate.substring(4, 6));
				int presentMonth = Integer.valueOf(spresentMonth);
				System.out.println(presentMonth);
				
				if (lastMonth != presentMonth) {
					statement.execute("DROP SEQUENCE " + DEFAULT_SEQUENCE_NAME);
				}
			}
			
			try {
				resultSet = statement.executeQuery("SELECT " + DEFAULT_SEQUENCE_NAME + ".NEXTVAL FROM DUAL");
			} catch (Exception ex) {
				// if sequence is not found then creating the sequence
				statement.execute("CREATE SEQUENCE " + DEFAULT_SEQUENCE_NAME);
				System.out.println("Sequence Created successfully");
				resultSet = statement.executeQuery("SELECT " + DEFAULT_SEQUENCE_NAME + ".NEXTVAL FROM DUAL");
			}
			if (resultSet.next()) {
				int currentValue = resultSet.getInt(1);
				String suffix = String.format("%03d", currentValue);
				result = prefix.concat(suffix);
				System.out.println("Custom generated Sequence value : " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}