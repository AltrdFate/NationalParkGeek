package com.techelevator.npgeek.model;

public class SurveyPost {

	private Long surveyid;
	private String parkcode;
	private String emailaddress;
	private String state;
	private String activitylevel;
	
	
	public SurveyPost(){
		
	}


	public Long getSurveyid() {
		return surveyid;
	}


	public void setSurveyid(Long surveyid) {
		this.surveyid = surveyid;
	}


	public String getParkcode() {
		return parkcode;
	}


	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}


	public String getEmailaddress() {
		return emailaddress;
	}


	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getActivitylevel() {
		return activitylevel;
	}


	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}
}
