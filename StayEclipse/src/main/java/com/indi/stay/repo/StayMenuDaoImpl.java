package com.indi.stay.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.StayMenu;



@Repository
@Transactional
public class StayMenuDaoImpl implements StayMenuDao {

	private static final Log log = LogFactory.getLog(StayMenuDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StayMenu transientInstance) {
		log.debug("persisting StayMenu instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StayMenu persistentInstance) {
		log.debug("removing StayMenu instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StayMenu merge(StayMenu detachedInstance) {
		log.debug("merging StayMenu instance");
		try {
			StayMenu result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StayMenu findById(int id) {
		log.debug("getting StayMenu instance with id: " + id);
		try {
			StayMenu instance = entityManager.find(StayMenu.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public StayMenu findByStayId(int stayId) {
		log.debug("getting StayMenu instance with saty id: " + stayId);
		try {
			
			Query queryString=entityManager.createQuery("SELECT s FROM StayMenu s JOIN s.stay stay WHERE stay.id=:stayId");
			queryString.setParameter("stayId", stayId);
			return (StayMenu)queryString.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}
}
