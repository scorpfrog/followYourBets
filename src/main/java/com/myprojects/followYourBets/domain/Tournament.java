package com.myprojects.followYourBets.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "tournament")
@NamedQueries({
	@NamedQuery(name = "getTournamentsLikeName", query = "from Tournament t where t.name LIKE :name")
})
public class Tournament implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "tournament_id")
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tournament_surface_id", nullable = false)
	private TournamentSurface surface;
	
	@Column(name = "tournamentLevel")
	@Enumerated(EnumType.STRING)
	private TournamentLevel tournamentLevel;

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

	public TournamentSurface getSurface() {
		return surface;
	}

	public void setSurface(TournamentSurface surface) {
		this.surface = surface;
	}

	public TournamentLevel getTournamentLevel() {
		return tournamentLevel;
	}

	public void setTournamentLevel(TournamentLevel tournamentLevel) {
		this.tournamentLevel = tournamentLevel;
	}
}
