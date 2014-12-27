package com.indi.stay.repo.impl;

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

import com.indi.stay.domain.SuiteType;
import com.indi.stay.repo.SuiteTypeDao;


@Repository
@Transactional
public class SuiteTypeDaoImpl implements SuiteTypeDao {



	private static final Log log = LogFactory.getLog(SuiteTypeDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SuiteType transientInstance) {
		log.debug("persisting SuiteType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SuiteType persistentInstance) {
		log.debug("removing SuiteType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SuiteType merge(SuiteType detachedInstance) {
		log.debug("merging SuiteType instance");
		try {
			SuiteType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SuiteType findById(int id) {
		log.debug("getting SuiteType instance with id: " + id);
		try {
			SuiteType instance = entityManager.find(SuiteType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SuiteType> findAllOrderedByName()
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SuiteType> criteria = cb.createQuery(SuiteType.class);
		Root<SuiteType> suiteTypeRoot = criteria.from(SuiteType.class);
		criteria.select(suiteTypeRoot).orderBy(cb.asc(suiteTypeRoot.get("type")));
		return entityManager.createQuery(criteria).getResultList();
	}

}
