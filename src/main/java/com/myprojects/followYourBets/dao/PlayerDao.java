package com.myprojects.followYourBets.dao;

import java.util.List;

import com.myprojects.followYourBets.domain.Player;
import com.myprojects.followYourBets.domain.Tournament;

public interface PlayerDao {

	public void save(Player player);
	public void delete(Player player);
	public void deleteAll();
	public List<Player> getAll();
	public List<Player> getPlayersLikeName(String name) throws Exception;
}
