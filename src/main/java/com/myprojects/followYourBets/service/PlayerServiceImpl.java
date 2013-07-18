package com.myprojects.followYourBets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.dao.PlayerDao;
import com.myprojects.followYourBets.domain.Player;
import com.myprojects.followYourBets.domain.Tournament;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	@Qualifier("playerDao")
	PlayerDao playerDao ;

	@Override
	public void savePlayer(Player player) {
		
		playerDao.save(player);
	}

	@Override
	public void deletePlayer(Player player) {
		
		playerDao.delete(player); 
	}

	@Override
	public void deleteAll() {
		
		playerDao.deleteAll();
	}

	@Override
	public List<Player> getAll() {
		
		return playerDao.getAll();
	}

	@Override
	public List<Player> getPlayersLikeName(String name)
			throws Exception {
		
		return playerDao.getPlayersLikeName(name);
	}

}
