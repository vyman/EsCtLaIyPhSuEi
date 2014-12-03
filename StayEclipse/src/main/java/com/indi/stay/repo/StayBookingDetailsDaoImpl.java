package com.indi.stay.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.StayBookingDetails;


@Repository
@Transactional
public class StayBookingDetailsDaoImpl implements StayBookingDetailsDao {

	private static final Log log = LogFactory
			.getLog(StayBookingDetailsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StayBookingDetails transientInstance) {
		log.debug("persisting StayBookingDetails instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StayBookingDetails persistentInstance) {
		log.debug("removing StayBookingDetails instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StayBookingDetails merge(StayBookingDetails detachedInstance) {
		log.debug("merging StayBookingDetails instance");
		try {
			StayBookingDetails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StayBookingDetails findById(int id) {
		log.debug("getting StayBookingDetails instance with id: " + id);
		try {
			StayBookingDetails instance = entityManager.find(
					StayBookingDetails.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
