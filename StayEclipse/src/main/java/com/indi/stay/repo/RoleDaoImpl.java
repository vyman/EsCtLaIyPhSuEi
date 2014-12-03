package com.indi.stay.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private EntityManager em;

	@Override
	public Role findById(Integer id) {
		return em.find(Role.class, id);
	}

	@Override
	public List<Role> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Role> criteria = cb.createQuery(Role.class);
		Root<Role> role = criteria.from(Role.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe criteria queries, a new
		 * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(role).orderBy(cb.asc(role.get("role")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Role role) {
		em.persist(role);
		return;

	}
	
	@Override
	public Role findRole(String role) {
		try{
		Query queryString=em.createQuery("SELECT r FROM Role r WHERE r.role=:role");
		queryString.setParameter("role", role);
		return (Role)queryString.getSingleResult();
		}catch(Exception e){
			return null;
		}

	}

}
