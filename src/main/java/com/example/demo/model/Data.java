package com.example.demo.model;

import java.util.Date;

public class Data {
	private int Id;
   private String Subject;
 private Date   StartDate ;
 private Date   EndDate ;
 private boolean IsAllDay ;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getSubject() {
	return Subject;
}
public void setSubject(String subject) {
	Subject = subject;
}
public Date getStartDate() {
	return StartDate;
}
public void setStartDate(Date startDate) {
	StartDate = startDate;
}
public Date getEndDate() {
	return EndDate;
}
public void setEndDate(Date endDate) {
	EndDate = endDate;
}
public boolean isIsAllDay() {
	return IsAllDay;
}
public void setIsAllDay(boolean isAllDay) {
	IsAllDay = isAllDay;
}
public Data(int id, String subject, Date startDate, Date endDate, boolean isAllDay) {
	super();
	Id = id;
	Subject = subject;
	StartDate = startDate;
	EndDate = endDate;
	IsAllDay = isAllDay;
}
 



}

