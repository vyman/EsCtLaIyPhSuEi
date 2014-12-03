package com.indi.stay.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Facility;
import com.indi.stay.domain.SuiteType;


@Repository
@Transactional
public class FacilityDaoImpl implements FacilityDao {
	


	private static final Log log = LogFactory.getLog(FacilityDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Facility transientInstance) {
		log.debug("persisting Facility instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Facility persistentInstance) {
		log.debug("removing Facility instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Facility merge(Facility detachedInstance) {
		log.debug("merging Facility instance");
		try {
			Facility result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Facility findById(int id) {
		log.debug("getting Facility instance with id: " + id);
		try {
			Facility instance = entityManager.find(Facility.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Facility> findAllOrderedByName()
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Facility> criteria = cb.createQuery(Facility.class);
		Root<Facility> facilityRoot = criteria.from(Facility.class);
		criteria.select(facilityRoot).orderBy(cb.asc(facilityRoot.get("equipment")));
		return entityManager.createQuery(criteria).getResultList();
	}

}
