package com.myprojects.followYourBets.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_surface")
@NamedQueries({
	@NamedQuery(name = "getTournamentSurfaceByName", query = "from TournamentSurface ts where ts.name = :name")
})
public class TournamentSurface implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "tournament_surface_id")
	private Long id ;
	
	@Column(name = "name")
	private String name ;

	public TournamentSurface(TournamentSurface tournamentSurface) {
		
		this.id = tournamentSurface.id;
		this.name = tournamentSurface.name;
	}

	public TournamentSurface() {

	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentSurface other = (TournamentSurface) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentSurface [id=" + id + ", name=" + name + "]";
	}

	
	
}
