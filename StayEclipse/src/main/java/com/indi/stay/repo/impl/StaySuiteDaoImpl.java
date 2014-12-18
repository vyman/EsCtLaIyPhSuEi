package com.indi.stay.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.StaySuite;
import com.indi.stay.repo.StaySuiteDao;



@Repository
@Transactional
public class StaySuiteDaoImpl implements StaySuiteDao{
	
	private static final Log log = LogFactory.getLog(StaySuiteDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StaySuite transientInstance) {
		log.debug("persisting StaySuite instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StaySuite persistentInstance) {
		log.debug("removing StaySuite instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public StaySuite merge(StaySuite detachedInstance) {
		log.debug("merging StaySuite instance");
		try {
			StaySuite result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public StaySuite findById(int id) {
		log.debug("getting StaySuite instance with id: " + id);
		try {
			StaySuite instance = entityManager.find(StaySuite.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StaySuite> findstaySuitesByStayId(int stayId){
		log.debug("getting StaySuite instance with saty id: " + stayId);
		try {
			
			Query queryString=entityManager.createQuery("SELECT s FROM StaySuite s JOIN s.stay stay WHERE stay.id=:stayId");
			queryString.setParameter("stayId", stayId);
			return (List<StaySuite>)queryString.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
