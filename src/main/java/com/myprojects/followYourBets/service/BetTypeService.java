package com.myprojects.followYourBets.service;

import java.util.List;

import com.myprojects.followYourBets.domain.BetType;

public interface BetTypeService {
	
	public void save(BetType betType);
	public void delete(BetType betType);
	public void deleteAll();
	public List<BetType> getAll();
	public List<BetType> getBetTypesLikeType(String name) throws Exception;	

}
