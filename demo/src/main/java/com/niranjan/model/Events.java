package com.niranjan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
@Entity
@Table(name = "events")
public class Events 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventid;
	
	@Column(name = "phone_number")
    @Size(max = 100)
	private String title;
	@Column(name = "phone_number")
    @Size(max = 100)
	private String location;
	@Temporal(TemporalType.DATE)
    @Column(name = "eventdate")
	private Date eventdate;
	@Temporal(TemporalType.DATE)
    @Column(name = "remindertime")
	private Date remindertime;
	@Size(max = 2000)
	private String attendeelist;
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@NotNull
	@Column(name = "alertflag")
	private boolean alertflag;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Calendar calendar;
	
	public Events(long eventid,  String title, String location, String attendeelist, boolean alertflag, Date eventdate, Date remindertime)
	{
		super();
		this.eventid = eventid;
		this.title = title;
		this.location = location;
		this.attendeelist = attendeelist;
		this.alertflag = alertflag;
		this.remindertime = remindertime;
		this.eventdate = eventdate;
	}
	public long getEventid() {
		return eventid;
	}
	
	public String getTitle() {
		return title;
	}
	public String getLocation() {
		return location;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public Date getRemindertime() {
		return remindertime;
	}
	public String getAttendeelist() {
		return attendeelist;
	}
	public boolean isAlertflag() {
		return alertflag;
	}
	public void setEventid(long eventid) {
		this.eventid = eventid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	public void setRemindertime(Date remindertime) {
		this.remindertime = remindertime;
	}
	public void setAttendeelist(String attendeelist) {
		this.attendeelist = attendeelist;
	}
	public void setAlertflag(boolean alertflag) {
		this.alertflag = alertflag;
	}
}
