package com.myprojects.followYourBets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.dao.TournamentDao;
import com.myprojects.followYourBets.domain.Tournament;

@Service
@Transactional
public class TournamentServiceImpl implements TournamentService {
	
	@Autowired
	TournamentDao tournamentDao;

	@Override
	public void save(Tournament tournament) throws Exception {
		
		tournamentDao.save(tournament);
	}

	@Override
	public void delete(Tournament tournament) throws Exception {
		
		tournamentDao.delete(tournament);
	}

	@Override
	public void deleteAll() throws Exception {
		
		tournamentDao.deleteAll();
	}

	@Override
	public List<Tournament> getAll() throws Exception {
		
		return tournamentDao.getAll();
	}

	@Override
	public List<Tournament> getTournamentsLikeName(String name) throws Exception {
		
		return tournamentDao.getTournamentsLikeName(name);
	}

}
