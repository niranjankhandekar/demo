package com.niranjan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="calendar")
public class Calendar 
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @Size(max = 100)
    @Column(name = "name")
	private String name;
	
	@NotNull
    @Size(max = 100)
    @Column(name = "user")
	private String user;
	
	private List<Events> events;
	
	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "calendar")
	 private Events event;
	 
	 public Calendar(){}
	 
	public Calendar(long id, String name, String user, List<Events> events )
	{
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.events = events;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUser() {
		return user;
	}
	public List<Events> getEvents() {
		return events;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setEvents(List<Events> events) {
		this.events = events;
	}
	
	
}
