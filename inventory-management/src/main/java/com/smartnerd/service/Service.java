package com.smartnerd.service;

import java.sql.SQLException;

public interface Service {

	public boolean isValidUser(String user_NAME, String password)throws SQLException;

}
