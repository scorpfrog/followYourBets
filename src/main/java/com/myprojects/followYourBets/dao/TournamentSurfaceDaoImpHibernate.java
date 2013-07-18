package com.myprojects.followYourBets.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.domain.TournamentSurface;

@Repository("tournamentSurfaceDao")
@Transactional
public class TournamentSurfaceDaoImpHibernate extends AbstractHibernateDao<TournamentSurface, Long> implements TournamentSurfaceDao {

	@Override
	public void save(TournamentSurface tournamentSurface) {
		
		getHibernateTemplate().save(tournamentSurface);
	}

	@Override
	public void delete(TournamentSurface tournamentSurface) {

		getHibernateTemplate().delete(tournamentSurface);
	}

	@Override
	public void deleteAll() {
		
		String hql = String.format("delete from " + getDomainClass().getName());
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	protected Class<TournamentSurface> getDomainClass() {
		
		return TournamentSurface.class;
	}

	@Override
	public List<TournamentSurface> getAll() {

		return getHibernateTemplate().loadAll(TournamentSurface.class);
	}

	@Override
	public TournamentSurface getByName(String name) {
		
		return (TournamentSurface) getHibernateTemplate().getSessionFactory().getCurrentSession().getNamedQuery("getTournamentSurfaceByName").setString("name", name).uniqueResult();
	}

}
