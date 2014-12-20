package com.indi.stay.repo.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.StayNearbyPlaces;
import com.indi.stay.repo.StayNearByPlaceDao;


@Repository
@Transactional
public class StayNearByPlaceDaoImpl implements StayNearByPlaceDao {
	


	private static final Log log = LogFactory.getLog(StayNearByPlaceDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StayNearbyPlaces transientInstance) {
		log.debug("persisting StayNearbyPlaces instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StayNearbyPlaces persistentInstance) {
		log.debug("removing StayNearbyPlaces instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StayNearbyPlaces merge(StayNearbyPlaces detachedInstance) {
		log.debug("merging StayNearbyPlaces instance");
		try {
			StayNearbyPlaces result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StayNearbyPlaces findById(int id) {
		log.debug("getting StayNearbyPlaces instance with id: " + id);
		try {
			StayNearbyPlaces instance = entityManager.find(
					StayNearbyPlaces.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StayNearbyPlaces> stayFindNearByPlacesByStayId(int stayId){
		log.debug("getting StaySuite instance with id: " + stayId);
		try {
			
			Query queryString=entityManager.createQuery("SELECT s FROM StayNearbyPlaces s JOIN s.stay stay WHERE stay.id=:stayId");
			queryString.setParameter("stayId", stayId);
			return (List<StayNearbyPlaces>)queryString.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
