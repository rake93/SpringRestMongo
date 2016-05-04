package com.infosys.rakesh.springmongo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class AEVotrTurnOuts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571318200623524854L;

	@Id
	private String id;
	private String state;
	private int year;
	private int male;
	private int female;
	private int total;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "AEVotrTurnOuts [id=" + id + ", state=" + state + ", year=" + year + ", male=" + male + ", female="
				+ female + ", total=" + total + "]";
	}

}
