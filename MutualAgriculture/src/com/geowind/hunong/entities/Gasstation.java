package com.geowind.hunong.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gasstation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gasstation", catalog = "mutualagriculture")
public class Gasstation implements java.io.Serializable {

	// Fields

	private Integer gid;
	private Double longitude;
	private Double latitude;

	// Constructors

	/** default constructor */
	public Gasstation() {
	}

	/** full constructor */
	public Gasstation(Double longitude, Double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gid", unique = true, nullable = false)
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@Column(name = "longitude", precision = 22, scale = 0)
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", precision = 22, scale = 0)
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}