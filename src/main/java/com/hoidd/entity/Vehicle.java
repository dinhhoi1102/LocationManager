package com.hoidd.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
//@Table(name="vehicle")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(length=255)
	private String name;
	
	@Column(length=255)
	private String image;

	@OneToMany(mappedBy="vehicle", targetEntity = Technician.class, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("vehicle")
	private Set<Technician> listUser;
	
	
	public Vehicle() {
	}
	

	public Vehicle(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Vehicle(Integer id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Set<Technician> getListUser() {
		return listUser;
	}


	public void setListUser(Set<Technician> listUser) {
		this.listUser = listUser;
	}

	



	
	

}