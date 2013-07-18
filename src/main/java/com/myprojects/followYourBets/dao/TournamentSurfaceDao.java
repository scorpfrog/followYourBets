package com.myprojects.followYourBets.dao;

import java.util.List;

import com.myprojects.followYourBets.domain.TournamentSurface;

public interface TournamentSurfaceDao {

	public void save(TournamentSurface tournamentSurface);
	public void delete(TournamentSurface tournamentSurface);
	public void deleteAll();
	public List<TournamentSurface> getAll();
	public TournamentSurface getByName(String name);
}
