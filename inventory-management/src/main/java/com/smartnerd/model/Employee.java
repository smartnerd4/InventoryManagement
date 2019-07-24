package com.smartnerd.model;

import java.util.Date;

public class Employee implements EmployeeInterface<Integer> {
	private String employee_Id;
	private String employee_Name;
	private String employee_Email;
	private String dept_Id;
	private Date doj;
	private String pan_Number;
	private String aadar_Number;
	private Integer work_Experience;
	private String previous_Organisation;
	private Date releve_Date;
	private Integer city;
	private String reporting_Id;
	private String manager_Id;
	private String education_Qualification;
	private Date system_Created_Date;
	private Date system_Last_Modified_Date;
	private byte[] qr;
	private byte[] image;
	private String bloodgroup;
	private String tshirtsize;
	private String emergencyaddr;
	private String permaaddr;
    private String placeofreporting;
	private String gender;
	private String phno;

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getTshirtsize() {
		return tshirtsize;
	}

	public void setTshirtsize(String tshirtsize) {
		this.tshirtsize = tshirtsize;
	}

	public String getEmergencyaddr() {
		return emergencyaddr;
	}

	public void setEmergencyaddr(String emergencyaddr) {
		this.emergencyaddr = emergencyaddr;
	}

	public String getPermaaddr() {
		return permaaddr;
	}

	public void setPermaaddr(String permaaddr) {
		this.permaaddr = permaaddr;
	}

	public String getPlaceofreporting() {
		return placeofreporting;
	}

	public void setPlaceofreporting(String placeofreporting) {
		this.placeofreporting = placeofreporting;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}


	
	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getReleve_Date() {
		return releve_Date;
	}

	public void setReleve_Date(Date releve_Date) {
		this.releve_Date = releve_Date;
	}

	public byte[] getQr() {
		return qr;
	}

	public void setQr(byte[] qr) {
		this.qr = qr;
	}

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

	public String getPan_Number() {
		return pan_Number;
	}

	public void setPan_Number(String pan_Number) {
		this.pan_Number = pan_Number;
	}

	public String getAadar_Number() {
		return aadar_Number;
	}

	public void setAadar_Number(String aadar_Number) {
		this.aadar_Number = aadar_Number;
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