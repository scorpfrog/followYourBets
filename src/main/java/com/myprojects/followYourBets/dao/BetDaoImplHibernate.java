package com.myprojects.followYourBets.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.domain.Bet;

@Repository("betDao")
@Transactional
public class BetDaoImplHibernate extends AbstractHibernateDao<Bet, Long> implements BetDao {

	@Override
	protected Class<Bet> getDomainClass() {
		
		return Bet.class;
	}

	@Override
	public void save(Bet bet) {
		
		getHibernateTemplate().save(bet);
	}

	@Override
	public void delete(Bet bet) {
		
		getHibernateTemplate().delete(bet);
	}

}
