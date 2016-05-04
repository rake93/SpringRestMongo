package com.infosys.rakesh.springmongo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class AEPartiesCntests implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4765282518488335715L;

	@Id
	private String id;
	private String state;
	private int year;
	private int parties_contested;
	private int parties_represented;
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
	public int getParties_contested() {
		return parties_contested;
	}
	public void setParties_contested(int parties_contested) {
		this.parties_contested = parties_contested;
	}
	public int getParties_represented() {
		return parties_represented;
	}
	public void setParties_represented(int parties_represented) {
		this.parties_represented = parties_represented;
	}
	@Override
	public String toString() {
		return "AEPartiesCntests [id=" + id + ", state=" + state + ", year=" + year + ", parties_contested="
				+ parties_contested + ", parties_represented=" + parties_represented + "]";
	}
	
	
}
