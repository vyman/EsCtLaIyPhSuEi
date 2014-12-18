package com.indi.stay.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Stay;
import com.indi.stay.repo.StayDao;

@Repository
@Transactional
public class StayDaoImpl implements StayDao{

	@Autowired
    private EntityManager entityManager;

	private static final Log log = LogFactory.getLog(StayDaoImpl.class);

	

	public void persist(Stay transientInstance) {
		log.debug("persisting Stay instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Stay persistentInstance) {
		log.debug("removing Stay instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Stay merge(Stay detachedInstance) {
		log.debug("merging Stay instance");
		try {
			Stay result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Stay findById(int id) {
		log.debug("getting Stay instance with id: " + id);
		try {
			Stay instance = entityManager.find(Stay.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Stay> findAllOrderedByName() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Stay> criteria = cb.createQuery(Stay.class);
        Root<Stay> stay = criteria.from(Stay.class);

        criteria.select(stay).orderBy(cb.asc(stay.get("stayname")));
        return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Stay> findAllOrderedByRating() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Stay> criteria = cb.createQuery(Stay.class);
        Root<Stay> stay = criteria.from(Stay.class);

        criteria.select(stay).orderBy(cb.desc(stay.get("rating")));
        return entityManager.createQuery(criteria).getResultList();
	}

}
