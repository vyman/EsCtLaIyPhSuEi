package com.indi.stay.domain;

// Generated 13 Jun, 2014 7:51:31 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StayPhotos generated by hbm2java
 */
@Entity
//@Table(name = "stay_photos", catalog = "stay001")
public class StayPhotos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Stay stay;
	private String photo;
	private String discription;

	public StayPhotos() {
	}

	public StayPhotos(int id, Stay stay, String photo, String discription) {
		this.id = id;
		this.stay = stay;
		this.photo = photo;
		this.discription = discription;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stay_id", nullable = false)
	public Stay getStay() {
		return this.stay;
	}

	public void setStay(Stay stay) {
		this.stay = stay;
	}

	@Column(name = "photo", nullable = false, length = 200)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "discription", nullable = false, length = 50)
	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
