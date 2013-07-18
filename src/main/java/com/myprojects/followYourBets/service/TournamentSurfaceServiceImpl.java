package com.myprojects.followYourBets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.dao.TournamentSurfaceDao;
import com.myprojects.followYourBets.domain.TournamentSurface;

@Service
@Transactional
public class TournamentSurfaceServiceImpl implements TournamentSurfaceService {
	
	@Autowired
	TournamentSurfaceDao tournamentSurfaceDao;

	@Override
	public void save(TournamentSurface tournamentSurface) {
		
		tournamentSurfaceDao.save(tournamentSurface);
	}

	@Override
	public void delete(TournamentSurface tournamentSurface) {
		
		tournamentSurfaceDao.delete(tournamentSurface);
	}

	@Override
	public void deleteAll() {
		
		tournamentSurfaceDao.deleteAll();
	}

	@Override
	public List<TournamentSurface> getAll() {
		
		return tournamentSurfaceDao.getAll();
	}

	@Override
	public TournamentSurface getByName(String name) {
		
		return tournamentSurfaceDao.getByName(name);
	}

}
