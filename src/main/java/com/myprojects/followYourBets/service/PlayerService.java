package com.myprojects.followYourBets.service;

import java.util.List;

import com.myprojects.followYourBets.domain.Player;
import com.myprojects.followYourBets.domain.Tournament;

public interface PlayerService {

	public void savePlayer (Player player) ;
	public void deletePlayer (Player player) ;
	public void deleteAll();
	public List<Player> getAll();
	public List<Player> getPlayersLikeName(String name) throws Exception;
}
