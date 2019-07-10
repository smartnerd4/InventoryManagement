package com.smartnerd.model;

import java.util.Date;

public class User {
	private String USER_ID;

	private String USER_NAME;


	private String PASSWORD;

	private Date SYS_CRE_DATE;


	private Date SYS_LST_MOD_DATE;

	private int ACT_IN;

	private String COMMENTS;

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public Date getSYS_CRE_DATE() {
		return SYS_CRE_DATE;
	}

	public void setSYS_CRE_DATE(Date sYS_CRE_DATE) {
		SYS_CRE_DATE = sYS_CRE_DATE;
	}

	public Date getSYS_LST_MOD_DATE() {
		return SYS_LST_MOD_DATE;
	}

	public void setSYS_LST_MOD_DATE(Date sYS_LST_MOD_DATE) {
		SYS_LST_MOD_DATE = sYS_LST_MOD_DATE;
	}

	public int getACT_IN() {
		return ACT_IN;
	}

	public void setACT_IN(int aCT_IN) {
		ACT_IN = aCT_IN;
	}

	public String getCOMMENTS() {
		return COMMENTS;
	}

	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}


}