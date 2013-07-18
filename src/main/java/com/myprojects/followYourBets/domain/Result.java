package com.myprojects.followYourBets.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "result_id")
	Long id ;
	
	@Column(name = "setOne")
	String setOne;
	@Column(name = "setTwo")
	String setTwo;
	@Column(name = "setThree")
	String setThree;
	@Column(name = "setFour")
	String setFour;
	@Column(name = "setFive")
	String setFive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSetOne() {
		return setOne;
	}
	public void setSetOne(String setOne) {
		this.setOne = setOne;
	}
	public String getSetTwo() {
		return setTwo;
	}
	public void setSetTwo(String setTwo) {
		this.setTwo = setTwo;
	}
	public String getSetThree() {
		return setThree;
	}
	public void setSetThree(String setThree) {
		this.setThree = setThree;
	}
	public String getSetFour() {
		return setFour;
	}
	public void setSetFour(String setFour) {
		this.setFour = setFour;
	}
	public String getSetFive() {
		return setFive;
	}
	public void setSetFive(String setFive) {
		this.setFive = setFive;
	}
	
	

}
