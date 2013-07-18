package com.myprojects.followYourBets.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.domain.Tournament;

@Repository("tournamentDao")
@Transactional
public class TournamentDaoImplHibernate extends AbstractHibernateDao<Tournament, Long> implements TournamentDao {

	@Override
	public void save(Tournament tournament) {
		
		getHibernateTemplate().save(tournament);
	}

	@Override
	public void delete(Tournament tournament) {
		
		getHibernateTemplate().delete(tournament);
	}

	@Override
	public void deleteAll() {
		
		String hql = String.format("delete from " + getDomainClass().getName());
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	protected Class<Tournament> getDomainClass() {
		
		return Tournament.class;
	}

	@Override
	public List<Tournament> getAll() {
		
		return getHibernateTemplate().loadAll(getDomainClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tournament> getTournamentsLikeName(String name) {
		
		return getHibernateTemplate().getSessionFactory().getCurrentSession().getNamedQuery("getTournamentsLikeName").setParameter("name", "%" + name + "%").list();
	}

}
