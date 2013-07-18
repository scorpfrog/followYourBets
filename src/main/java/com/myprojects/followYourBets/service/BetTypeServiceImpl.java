package com.myprojects.followYourBets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.dao.BetTypeDao;
import com.myprojects.followYourBets.domain.BetType;

@Service
@Transactional
public class BetTypeServiceImpl implements BetTypeService {
	 
	@Autowired
	private BetTypeDao betTypeDao;

	@Override
	public void save(BetType betType) {
		
		betTypeDao.save(betType);
	}

	@Override
	public void delete(BetType betType) {
		
		betTypeDao.delete(betType);
	}

	@Override
	public void deleteAll() {

		betTypeDao.deleteAll();
	}

	@Override
	public List<BetType> getAll() {

		return betTypeDao.getAll();
	}

	@Override
	public List<BetType> getBetTypesLikeType(String name) throws Exception {
		
		return betTypeDao.getBetTypesLikeType(name);
	}

}
