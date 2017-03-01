package com.geowind.hunong.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.google.gson.annotations.Expose;

/**
 * Block entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "block", catalog = "mutualagriculture", uniqueConstraints = @UniqueConstraint(columnNames = "bname"))
public class Block implements java.io.Serializable {

	// Fields
	@Expose
	private Integer bid;
	@Expose
	private Zone zone;
	@Expose
	private String bname;
	@Expose
	private Double area;
	@Expose
	private String address;
	@Expose
	private Integer valid;
	@Expose (serialize = false, deserialize = false)
	private Set<Aiplanning> aiplannings = new HashSet<Aiplanning>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Farmland> farmlands = new HashSet<Farmland>(0);

	// Constructors

	/** default constructor */
	public Block() {
	}

	/** minimal constructor */
	public Block(Zone zone, String bname) {
		this.zone = zone;
		this.bname = bname;
	}

	/** full constructor */
	public Block(Zone zone, String bname, Double area, String address,
			Integer valid, Set<Aiplanning> aiplannings, Set<Farmland> farmlands) {
		this.zone = zone;
		this.bname = bname;
		this.area = area;
		this.address = address;
		this.valid = valid;
		this.aiplannings = aiplannings;
		this.farmlands = farmlands;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bid", unique = true, nullable = false)
	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zoneId", nullable = false)
	public Zone getZone() {
		return this.zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Column(name = "bname", unique = true, nullable = false, length = 45)
	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Column(name = "area", precision = 22, scale = 0)
	public Double getArea() {
		return this.area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "valid")
	public Integer getValid() {
		return this.valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "block")
	public Set<Aiplanning> getAiplannings() {
		return this.aiplannings;
	}

	public void setAiplannings(Set<Aiplanning> aiplannings) {
		this.aiplannings = aiplannings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "block")
	public Set<Farmland> getFarmlands() {
		return this.farmlands;
	}

	public void setFarmlands(Set<Farmland> farmlands) {
		this.farmlands = farmlands;
	}

}