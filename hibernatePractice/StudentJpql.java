package com.te.hibernatePractice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
public class StudentJpql implements Serializable {
	@Id
	private int roll_no;
	private String name;
	private long phn_no;
	private String standard;
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhn_no() {
		return phn_no;
	}
	public void setPhn_no(long phn_no) {
		this.phn_no = phn_no;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public StudentJpql(int roll_no, String name, long phn_no, String standard) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.phn_no = phn_no;
		this.standard = standard;
	}
	public StudentJpql() {
		super();
		// TODO Auto-generated constructor stub
	}

}