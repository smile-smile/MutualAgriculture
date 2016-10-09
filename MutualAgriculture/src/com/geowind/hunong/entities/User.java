package com.geowind.hunong.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "mutualagriculture")
public class User implements java.io.Serializable {

	// Fields

	private String username;
	private Center center;
	private String password;
	private String realname;
	private String sex;
	private Date birthday;
	private String age;
	private String phone;
	private Integer type;
	private String picture;
	private String address;
	private String credit;
	private Integer valid;
	private Set<Farmland> farmlands = new HashSet<Farmland>(0);
	private Set<Task> tasks = new HashSet<Task>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, Center center, String password,
			String realname, String sex, Date birthday, String phone,
			Integer type, String address) {
		this.username = username;
		this.center = center;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.type = type;
		this.address = address;
	}

	/** full constructor */
	public User(String username, Center center, String password,
			String realname, String sex, Date birthday, String phone,
			Integer type, String picture, String address, String credit,
			Integer valid, Set<Farmland> farmlands, Set<Task> tasks) {
		this.username = username;
		this.center = center;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
		this.type = type;
		this.picture = picture;
		this.address = address;
		this.credit = credit;
		this.valid = valid;
		this.farmlands = farmlands;
		this.tasks = tasks;
	}

	// Property accessors
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId", nullable = false)
	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "realname", nullable = false, length = 45)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "sex", nullable = false, length = 45)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "picture", length = 200)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "address", nullable = false, length = 80)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "credit", length = 45)
	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Column(name = "valid")
	public Integer getValid() {
		return this.valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Farmland> getFarmlands() {
		return this.farmlands;
	}

	public void setFarmlands(Set<Farmland> farmlands) {
		this.farmlands = farmlands;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", center=" + center
				+ ", password=" + password + ", realname=" + realname
				+ ", sex=" + sex + ",age=" + age + ", birthday=" + birthday + ", phone="
				+ phone + ", type=" + type + ", picture=" + picture
				+ ", address=" + address + ", credit=" + credit + ", valid="
				+ valid + ", farmlands=" + farmlands + ", tasks=" + tasks + "]";
	}

	
}