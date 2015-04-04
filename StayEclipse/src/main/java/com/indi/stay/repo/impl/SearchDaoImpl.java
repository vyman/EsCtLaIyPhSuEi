package com.indi.stay.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Stay;
import com.indi.stay.repo.SearchDao;

@Repository
@Transactional
public  class SearchDaoImpl implements SearchDao {

	private static final Log log = LogFactory.getLog(StayNearByPlaceDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Stay> findAll() {
		log.debug("getting Stay by popularity");
		try {

			Query queryString=entityManager.createQuery("SELECT s FROM Stay s JOIN FETCH  s.staySuites ss JOIN FETCH ss.suiteType st ");
			return (List<Stay>)queryString.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}
}
