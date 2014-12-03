package com.indi.stay.domain;

// Generated 13 Jun, 2014 7:51:31 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SuiteType generated by hbm2java
 */
@Entity
//@Table(name = "suite_type", catalog = "stay001")
public class SuiteType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	private Set<StaySuite> staySuites = new HashSet<StaySuite>(0);

	public SuiteType() {
	}

	public SuiteType(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public SuiteType(int id, String type, Set<StaySuite> staySuites) {
		this.id = id;
		this.type = type;
		this.staySuites = staySuites;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "suiteType")
	public Set<StaySuite> getStaySuites() {
		return this.staySuites;
	}

	public void setStaySuites(Set<StaySuite> staySuites) {
		this.staySuites = staySuites;
	}

}
