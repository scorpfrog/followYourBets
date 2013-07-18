package com.myprojects.followYourBets.dao;

import java.util.List;

import com.myprojects.followYourBets.domain.Tournament;

public interface TournamentDao {

	public void save(Tournament tournament) throws Exception;
	public void delete(Tournament tournament) throws Exception;
	public void deleteAll() throws Exception;
	public List<Tournament> getAll() throws Exception;
	public List<Tournament> getTournamentsLikeName(String name) throws Exception;
}
