package com.myprojects.followYourBets.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.domain.BetType;

@Repository("betTypeDao")
@Transactional
public class BetTypeDaoImplHibernate extends AbstractHibernateDao<BetType, Long> implements BetTypeDao {
	
	@Override
	public void save(BetType betType) {
		
		getHibernateTemplate().save(betType);
	}
	
	@Override
	public void delete(BetType betType) {
		
		getHibernateTemplate().delete(betType);
	}

	@Override
	public List<BetType> getAll() {
		
		return getHibernateTemplate().loadAll(getDomainClass());
	}

	@Override
	public List<BetType> getBetTypesLikeType(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<BetType> getDomainClass() {
		
		return BetType.class;
	}

	
	
}
