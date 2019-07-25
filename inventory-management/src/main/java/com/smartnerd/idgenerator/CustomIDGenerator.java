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

public class CustomIDGenerator implements IdentifierGenerator {

	private String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";

	public Serializable generate(SharedSessionContractImplementor sessionImpl, Object data) throws HibernateException {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			int hyderabad = 9;
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String strDate = dateFormat.format(date);

			String userid = "";
			String hyd = String.valueOf(hyderabad);
			userid = userid.concat(hyd);

			userid = userid.concat(strDate.substring(2, 6));

			String prefix = userid;
			connection = sessionImpl.connection();
			statement = connection.createStatement();
			try {
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