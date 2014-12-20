package com.indi.stay.repo.impl;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.UserRole;
import com.indi.stay.repo.UserRoleDao;

@Repository
@Transactional
public class UserRoleDaoImpl implements UserRoleDao{


	private static final Log log = LogFactory.getLog(UserRoleDaoImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public void persist(UserRole transientInstance) {
		log.debug("persisting Userrole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserRole persistentInstance) {
		log.debug("removing Userrole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserRole merge(UserRole detachedInstance) {
		log.debug("merging Userrole instance");
		try {
			UserRole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserRole findById(int id) {
		log.debug("getting Userrole instance with id: " + id);
		try {
			UserRole instance = entityManager.find(UserRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
