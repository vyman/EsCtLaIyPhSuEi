package com.indi.stay.domain;

// Generated 13 Jun, 2014 7:51:31 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StayNearbyPlaces generated by hbm2java
 */
@Entity
//@Table(name = "stay_nearby_places", catalog = "stay001")
public class StayNearbyPlaces implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Stay stay;
	private String placeName;
	private String discription;
	private String distance;
	private String photo;

	public StayNearbyPlaces() {
	}

	public StayNearbyPlaces(int id, Stay stay, String placeName,
			String discription, String distance, String photo) {
		this.id = id;
		this.stay = stay;
		this.placeName = placeName;
		this.discription = discription;
		this.distance = distance;
		this.photo = photo;
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
	@JoinColumn(name = "stay_id", nullable = false)
	public Stay getStay() {
		return this.stay;
	}

	public void setStay(Stay stay) {
		this.stay = stay;
	}

	@Column(name = "place_name", nullable = false, length = 50)
	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Column(name = "discription", nullable = false, length = 50)
	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Column(name = "distance", nullable = false, length = 50)
	public String getDistance() {
		return this.distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Column(name = "photo", nullable = false, length = 200)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
