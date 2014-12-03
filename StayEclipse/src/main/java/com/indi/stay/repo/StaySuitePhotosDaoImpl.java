package com.indi.stay.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.indi.stay.domain.StaySuitePhotos;

@Repository
@Transactional
public class StaySuitePhotosDaoImpl implements StaySuitePhotosDao {

	private static final Log log = LogFactory.getLog(StaySuitePhotosDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StaySuitePhotos transientInstance) {
		log.debug("persisting Staysuitephotos instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StaySuitePhotos persistentInstance) {
		log.debug("removing Staysuitephotos instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StaySuitePhotos merge(StaySuitePhotos detachedInstance) {
		log.debug("merging Staysuitephotos instance");
		try {
			StaySuitePhotos result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StaySuitePhotos findById(int id) {
		log.debug("getting Staysuitephotos instance with id: " + id);
		try {
			StaySuitePhotos instance = entityManager.find(
					StaySuitePhotos.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
