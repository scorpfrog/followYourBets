package com.myprojects.followYourBets.service;

import java.util.List;

import com.myprojects.followYourBets.domain.TournamentSurface;

public interface TournamentSurfaceService {

	public void save(TournamentSurface tournamentSurface);
	public void delete(TournamentSurface tournamentSurface);
	public void deleteAll();
	public List<TournamentSurface> getAll();
	public TournamentSurface getByName(String name);
}
