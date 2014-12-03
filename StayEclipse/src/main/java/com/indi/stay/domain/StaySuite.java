package com.indi.stay.domain;

// Generated 13 Jun, 2014 7:51:31 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StaySuite generated by hbm2java
 */
@Entity
//@Table(name = "stay_suite", catalog = "stay001")
public class StaySuite implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Stay stay;
	private SuiteType suiteType;
	private String discription;
	private int numberOfAvilableRooms;
	private Double price;
	private String suiteCode;
	private Set<Facility> facilities = new HashSet<Facility>(0);
	private Set<StayBookingDetails> stayBookingDetailses = new HashSet<StayBookingDetails>(0);
	private Set<StaySuitePhotos> staysuitephotoses = new HashSet<StaySuitePhotos>(0);

	public StaySuite() {
	}

	public StaySuite(int id, Stay stay, SuiteType suiteType,
			String discription, String suiteCode,int numberOfAvilableRooms,Double price) {
		this.id = id;
		this.stay = stay;
		this.suiteType = suiteType;
		this.discription = discription;
		this.suiteCode = suiteCode;
		this.numberOfAvilableRooms=numberOfAvilableRooms;
		this.price=price;
	}

	public StaySuite(int id, Stay stay, SuiteType suiteType,
			String discription, String suiteCode, Set<Facility> facilities,
			Set<StayBookingDetails> stayBookingDetailses, Set<StaySuitePhotos> staysuitephotoses) {
		this.id = id;
		this.stay = stay;
		this.suiteType = suiteType;
		this.discription = discription;
		this.suiteCode = suiteCode;
		this.facilities = facilities;
		this.stayBookingDetailses = stayBookingDetailses;
		this.staysuitephotoses = staysuitephotoses;
	}

	@Id
	@Column(name = "staysuite_id", unique = true, nullable = false)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "suite_type", nullable = false)
	public SuiteType getSuiteType() {
		return this.suiteType;
	}

	public void setSuiteType(SuiteType suiteType) {
		this.suiteType = suiteType;
	}

	@Column(name = "discription", nullable = false, length = 50)
	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Column(name = "suite_code", nullable = false, length = 50)
	public String getSuiteCode() {
		return this.suiteCode;
	}

	public void setSuiteCode(String suiteCode) {
		this.suiteCode = suiteCode;
	}
	
	
	@Column(name = "number_of_avilable_rooms", nullable = false)
	public int getNumberOfAvilableRooms() {
		return numberOfAvilableRooms;
	}

	public void setNumberOfAvilableRooms(int numberOfAvilableRooms) {
		this.numberOfAvilableRooms = numberOfAvilableRooms;
	}

	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stay_suite_facility", joinColumns = { 
			@JoinColumn(name = "staysuite_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "facility_id", 
					nullable = false, updatable = false) })
	public Set<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staysuite")
	public Set<StayBookingDetails> getStayBookingDetailses() {
		return this.stayBookingDetailses;
	}

	public void setStayBookingDetailses(Set<StayBookingDetails> stayBookingDetailses) {
		this.stayBookingDetailses = stayBookingDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staysuite")
	public Set<StaySuitePhotos> getStaysuitephotoses() {
		return this.staysuitephotoses;
	}

	public void setStaysuitephotoses(Set<StaySuitePhotos> staysuitephotoses) {
		this.staysuitephotoses = staysuitephotoses;
	}
}
