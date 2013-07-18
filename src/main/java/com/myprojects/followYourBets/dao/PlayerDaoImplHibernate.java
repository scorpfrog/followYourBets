package com.myprojects.followYourBets.dao;



import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.followYourBets.domain.Player;

@Repository("playerDao")
@Transactional
public class PlayerDaoImplHibernate extends AbstractHibernateDao<Player, Long> implements PlayerDao {
	
	@Override
	protected Class<Player> getDomainClass() {
		
		return Player.class;
	}

	@Override
	public void save(Player player) {
		
		getHibernateTemplate().save(player);
	}

	@Override
	public void delete(Player player) {
	
		getHibernateTemplate().delete(player);
	}
	
	@Override
	public void deleteAll() {
		
		String hql = String.format("delete from " + getDomainClass().getName());
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAll() {
		
		return (List<Player>) getHibernateTemplate().getSessionFactory().getCurrentSession().getNamedQuery("getAllOrdered").list();
		//return getHibernateTemplate().loadAll(getDomainClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayersLikeName(String name) throws Exception {
		 
		return (List<Player>) getHibernateTemplate().getSessionFactory().getCurrentSession().getNamedQuery("getPlayersLikeName").setString("name", "%" + name + "%").list();
	}

}
