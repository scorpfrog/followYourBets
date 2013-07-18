package com.myprojects.followYourBets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.dao.BetDao;
import com.myprojects.followYourBets.domain.Bet;

@Service
@Transactional
public class BetServiceImpl implements BetService {
	
	@Autowired
	@Qualifier("betDao")
	BetDao betDao ;

	@Override
	public void saveBet(Bet bet) {
		
		betDao.save(bet) ;
	}

	@Override
	public void deleteBet(Bet bet) {
		
		betDao.delete(bet) ;
	}

}
