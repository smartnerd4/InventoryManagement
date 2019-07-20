package com.smartnerd.model;

import java.util.Date;

public class OnboardEmployeeModel {
	private String employee_Id;
	private String employee_Name;
	private String employee_Email;
	private String dept_Id;
	private Date doj;
	private String pan_Number;
	private String aadhar_Number;
	private Integer work_Experience;
	private String previous_Organisation;
	private Date relev_Date;
	private String reporting_Id;
	private String manager_Id;
	private String education_Qualification;
	private int City;
	private Date system_Created_Date;
	private Date system_Last_Modified_Date;

	public String getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}

	public String getEmployee_Email() {
		return employee_Email;
	}

	public void setEmployee_Email(String employee_Email) {
		this.employee_Email = employee_Email;
	}

	public String getDept_Id() {
		return dept_Id;
	}

	public void setDept_Id(String dept_Id) {
		this.dept_Id = dept_Id;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getPan_Number() {
		return pan_Number;
	}

	public void setPan_Number(String pan_Number) {
		this.pan_Number = pan_Number;
	}

	public String getAadhar_Number() {
		return aadhar_Number;
	}

	public void setAadhar_Number(String aadhar_Number) {
		this.aadhar_Number = aadhar_Number;
	}

	public Integer getWork_Experience() {
		return work_Experience;
	}

	public void setWork_Experience(Integer work_Experience) {
		this.work_Experience = work_Experience;
	}

	public String getPrevious_Organisation() {
		return previous_Organisation;
	}

	public void setPrevious_Organisation(String previous_Organisation) {
		this.previous_Organisation = previous_Organisation;
	}
	
	public Date getRelev_Date() {
		return relev_Date;
	}

	public void setRelev_Date(Date relev_Date) {
		this.relev_Date = relev_Date;
	}

	public String getReporting_Id() {
		return reporting_Id;
	}

	public void setReporting_Id(String reporting_Id) {
		this.reporting_Id = reporting_Id;
	}

	public String getManager_Id() {
		return manager_Id;
	}

	public void setManager_Id(String manager_Id) {
		this.manager_Id = manager_Id;
	}

	public String getEducation_Qualification() {
		return education_Qualification;
	}

	public void setEducation_Qualification(String education_Qualification) {
		this.education_Qualification = education_Qualification;
	}

	public int getCity() {
		return City;
	}

	public void setCity(int city) {
		City = city;
	}

	public Date getSystem_Created_Date() {
		return system_Created_Date;
	}

	public void setSystem_Created_Date(Date system_Created_Date) {
		this.system_Created_Date = system_Created_Date;
	}

	public Date getSystem_Last_Modified_Date() {
		return system_Last_Modified_Date;
	}

	public void setSystem_Last_Modified_Date(Date system_Last_Modified_Date) {
		this.system_Last_Modified_Date = system_Last_Modified_Date;
	}

}