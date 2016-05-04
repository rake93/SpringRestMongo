package com.infosys.rakesh.springmongo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class AEWomens implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5251108246713099419L;

	@Id
	private String id;
	private String state;
	private int year;
	private int women;
	private float percentage;

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

	public int getWomen() {
		return women;
	}

	public void setWomen(int women) {
		this.women = women;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "AEWomens [id=" + id + ", state=" + state + ", year=" + year + ", women=" + women + ", percentage="
				+ percentage + "]";
	}

}
