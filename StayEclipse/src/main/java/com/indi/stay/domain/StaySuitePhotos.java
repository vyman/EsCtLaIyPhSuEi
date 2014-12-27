package com.indi.stay.domain;

// Generated 29 Jun, 2014 2:35:14 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Staysuitephotos generated by hbm2java
 */
@Entity
//@Table(name = "staysuitephotos", catalog = "stay001")
public class StaySuitePhotos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private StaySuite staysuite;
	private String imagepath;
	private String discription;

	public StaySuitePhotos() {
	}

	public StaySuitePhotos(int id, StaySuite staysuite, String imagepath) {
		this.id = id;
		this.staysuite = staysuite;
		this.imagepath = imagepath;
	}

	public StaySuitePhotos(int id, StaySuite staysuite, String imagepath,
			String discription) {
		this.id = id;
		this.staysuite = staysuite;
		this.imagepath = imagepath;
		this.discription = discription;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staysuite_id", nullable = false)
	public StaySuite getStaysuite() {
		return this.staysuite;
	}

	public void setStaysuite(StaySuite staysuite) {
		this.staysuite = staysuite;
	}

	@Column(name = "imagepath", nullable = false, length = 200)
	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Column(name = "discription", length = 50)
	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
