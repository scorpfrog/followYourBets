package com.myprojects.followYourBets.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "player")
@NamedQueries({
	@NamedQuery(name = "getAllOrdered", query = "from Player p order by p.name asc"),
	@NamedQuery(name = "getPlayersLikeName", query = "from Player p where p.name like :name")
})
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "player_id")
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "country")
	private String country ;
	
	@Column(name = "bornDate")
	private Date bornDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	
	
}
