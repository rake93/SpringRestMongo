package com.infosys.rakesh.springmongo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AECntstdDpstLost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7790747135958420901L;

	@Id
	private String id;
	private String state;
	private int year;
	private int total_candidates;
	private int deposit_saved;
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
	public int getTotal_candidates() {
		return total_candidates;
	}
	public void setTotal_candidates(int total_candidates) {
		this.total_candidates = total_candidates;
	}
	public int getDeposit_saved() {
		return deposit_saved;
	}
	public void setDeposit_saved(int deposit_saved) {
		this.deposit_saved = deposit_saved;
	}
	@Override
	public String toString() {
		return "AECntstdDpstLost [id=" + id + ", state=" + state + ", year=" + year + ", total_candidates="
				+ total_candidates + ", deposit_saved=" + deposit_saved + "]";
	}
	
	
}
