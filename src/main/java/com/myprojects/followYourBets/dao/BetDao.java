package com.myprojects.followYourBets.dao;

import com.myprojects.followYourBets.domain.Bet;

public interface BetDao {
	
	public void save(Bet bet);
	public void delete(Bet bet);

}
