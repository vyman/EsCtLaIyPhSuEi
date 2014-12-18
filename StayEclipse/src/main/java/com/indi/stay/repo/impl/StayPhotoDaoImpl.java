package com.indi.stay.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.StayPhotos;
import com.indi.stay.repo.StayPhotoDao;


@Repository
@Transactional
public class StayPhotoDaoImpl implements StayPhotoDao {
	
	private static final Log log = LogFactory.getLog(StayPhotoDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StayPhotos transientInstance) {
		log.debug("persisting StayPhotos instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StayPhotos persistentInstance) {
		log.debug("removing StayPhotos instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StayPhotos merge(StayPhotos detachedInstance) {
		log.debug("merging StayPhotos instance");
		try {
			StayPhotos result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StayPhotos findById(int id) {
		log.debug("getting StayPhotos instance with id: " + id);
		try {
			StayPhotos instance = entityManager.find(StayPhotos.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
