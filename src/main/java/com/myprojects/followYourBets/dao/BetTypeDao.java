package com.myprojects.followYourBets.dao;

import java.util.List;

import com.myprojects.followYourBets.domain.BetType;

public interface BetTypeDao {
	
	public void save(BetType betType);
	public void delete(BetType betType);
	public void deleteAll();
	public List<BetType> getAll();
	public List<BetType> getBetTypesLikeType(String name) throws Exception;

}
